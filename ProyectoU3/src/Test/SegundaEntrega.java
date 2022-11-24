package Test;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Json.Empleado;
import Json.convertidorEmpleado;
import Json.lecturaJson;
import static org.junit.jupiter.api.Assertions.*;

class JSONToObjectConverterTest {
    private String path = "Empleados.json";
    private static lecturaJson validacionJSON;
    private static JSONObject employeesJSONObject;
    private static convertidorEmpleado converter;

    @BeforeEach
    void setUp() {
        validacionJSON = new lecturaJson();
        validacionJSON.validarLectura(path);
        employeesJSONObject = validacionJSON.extractJSONObjectbyKey("employees");
        validacionJSON.extractEmployeeJSONArray(employeesJSONObject, "employee");
        converter = new convertidorEmpleado();
    }

    @Test
    @DisplayName("Probando conversión de array JSON a array Employee")
    public void testConvertJSONtoArray(){

        boolean allAreEmployee = true;
        converter.convertJSONtoArray(validacionJSON.getArrayJSONobject());
        for (Empleado emp : converter.getarrayEmpleado())
        {
            allAreEmployee = emp.getClass().getName().equals(Empleado.class.getName());
            if(!allAreEmployee){
                break;
            }
        }
        assertTrue(allAreEmployee, "Algún objeto del array no es de tipo Employee");
    }
}