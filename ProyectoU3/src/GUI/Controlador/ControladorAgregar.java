package GUI.Controlador;

import Json.Empleado;
import Json.AgregarEmpleado;
import GUI.Vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ControladorAgregar implements ActionListener {
    private Agregar vistaAgregar;
    private ArrayList<Empleado> empleados;
    private boolean empleadoAgregado = false;
    private int ID;
    private String[] camposEmpleado = new String[4];

    public ControladorAgregar(Agregar vistaAgregar){
        this.vistaAgregar = vistaAgregar;
        this.vistaAgregar.getAgregarButton().addActionListener(this);
        this.vistaAgregar.getRegresarButton().addActionListener(this);
    }

    public ControladorAgregar(){}

    
    
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void validateEmpytData(){
        if(Objects.equals(camposEmpleado[1], "") || Objects.equals(camposEmpleado[2], "")){
            empleadoAgregado = false;
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleadoAgregado(boolean empleadoAgregado){
        this.empleadoAgregado = empleadoAgregado;
    }

    public boolean getEmpleadoAgregado(){
        return this.empleadoAgregado;
    }

    public JButton getBotonRegresar(){
        return this.vistaAgregar.getRegresarButton();
    }

    public Agregar getVistaAgregar(){
        return this.vistaAgregar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}