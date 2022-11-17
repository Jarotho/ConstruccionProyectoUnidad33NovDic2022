package Json;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class lecturaJson {

    private JSONArray arrayJSONobject;
    private JSONObject jsonObject;

    public static void main(String[] args) throws Exception {
    lecturaJson json = new lecturaJson();
    System.out.print(json.jsonReader("Empleados.json"));

    }

    
public boolean jsonReader(String jsonPath){ 
    File archivoJson = new File(jsonPath);  
    Object ob;

    try {
        ob = new JSONParser().parse(new FileReader(archivoJson));
        JSONObject js = (JSONObject) ob;
        this.jsonObject = js;
        return true;
    } catch (FileNotFoundException e) {
        System.out.println("El archivo no existe en el proyecto");
        return false;
    } catch(ParseException e){
        System.out.println("El archivo no cumple con el formato");
        return false;
    }catch (IOException e){
        System.out.println("Hubo un error al intentar acceder al archivo");
        return false;
    }
    

}


private boolean elementosExistentes(JSONObject employee){
    if(!employee.containsKey("id") || !employee.containsKey("firstName") || !employee.containsKey("lastName") || !employee.containsKey("photo")){
        return false;
    }else{
        if(employee.get("id")=="" || employee.get("firstName") == "" || employee.get("lastName")=="" || employee.get("photo") == ""){
           return false;
        }
    }
    return true;
}

public boolean extracEmployeeInfo(){
    JSONArray employeeList = arrayJSONobject;
    int i = 0; boolean result=true;
    for (Object exployye: employeeList) {
        JSONObject auxEmployee = (JSONObject) exployye;
        if(!elementosExistentes(auxEmployee)){
            i++;
            System.out.print("Algun atributo del empleado "+ i+" es incorrecto");
            result = false;
            break;
        }
        i++;
    }
    return result;
}


public JSONObject extractJSONObjectbyKey(String key){
    JSONObject employeeObject = new JSONObject();
    employeeObject = (JSONObject) jsonObject.get(key);
    try{
        JSONObject arr = (JSONObject) employeeObject.get(key);
    }catch(Exception e){
        System.out.println("No esta definido "+key+" en el archivo JSON\n");
    }
    return employeeObject;
}

public boolean extractEmployeeJSONArray(JSONObject jsonObj, String arrayName){
    JSONArray jsonArray = new JSONArray();
    jsonArray = (JSONArray) jsonObj.get(arrayName);
    try{
        jsonArray.isEmpty();
        arrayJSONobject = jsonArray;
    }catch(Exception e){
        System.out.println("No esta difnido "+arrayName+" como arreglo en el JSON");
        return false;
    }
    return true;
}


}
