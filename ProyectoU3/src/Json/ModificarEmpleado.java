package Json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ModificarEmpleado {
    private JSONArray arrayJSONobject;
    private JSONObject jsonObject;
    public ModificarEmpleado(){
        lecturaJson Json = new lecturaJson("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        arrayJSONobject = Json.getArrayJSONobject();
        jsonObject = Json.getJsonObject();
    }

    public boolean modificarEmpleado(String[] elementsEmployee){
        try{
            if(elementsEmployee[0].isEmpty() || arrayJSONobject.size()<Integer.parseInt(elementsEmployee[0])){
                return false;
            }
            else {
                boolean result = false;
                int i = 0;
                while (i < arrayJSONobject.size()){
                    JSONObject temp = (JSONObject) arrayJSONobject.get(i);
                    int x = Integer.parseInt((String) temp.get("id"));
                    if(x == Integer.parseInt(elementsEmployee[0])){
                        if (!elementsEmployee[1].isEmpty())temp.replace("firstName", elementsEmployee[1]);
                        if (!elementsEmployee[2].isEmpty())temp.replace("lastName", elementsEmployee[2]);
                        if (!elementsEmployee[3].isEmpty())temp.replace("photo", elementsEmployee[3]);
                        i = arrayJSONobject.size() + 2;
                        modificarJSon();
                        result = true;
                    }
                    i++;
                }
                return result;
            }
        }catch(NullPointerException | NumberFormatException e){
            return false;
        }
    }

    private void modificarJSon(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json"));
            String x = jsonObject.toString();
            bw.write("");
            bw.write(x);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getArrayJSONobject() {
        return arrayJSONobject;
    }
}
