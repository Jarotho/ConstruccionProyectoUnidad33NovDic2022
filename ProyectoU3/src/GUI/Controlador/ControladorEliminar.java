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

    private int indexToDelete;
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
                eliminarEmpleado.eliminarEmpleado(indexToDelete);
            }
        }
    }

    public void deleteEmployee(){
        try{
            indexToDelete = Integer.parseInt(this.vistaEliminar.getTextField1().getText());
        }catch (NumberFormatException e){
            indexToDelete = -1;
        }
        deleted = false;
        if(indexToDelete >= 0){
            for(int i = 0 ; i < employees.size() ; i++){
                if (employees.get(i).getId() ==  indexToDelete) {
                    employees.remove(i);
                    deleted = true;
                    break;
                }
            }
        }
        if(deleted){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha eliminado el empleado con id " + indexToDelete,
                    "Delete Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo eliminar el empleado con id " + indexToDelete,
                    "Delete Employee",
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

    public void setIndexToDelete(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    public int getIndexToDelete() {
        return indexToDelete;
    }

    public JButton getBotonRegrear(){
        return this.vistaEliminar.getRegresarButton();
    }
}