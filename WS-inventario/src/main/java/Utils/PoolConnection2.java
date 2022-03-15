/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.apache.commons.dbutils.DbUtils;

public class PoolConnection2 {

    public Connection conexion = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    
    @Override
    public String toString() {
        if (conexion == null) {
            return "ConexionIsActive: " + false;
        } else {
            try {
                return "ConexionIsActive: " + conexion.isClosed();
            } catch (Exception ex) {
                return ex.toString();
            }
        }
    }

    /**
     * Coneccion a BD por stringconection
     *
     * @param ip IP
     * @param puerto Puerto
     * @param servicio Servicio
     * @param usuario Usuario
     * @param pass Contrasenia
     * @return con Conneccion
     */
    /**
     * Coneccion a BD por JNDI
     *
     * @param JNDI JNDI
     * @return
     */
    
    public static Connection conectar(String JNDI) {

        String nJNDI = JNDI;
        Connection con = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(nJNDI);
            if (ds != null) {
                con = ds.getConnection();
            } else {
                System.out.println("No se encontró datasource");
            }
        } catch (NamingException ex) {
            System.out.println("No se encontró el nombre del recurso: " + ex);
        } catch (Exception ex) {
            System.out.println("No se pudo obtener conexión: " + ex);
        }

        return con;
    }

    public void conectarJNDI(String JNDI) {
        try {
            if (conexion != null) {
                cerrarConexion();
            }
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(JNDI);
            if (ds != null) {
                this.conexion = ds.getConnection();
            } else {
                System.out.println("No se encontró datasource");
            }
        } catch (NamingException ex) {
            System.out.println("No se encontró el nombre del recurso: " + ex);
        } catch (Exception ex) {
            System.out.println("No se pudo obtener conexión: " + ex);
        }

    }

    
    /**
     * Ejecuta la consulta recibida en la conexion abierta
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    
    public ResultSet Consultar(String sql) throws SQLException {
        this.ps = this.conexion.prepareStatement(sql);
        this.rs = this.ps.executeQuery();
        return rs;
    }

    /**
     * xx Ejecuta el update recibido
     *
     * @param update
     * @throws SQLException
     */
    public void ExecUpIn(String update) throws SQLException {
        this.ps = null;
        this.ps = this.conexion.prepareStatement(update);
        this.ps.executeUpdate();
    }
    
    public Integer Create(String update) throws SQLException {
        Integer id = 0;
        /*Statement st = this.conexion.createStatement();
        st.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
            System.out.println ("La clave para generar registros es:" + id);
        }*/
        
        
        /*
        this.ps = this.conexion.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
        this.ps.executeUpdate();
        
        ResultSet generatedKey = this.ps.getGeneratedKeys();
        while(generatedKey.next()){
            System.out.println("ID generado para factura: " + generatedKey.getInt(1));
        }*/
            
       // this.rs = this.ps.getGeneratedKeys();
        CallableStatement cs = this.conexion.prepareCall(update);
        cs.registerOutParameter(1, OracleTypes.NUMBER);
        cs.execute();
        id = cs.getInt(1);
        System.out.println(cs.getInt(1));
       
       
       
        return id;
    }

    /**
     * Cierra la conneccion
     */
    public void cerrarConexion() {
        try {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(conexion); //            if (this.rs != null) {
            //                    this.rs.close();
            //                    this.rs = null;
            //            }
            //            if (this.ps != null) {
            //                this.ps.close();
            //                this.ps = null;
            //            }
            //            if (this.conexion != null) {
            //                this.conexion.close();
            //                this.conexion = null;
            //            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
