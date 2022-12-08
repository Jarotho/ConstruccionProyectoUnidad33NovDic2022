package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EliminarEmpleado {
    private JSONArray arrayJSONobject;
    private JSONObject jsonObject;
    public EliminarEmpleado(){
        lecturaJson Json = new lecturaJson("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        arrayJSONobject = Json.getArrayJSONobject();
        jsonObject = Json.getJsonObject();
    }

    public boolean eliminarEmpleado(int indexToDelete){
        boolean result = false;
        int i = 0;
        while (i < arrayJSONobject.size()){
            JSONObject tempEmployee = (JSONObject) arrayJSONobject.get(i);
            int x = Integer.parseInt((String) tempEmployee.get("id"));
            if(x == indexToDelete){
                arrayJSONobject.remove(i);
                updateJSONFile();
                result = true;
            }
            i++;
        }
        return result;
    }

    private void updateJSONFile(){
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
