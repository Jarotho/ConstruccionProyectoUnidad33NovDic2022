import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class leerArchivo {

    public static void main(String[] args) throws Exception {
        jsonReader();
    }
    
    
public static void jsonReader(){
    File archivo = new File("Empleados.json");
    if (archivo.exists()) {
        if (archivo.isFile()) System.out.println("Es un archivo");
        if (archivo.isDirectory()) System.out.println("Es una carpeta");
    }
    else {
        System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
    }

    
    Object ob;
    try {
        ob = new JSONParser().parse(new FileReader(archivo));
        JSONObject js = (JSONObject) ob;
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    

}



}
