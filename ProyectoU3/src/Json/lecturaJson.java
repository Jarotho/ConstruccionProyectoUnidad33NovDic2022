package Json;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class lecturaJson {

    public static void main(String[] args) throws Exception {
    lecturaJson json = new lecturaJson();
    System.out.print(json.jsonReader("Empleados.json"));

    }

    JSONObject jsonArchivo;
    
public boolean jsonReader(String jsonPath){ 
    File archivoJson = new File(jsonPath);  
    Object ob;

    try {
        ob = new JSONParser().parse(new FileReader(archivoJson));
        JSONObject js = (JSONObject) ob;
        this.jsonArchivo = js;
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




}
