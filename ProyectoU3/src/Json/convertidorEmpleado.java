package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Json.Excepciones.EmpleadoInexistente;

import java.util.ArrayList;
import java.util.Iterator;


public class convertidorEmpleado {
    private ArrayList<Empleado> arrayEmpleado = new ArrayList<>();
    public void convertJSONtoArray(JSONArray jsonEmpleados){

        try{
            for(int i = 0; i < jsonEmpleados.size(); i++){
                JSONObject tempEmpleado = (JSONObject) jsonEmpleados.get(i);
                Empleado newEmpleado = new Empleado(Integer.parseInt(tempEmpleado.get("id").toString()),
                        tempEmpleado.get("firstName").toString(),
                        tempEmpleado.get("lastName").toString(),
                        tempEmpleado.get("photo").toString());
                arrayEmpleado.add(newEmpleado);
                //System.out.println(arrayEmpleado.get(i).toString());
            }
        }catch(NullPointerException e){
            arrayEmpleado.add(new EmpleadoInexistente());
        }
    }

    public void removeNullInstances(){
        for(Empleado emp : arrayEmpleado){
            if(emp.isNull()){
                arrayEmpleado.remove(emp);
            }
        }
    }

    public ArrayList<Empleado> getarrayEmpleado() {
        return arrayEmpleado;
    }

    public Iterator<Empleado> getIterator(){
        return arrayEmpleado.iterator();
    }
}
