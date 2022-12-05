package GUI.Controlador;
import Json.Empleado;
import GUI.Vista.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorTabla implements ActionListener{
    private Vista vista;
    private ArrayList<Empleado> Empleados;
    private Modificar vistaModificar = new Modificar();
    private final ControladorModificar controladorModificar = new ControladorModificar(vistaModificar);
    private Eliminar vistaEliminar = new Eliminar();
    private final ControladorEliminar controladorEliminar = new ControladorEliminar(vistaEliminar);
    private Agregar vistaAgregar = new Agregar();
    private final ControladorAgregar controladorAgregar = new ControladorAgregar(vistaAgregar);



    public ControladorTabla(Vista vista, ArrayList<Empleado> EmpleadoIterator) {
        this.vista = vista;
        this.Empleados = EmpleadoIterator;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjButton2().addActionListener(this);
        this.vista.getjButton3().addActionListener(this);

        this.controladorModificar.getVistaModificar().getRegresarButton().addActionListener(this);
        this.controladorEliminar.getVistaEliminar().getRegresarButton().addActionListener(this);
        
        llenarEmpleados();
    }



    public void llenarEmpleados(){
        for(Empleado Empleado : Empleados){
            this.vista.Table().addRow(Empleado.getEmployeeObjectArray());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.getjButton3()){
            controladorModificar.getVistaModificar().getTextField1().setText("");
            controladorModificar.getVistaModificar().getTextField2().setText("");
            controladorModificar.getVistaModificar().getTextField3().setText("");
            controladorModificar.getVistaModificar().getTextField4().setText("");
            controladorModificar.setEmployees(Empleados);
            controladorModificar.getVistaModificar().setVisible(true);

        }
        if(e.getSource() == this.controladorModificar.getVistaModificar().getRegresarButton()){
            if(controladorModificar.getUpdated()){
                Empleados = controladorModificar.getEmployees();
                this.vista.Table().setRowCount(0);
                llenarEmpleados();
            }
            controladorModificar.setUpdated(false);
        }

        if(e.getSource() == this.vista.getjButton2()){
            controladorEliminar.getVistaEliminar().getTextField1().setText("");
            controladorEliminar.setEmployees(Empleados);
            controladorEliminar.getVistaEliminar().setVisible(true);

        }
        if(e.getSource() == this.controladorEliminar.getVistaEliminar().getRegresarButton()){
            if(controladorEliminar.getDeleted()){
                Empleados = controladorEliminar.getEmployees();
                this.vista.Table().setRowCount(0);
                llenarEmpleados();
            }
            controladorEliminar.setDeleted(false);
        }

        if(e.getSource() == this.vista.getjButton1()){
            controladorAgregar.getVistaAgregar().getTextField1().setText("");
            controladorAgregar.getVistaAgregar().getTextField2().setText("");
            controladorAgregar.getVistaAgregar().getTextField3().setText("");
            controladorAgregar.getVistaAgregar().getTextField4().setText("");
            controladorAgregar.setEmpleados(Empleados);
            controladorAgregar.getVistaAgregar().setVisible(true);

        }
        if(e.getSource() == this.controladorAgregar.getVistaAgregar().getRegresarButton()){
            if(controladorAgregar.getEmpleadoAgregado()){
                Empleados = controladorAgregar.getEmpleados();
                this.vista.Table().setRowCount(0);
                llenarEmpleados();
            }
            controladorAgregar.setEmpleadoAgregado(false);
        }
    }

}