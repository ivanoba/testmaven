/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author ivano
 */


public class PoolConnection {
    
    public Connection conexion = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    
    // CONEXION CON DRIVER MANAGER
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ivanobaj", "Ud3v$22");
        } catch (Exception e) {
            System.out.println("[SqlServerConexion] Error al obtener la conexión");
            e.printStackTrace();
        }
        return con;
    }  
       
    
    @Override
    public String toString(){
        if(conexion == null){
            return "ConexionIsActive: " + false;
        } else {
            try {
                return "ConexionIsActive: " + conexion.isClosed();
            } catch (Exception ex) {
                return ex.toString();
            }
        }
    }
    
    /*
    public static Connection conectar(String JNDI) {
        Hashtable ht = new Hashtable();
        ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL, "t3://192.168.0.67:7001");
        
        String nJNDI = JNDI;
        Connection con = null;
        
       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");      
            Context ctx = new InitialContext(ht);
            DataSource ds = (DataSource) ctx.lookup(nJNDI); 

            if (ds != null){
                con = ds.getConnection();
            } else {
                System.out.println("No se encontro datasource");
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
            if(conexion != null) {
                cerrarConexion();
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(JNDI);
            if(ds != null) {
                this.conexion = ds.getConnection();
            } else {
                System.out.println("No se encontro datasource");
            }
        } catch (NamingException ex) {
            System.out.println("No se encontro el nombre del recurso: " + ex);
        } catch (Exception ex) {
            System.out.println("No se pudo obtener conexion: " + ex);
        }
    }
    
    */
    
    public ResultSet Consultar(String sql) throws SQLException {
        this.ps = conexion.prepareStatement(sql);
        this.rs = ps.executeQuery();
        return rs;
    }
    
    
    public void ExecUpIn(String update) throws SQLException {
        this.ps = null;
        this.ps = conexion.prepareStatement(update);
        this.ps.executeUpdate();
    }
    
    
    public void cerrarConexion() {
        try{
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(conexion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
