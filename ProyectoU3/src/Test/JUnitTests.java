package Test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import Json.lecturaJson;

public class JUnitTests {

    @Test
    @DisplayName("Verifica si se realiza la lectura del archivo")
    public void archivoCorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean jsonVerificador = jsonValidado.jsonReader("Empleados.json");
        assertTrue(jsonVerificador);
    }

    @Test
    @DisplayName("Verifica si el archivo no tiene el formato requerido")
    public void archivoIncorrecto(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean jsonVerificador = jsonValidado.jsonReader("MalFormato_Empleados.json");
        assertTrue(jsonVerificador);
    }

    @Test
    @DisplayName("Verifica si la ruta del archivo es correcta")
    public void rutaIncorrecta(){
        lecturaJson jsonValidado = new lecturaJson();
        boolean verificador = jsonValidado.jsonReader("Employee.json");
        assertTrue(verificador);
    }

    @Test
    @DisplayName("Verifica si el empleado contiene un elemento solicitado")
    public void keyInexistente() {
        lecturaJson jsonValidado = new lecturaJson();
        jsonValidado.jsonReader("NoKey_Empleados.json");
        JSONObject employeeObject = new JSONObject();
        employeeObject = jsonValidado.extractJSONObjectbyKey("employees");
        assertFalse(employeeObject == null);
    }


    @Test
    @DisplayName("Verifica si el empleado no contiene algun elemento de los empleados")
    public void elementosFaltantes(){
        lecturaJson jsonValidado = new lecturaJson();
        jsonValidado.jsonReader("ElementosFaltantes.json");
        JSONObject employeeObject = jsonValidado.extractJSONObjectbyKey("employees");
        jsonValidado.extractEmployeeJSONArray(employeeObject, "employee"); 
        boolean jsonVerificador = jsonValidado.extracEmployeeInfo();
        assertTrue(jsonVerificador);
    }




}
