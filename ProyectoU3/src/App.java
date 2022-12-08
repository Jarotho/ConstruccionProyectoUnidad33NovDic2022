import GUI.Controlador.*;
import Json.*;
import GUI.Vista.*;
public class App {

    public static void main(String[] args) {
        lecturaJson v = new lecturaJson("Empleados.json");
        convertidorEmpleado converter = new convertidorEmpleado();
        converter.convertJSONtoArray(v.getArrayJSONobject());

        Vista VistaPrincipal = new Vista();
        ControladorTabla control = new ControladorTabla(VistaPrincipal, converter.getarrayEmpleado());

        VistaPrincipal.setVisible(true);
    }
} 
