package Json;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarEmpleado {
    private JSONArray arrayJSONobject;
    private JSONObject jsonObject;
    public AgregarEmpleado(){
        lecturaJson v = new lecturaJson("Empleados.json");
        arrayJSONobject = v.getArrayJSONobject();
        jsonObject = v.getJsonObject();
    }

    public boolean insertEmployee(String[] elementsEmployee){
        try {
            int newID = Integer.parseInt(elementsEmployee[0]);
            boolean result = false;
            for (String employeeField : elementsEmployee){
                if(employeeField.isEmpty()){
                    return false;
                }
            }
            JSONObject employeeToAdd = new JSONObject();
            employeeToAdd.put("firstName",elementsEmployee[1]);
            employeeToAdd.put("lastName",elementsEmployee[2]);
            employeeToAdd.put("photo",elementsEmployee[3]);
            employeeToAdd.put("id",elementsEmployee[0]);
            updateJSONFile(employeeToAdd);
            return true;
        }catch (NumberFormatException e){
            return false;
        }



    }

    private void updateJSONFile(JSONObject newObject){
        arrayJSONobject.add(newObject);
        JSONObject newInnerJSON = new JSONObject();
        newInnerJSON.put("employee",arrayJSONobject);
        JSONObject newJSON = new JSONObject();
        newJSON.put("employees", newInnerJSON);
        System.out.println(newJSON);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Empleados.json"));
            String x = newJSON.toString();
            bw.write("");
            bw.write(x);
            bw.close();
            lecturaJson v = new lecturaJson("Empleados.json");
            arrayJSONobject = v.getArrayJSONobject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getArrayJSONobject() {
        return arrayJSONobject;
    }
}
