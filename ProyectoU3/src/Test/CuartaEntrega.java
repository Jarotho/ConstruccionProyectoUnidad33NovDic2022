package Test;
import org.junit.jupiter.api.Test;
import Json.EliminarEmpleado;
import Json.lecturaJson;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuartaEntrega {
    private static lecturaJson validarJson;
    private static EliminarEmpleado eliminadorEmpleado;

    @Test
    public void validarID(){
        int ID = 2;
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        eliminadorEmpleado = new EliminarEmpleado();
        boolean validacion = eliminadorEmpleado.eliminarEmpleado(ID);
        assertTrue(validacion);
    }

    @Test
    public void validarEliminacion(){
        int ID = 33;
        int empleadosAntes, empleadosDespues;
        validarJson = new lecturaJson();
        validarJson.validarLectura("C:\\Users\\hp\\Documents\\LIS\\5TOSEMESTRE\\PROYECTODECONSTRUCCION\\entrega5\\Entrega5\\Empleados.json");
        eliminadorEmpleado = new EliminarEmpleado();
        empleadosAntes = eliminadorEmpleado.getArrayJSONobject().size();
        eliminadorEmpleado.eliminarEmpleado(ID);
        empleadosDespues = eliminadorEmpleado.getArrayJSONobject().size();

        assertTrue(empleadosAntes-1 == empleadosDespues);
    }

}
