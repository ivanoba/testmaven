
import Utils.Acknowledgement;
import Utils.PoolConnection2;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wsinventario.dao.beans.Pais;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONException;
import org.json.JSONObject;


@Path("Pais")
public class PaisServiceRest2 {
    
    PoolConnection2 DBcon = new PoolConnection2();
    Acknowledgement akno = new Acknowledgement();
    JSONObject response = new JSONObject();
    
    // crea nueva instancia de paiservice
    public PaisServiceRest2(){
        BasicConfigurator.configure();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(String content) throws JSONException {
        try {
            this.akno.setFunctionName("registrarPais");
            JSONObject group = new JSONObject(content);
            JSONObject req = group.getJSONObject(content);
            this.DBcon.conectarJNDI("jdbc/test");
            InsertarSSO(req);
            if(!this.akno.HasError()) {
                InsertarPais(req);
                if(!this.akno.HasError()){
                    this.akno.setDescription("Pais registrado exitosamente.");
                }  
            }
            this.response.put("AcknowledgementDescription", this.akno.getDescription());
            this.response.put("AcknowledgementIndicator", this.akno.getIndicator());
            this.response.put("Acknowledgement", this.akno.getCode());
            BasicConfigurator.resetConfiguration();
            return this.akno.ParseResponse(this.response);
        } catch (Exception ex) {
            this.akno.Error();
            this.akno.setDescription(ex.toString());
            
            this.response.put("AcknowledgementIndicator", this.akno.getIndicator());
            this.response.put("Acknowledgement", this.akno.getCode());
            this.response.put("AcknowledgementDescription", this.akno.getDescription());
            
            BasicConfigurator.resetConfiguration();
            return this.akno.ParseResponse(this.response);
        } finally {
            this.DBcon.cerrarConexion();
        } 
    }
    
    
    public void InsertarSSO(JSONObject req) {
        try {
            URL url = new URL("http://192.168.0.67:7001/WS-inventario-1.0-SNAPSHOT/rest/paises/registrarPais");
            HttpURLConnection conn;
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/json");
            
      
            JsonObject ReqSSO = new JsonObject();
            JsonObject Parameters = new JsonObject();
            JsonObject JsonPais = new JsonObject();
            
            JsonPais.addProperty("nombre", req.getString("nombre"));
            
            Parameters.addProperty("key", "Version");
            Parameters.addProperty("value", "Legacy");
            Parameters.addProperty("type", "java.lang.String");
            ReqSSO.addProperty("source", "wsinventario");
            ReqSSO.add("pais", JsonPais);
            ReqSSO.add("parameters", Parameters);
            
            Gson gson = new Gson();
            
            String output;
            String cont = "";
            int code = 0;
            String id = null;
            String description = null;
            
            JSONObject re = new JSONObject(cont);
            JSONObject reql = re.getJSONObject("error");
            
            this.DBcon.conectarJNDI("jdbc/test");
            this.DBcon.ExecUpIn("INSERT INTO IVANOBAJ.test_pais (nombre) VALUES ('" + ReqSSO.toString() + "')");
            
            if(code != 0 && cont.contains("Error, ese pais ya existe")) {
                
            }
            
            
        } catch(Exception e) {
            System.out.print(e.getMessage());
            this.akno.Error();
            this.akno.setDescription(e.toString());
        }
        
        
    }
    
    
    public void InsertarPais(JSONObject req){
        
    }
    
} 