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
    public void archivoCorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("Empleados.json");
        assertTrue(js);
    }

    @Test
    public void archivoIncorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("MaFormato_Empleados.json");
        assertTrue(js);
    }

    @Test
    public void rutaIncorrecta(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean js = jsonValidado.jsonReader("Employee.json");
        assertTrue(js);
    }




}
