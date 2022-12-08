package Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Json.*;
import static org.junit.jupiter.api.Assertions.*;

class QuintaEntrega {
    private static lecturaJson validacionJSON;
    private static AgregarEmpleado AgregarEmpleado;
    

    @Test
    @DisplayName("No es correcto el formato del ID")
    public void IdEmployee(){
        validacionJSON = new lecturaJson();
        validacionJSON.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        AgregarEmpleado = new AgregarEmpleado();
        String nuevoEmpleado[] = {"1","nuevo","employee","123"};
        boolean Validacion = AgregarEmpleado.insertEmployee(nuevoEmpleado);
        assertTrue(Validacion);
    }

    @Test
    @DisplayName("Algún campo no tiene valor")
    public void fieldsEmployee(){
        validacionJSON = new lecturaJson();
        validacionJSON.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        AgregarEmpleado = new AgregarEmpleado();
        String nuevoEmpleado[] = {"33","nuevo","el pepe",""};
        boolean Validacion = AgregarEmpleado.insertEmployee(nuevoEmpleado);
        assertTrue(Validacion);
    }

    @Test
    @DisplayName("No se agregó empleado en el JSON")
    public void testLongitudArray(){
        validacionJSON = new lecturaJson();
        validacionJSON.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        AgregarEmpleado = new AgregarEmpleado();
        int empleadosAntes, empleadosDespues;
        empleadosAntes = AgregarEmpleado.getArrayJSONobject().size();
        String nuevoEmpleado[] = {"24","Ignacio","Zaragoza","https://m.media-amazon.com/images/I/51H7hKYNcTL.jpg"};
        AgregarEmpleado.insertEmployee(nuevoEmpleado);
        empleadosDespues = AgregarEmpleado.getArrayJSONobject().size();
        assertTrue(empleadosAntes+1 == empleadosDespues);
    }

}