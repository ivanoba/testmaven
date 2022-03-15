/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ivano
 */


public class Acknowledgement {

    private boolean Indicator;
    private String IndicatorCode = "SUC";
    private String Code;
    private String Description;
    private String FunctionName;
    private final PoolConnection2 DBcon = new PoolConnection2();

    public Acknowledgement() {
        this.Indicator = false;
        this.Code = null;
        this.Description = null;
        this.FunctionName = "";
    }

//    public void Success() {
//        this.Indicator = false;
//        this.IndicatorCode = "SUC";
//    }
    public void Error() {
        this.Indicator = true;
        this.IndicatorCode = "ERR";
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setFunctionName(String FuncName) {
        this.FunctionName = FuncName;
    }

    public String getIndicator() {
        if (this.Indicator) {
            return "ERROR";
        } else {
            return "SUCCESS";
        }
    }

    public boolean HasError() {
        return this.Indicator;
    }

    /**
     * Retorna el codigo Acknoledgement de la funcion
     *
     * @return
     */
    public String getCode() {
        try {

            this.DBcon.conectarJNDI("jdbc/test");
            String query = "select ACKNOWLEDGEMENT_ID, FUNCTINO_CODE, SERVICE_CODE from MC_BASE.CTG_ACKNOWLEDGEMENT where FUNCTION_NAME = '" + this.FunctionName + "'";
            ResultSet rs = this.DBcon.Consultar(query);

            if (rs.next()) {
                this.Code = "MCV2_" + rs.getString("SERVICE_CODE") + "_" + rs.getString("FUNCTINO_CODE")
                        + "_" + this.IndicatorCode + "_" + rs.getString("ACKNOWLEDGEMENT_ID");
                return this.Code;
            } else {
                System.out.print("La funcion no existe");
                return "0";
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return "0";
        } catch (Exception ex2) {
            return "0";
        } finally {
            this.DBcon.cerrarConexion();
        }
    }

    public String getDescription() {
        return this.Description;
    }

    public String ParseResponse(JSONObject obj) throws JSONException {
        JSONObject res = new JSONObject();
        res.put(this.FunctionName + "Response", obj);
        return res.toString();
    }

}

