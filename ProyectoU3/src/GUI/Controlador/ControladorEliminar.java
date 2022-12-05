package GUI.Controlador;

import Json.Empleado;
import Json.EliminarEmpleado;
import GUI.Vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorEliminar implements ActionListener {
    private Eliminar vistaEliminar;
    private ArrayList<Empleado> employees;
    private boolean deleted = false;

    private int IDToDelete;
    public ControladorEliminar(Eliminar vistaEliminar){
        this.vistaEliminar = vistaEliminar;
        this.vistaEliminar.getRegresarButton().addActionListener(this);
        this.vistaEliminar.getEliminarButton().addActionListener(this);
    }

    public ControladorEliminar(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaEliminar.getRegresarButton()){
            this.vistaEliminar.dispose();
            System.gc();
        }

        if(e.getSource() == this.vistaEliminar.getEliminarButton()){
            deleteEmployee();
            if(deleted){
                EliminarEmpleado eliminarEmpleado = new EliminarEmpleado();
                eliminarEmpleado.eliminarEmpleado(IDToDelete);
            }
        }
    }

    public void deleteEmployee(){
        try{
            IDToDelete = Integer.parseInt(this.vistaEliminar.getTextField1().getText());
        }catch (NumberFormatException e){
            IDToDelete = -1;
        }
        deleted = false;
        if(IDToDelete >= 0){
            for(int i = 0 ; i < employees.size() ; i++){
                if (employees.get(i).getId() ==  IDToDelete) {
                    employees.remove(i);
                    deleted = true;
                    break;
                }
            }
        }
        if(deleted){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha eliminado el empleado con id " + IDToDelete,
                    "Eliminación realizada con éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo eliminar el empleado con id " + IDToDelete,
                    "Error al eliminar empleado",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }



    public Eliminar getVistaEliminar() {
        return vistaEliminar;
    }


    public void setEmployees(ArrayList<Empleado> employees) {
        this.employees = employees;
    }

    public ArrayList<Empleado> getEmployees() {
        return employees;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setIDToDelete(int IDToDelete) {
        this.IDToDelete = IDToDelete;
    }

    public int getIDToDelete() {
        return IDToDelete;
    }

    public JButton getBotonRegrear(){
        return this.vistaEliminar.getRegresarButton();
    }
}