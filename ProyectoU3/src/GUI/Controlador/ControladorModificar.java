package GUI.Controlador;

import Json.Empleado;
import Json.ModificarEmpleado;
import GUI.Vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorModificar implements ActionListener {
    private Modificar vistaModificar;
    private String[] valuesToUpdate = new String[4];
    private ArrayList<Empleado> employees;
    private boolean updated = false;
    public ControladorModificar(Modificar vistaModificar){
        this.vistaModificar = vistaModificar;
        this.vistaModificar.getRegresarButton().addActionListener(this);
        this.vistaModificar.getmodificarButton().addActionListener(this);
    }

    public ControladorModificar(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaModificar.getmodificarButton()){
            storeUpdateValues();
            ModificarEmpleado modifierEmployee = new ModificarEmpleado();
            modifierEmployee.modificarEmpleado(valuesToUpdate);
            updateEmployees();
        }

        if(e.getSource() == this.vistaModificar.getRegresarButton()){
            this.vistaModificar.dispose();
            System.gc();
        }
    }

    public void storeUpdateValues(){
        valuesToUpdate[0] = this.vistaModificar.getTextField1().getText();
        valuesToUpdate[1] = this.vistaModificar.getTextField2().getText();
        valuesToUpdate[2] = this.vistaModificar.getTextField4().getText();
        valuesToUpdate[3] = this.vistaModificar.getTextField3().getText();

    }

    public void updateEmployees(){
        int indexToUpdate;
        boolean nullValuesToUpdate = false;
        boolean updatedEmployee = false;
        try{
            indexToUpdate = Integer.parseInt(valuesToUpdate[0]);
        }catch (NumberFormatException ex){
            indexToUpdate = 0;
        }
        if((indexToUpdate > 0 )){
            for(Empleado emp : employees){
                if(emp.getId() == Integer.parseInt(valuesToUpdate[0])){
                    try{
                        if(!valuesToUpdate[1].equals("")){
                            emp.setFirstName(valuesToUpdate[1]);
                        }
                        if(!valuesToUpdate[2].equals("")){
                            emp.setLastName(valuesToUpdate[2]);
                        }
                        if(!valuesToUpdate[3].equals("")){
                            emp.setPhoto(valuesToUpdate[3]);
                        }
                        setUpdated(true);
                        updatedEmployee = true;
                    }catch (NullPointerException e){
                        updatedEmployee = false;
                    }
                }
            }

        }
        if(updatedEmployee){
            JOptionPane.showMessageDialog(
                    null,
                    "ID: " + valuesToUpdate[0],
                    "Update Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "Ningun empleado fue modificado",
                    "Update Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Modificar getVistaModificar() {
        return vistaModificar;
    }


    public void setEmployees(ArrayList<Empleado> employees) {
        this.employees = employees;
    }

    public ArrayList<Empleado> getEmployees() {
        return employees;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public boolean getUpdated() {
        return updated;
    }

    public String[] getValuesToUpdate() {
        return valuesToUpdate;
    }

    public JButton getBotonRegrear(){
        return this.vistaModificar.getRegresarButton();
    }
}
