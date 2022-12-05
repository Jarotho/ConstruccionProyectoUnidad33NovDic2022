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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaAgregar.getAgregarButton()){
            guardarEmpleado();
            addNewEmployess();
            if(empleadoAgregado){
                AgregarEmpleado empleadoAgregado = new AgregarEmpleado();
                empleadoAgregado.insertEmployee(camposEmpleado);
            }
        }

        if(e.getSource() == this.vistaAgregar.getRegresarButton()){
            this.vistaAgregar.dispose();
            System.gc();
        }
    }

    public void addNewEmployess(){
        try{
            ID = Integer.parseInt(this.vistaAgregar.getTextField3().getText());
        }catch (NumberFormatException e){
            ID = -1;
        }
        this.empleadoAgregado = true;
        if(ID >= 0){
            for (Empleado empleados : empleados) {
                if (empleados.getId() == ID) {
                    empleadoAgregado = false;
                    break;
                }
            }
        }
        validateEmpytData();
        if(empleadoAgregado){
            String firstName = this.vistaAgregar.getTextField2().getText();
            if(ID >= 0){
                for (Empleado empleados : empleados) {
                    if (Objects.equals(empleados.getFirstName(), firstName)) {
                        empleadoAgregado = false;
                        break;
                    }
                }
            }
            if (empleadoAgregado && ID >= 0){
                empleados.add(new Empleado(ID,camposEmpleado[1],camposEmpleado[2],camposEmpleado[3]));
            }
        }
        if(empleadoAgregado && ID >= 0){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha agregado un nuevo empleado",
                    "Operacion realizada con éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo agregar al nuevo empleado",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void guardarEmpleado(){
        camposEmpleado[0] = this.vistaAgregar.getTextField3().getText();
        camposEmpleado[1] = this.vistaAgregar.getTextField2().getText();
        camposEmpleado[2] = this.vistaAgregar.getTextField1().getText();
        camposEmpleado[3] = this.vistaAgregar.getTextField4().getText();
    }

    
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

}