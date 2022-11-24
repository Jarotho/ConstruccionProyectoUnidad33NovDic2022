import GUI.Controlador.*;
import GUI.Vista.Vista;
import Json.*;

/**
 *
 * @author jonat
 */
public class App{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lecturaJson v = new lecturaJson("Empleados.json");
        convertidorEmpleado converter = new convertidorEmpleado();
        converter.convertJSONtoArray(v.getArrayJSONobject());

       Vista VistaPrincipal = new Vista();
        Controlador control = new Controlador(VistaPrincipal, converter.getarrayEmpleado());

        VistaPrincipal.setVisible(true);


    }
    
}