package GUI.Controlador;
import Json.Empleado;
import GUI.Vista.*;
import java.util.ArrayList;

public class Controlador{
    private Vista vista;
    private ArrayList<Empleado> Empleados;

    public Controlador(Vista vista, ArrayList<Empleado> EmpleadoIterator) {
        this.vista = vista;
        this.Empleados = EmpleadoIterator;
        showEmpleadosTable();
    }



    public void showEmpleadosTable(){
        for(Empleado Empleado : Empleados){
            this.vista.Table().addRow(Empleado.getEmployeeObjectArray());
        }
    }

}