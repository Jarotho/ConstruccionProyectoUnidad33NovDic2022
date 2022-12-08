package Test;
import org.junit.jupiter.api.Test;
import Json.ModificarEmpleado;
import Json.lecturaJson;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.simple.JSONObject;

public class TerceraEntrega {
    
    private static lecturaJson validarJson;
    private static ModificarEmpleado Modificador;

    @Test
    public void validarModificaciones(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        Modificador = new ModificarEmpleado();
        int empleadosAntes, empleadosDespues;
        empleadosAntes = Modificador.getArrayJSONobject().toString().length();
        String Modificaciones[] = {"1","elpepo","el pepito","1332"};
        Modificador.modificarEmpleado(Modificaciones);
        empleadosDespues = Modificador.getArrayJSONobject().toString().length();
        assertTrue(empleadosAntes != empleadosDespues);
    }

    @Test
    public void validarID(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        Modificador = new ModificarEmpleado();
        String Modificaciones[] = {"","","",""};
        boolean Validacion = Modificador.modificarEmpleado(Modificaciones);
        assertTrue(Validacion);
    }

    @Test
    public void validarFormatoID(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        Modificador = new ModificarEmpleado();
        String Modificaciones[] = {"","","",""};
        boolean Validacion = Modificador.modificarEmpleado(Modificaciones);
        assertTrue(Validacion);
    }

    @Test
    public void validarInformacionEmpleado(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        JSONObject employeeObject = validarJson.extractJSONObjectbyKey("employees");
        validarJson.extractEmployeeJSONArray(employeeObject, "employee");
        boolean verificationResult = validarJson.extracEmployeeInfo();
        assertTrue(verificationResult);
    }

}
