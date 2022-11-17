package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Vista {
 
    public static void main(String []args){
        
        Vista ventana = new Vista("JSon"); 
    }
    
    public Vista (String titulo){
        
        JFrame ventanaM = new JFrame(titulo);
        
        ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
        ventanaM.setSize(500, 500);
        ventanaM.setVisible(true);//configurando visualización de la ventana 

        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        ventanaM.add(panel);
    
        Object[] nombrecolumnas = {"Nombre", "Apellido", "Edad"};
        Object[][] datos ={{"Nombre1", "Apellido1", 22},{"Nombre2", "Apellido2", 4}};
        JTable table = new JTable(datos,nombrecolumnas);
        panel.add(table);       
    }
    
}


