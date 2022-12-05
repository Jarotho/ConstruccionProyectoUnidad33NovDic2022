package Test;
import org.junit.jupiter.api.Test;
import Json.ModificarEmpleado;
import Json.lecturaJson;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerceraEntrega {
    
    private static lecturaJson validarJson;
    private static ModificarEmpleado Modificador;

    @Test
    public void validarModificaciones(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("Prueba.json");
        Modificador = new ModificarEmpleado();
        int Antes, Despues;
        Antes = Modificador.getArrayJSONobject().toString().length();
        String Modificaciones[] = {"","","",""};
        Modificador.modificarEmpleado(Modificaciones);
        Despues = Modificador.getArrayJSONobject().toString().length();
        assertFalse(Antes == Despues);
    }

    @Test
    public void validarID(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("Prueba.json");
        Modificador = new ModificarEmpleado();
        String Modificaciones[] = {"","","",""};
        boolean Validacion = Modificador.modificarEmpleado(Modificaciones);
        assertTrue(Validacion);
    }

    @Test
    public void validarFormatoID(){
        validarJson = new lecturaJson();
        validarJson.validarLectura("Prueba.json");
        Modificador = new ModificarEmpleado();
        String Modificaciones[] = {"","","",""};
        boolean Validacion = Modificador.modificarEmpleado(Modificaciones);
        assertTrue(Validacion);
    }
}
