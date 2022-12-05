package Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Json.EliminarEmpleado;
import Json.lecturaJson;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CuartaEntrega {
    private static lecturaJson validarJson;
    private static EliminarEmpleado eliminadorEmpleado;

    @Test
    public void validarID(){
        int ID = 2;
        validarJson = new lecturaJson();
        validarJson.validarLectura("Prueba2.json");
        eliminadorEmpleado = new EliminarEmpleado();
        boolean validacion = eliminadorEmpleado.eliminarEmpleado(ID);
        assertTrue(validacion);
    }

    @Test
    public void validarEliminacion(){
        int ID = 1;
        int empleadosAntes, empleadosDespues;
        validarJson = new lecturaJson();
        validarJson.validarLectura("Prueba2.json");
        eliminadorEmpleado = new EliminarEmpleado();
        empleadosAntes = eliminadorEmpleado.getArrayJSONobject().toString().length();
        eliminadorEmpleado.eliminarEmpleado(ID);
        empleadosDespues = eliminadorEmpleado.getArrayJSONobject().toString().length();

        assertFalse(empleadosAntes == empleadosDespues);
    }

}
