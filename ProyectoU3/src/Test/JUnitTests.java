package Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.ReflectiveInterceptorCall.VoidMethodInterceptorCall;

import Json.lecturaJson;

public class JUnitTests {

    @Test
    @DisplayName("Verifica si se realiza la lectura del archivo")
    public void archivoCorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("Empleados.json");
        assertTrue(js);
    }

    @Test
    @DisplayName("Verifica si el archivo no tiene el formato requerido")
    public void archivoIncorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("MalFormato_Empleados.json");
        assertTrue(js);
    }

    @Test
    @DisplayName("Verifica si la ruta del archivo es correcta")
    public void rutaIncorrecta(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("Employee.json");
        assertTrue(js);
    }




}
