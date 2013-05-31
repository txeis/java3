/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class VAlta  extends JFrame implements ActionListener, WindowListener{
    
    JPanel c;
    JLabel Ldni;
    JTextField Tdni;
    JLabel Lnombre;
    JTextField Tnombre;
    JLabel Lapellidos;
    JTextField Tapellidos;
    JLabel LnHijos;
    JTextField TnHijos;
    JLabel Lcategoria;
    JTextField Tcategoria;
    JLabel Lpuesto;
    JTextField Tpuesto;
    JLabel Lhoras;
    JTextField Thoras;
    JButton alta;

    private int estado=0; //controla si es oficina(0) o laboral(1)
    
    BaseDatos con;
    
    public VAlta(String cadena, BaseDatos con, int estado){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();
        
        this.setTitle(cadena);
        this.setSize(400,400);
        this.setLocation(800,400);
        this.setVisible(true);
        c.setBackground(Color.GREEN);
        c.setLayout(new GridLayout(7,2,10,10));
        
        addComunes();
        alta=new JButton("ALTA");
        if(estado==0){
            addPuesto();
        }
        if(estado==1){
            addHoras();
        }
        c.add(alta);
        
        alta.addActionListener(this);
        this.addWindowListener(this);
        System.out.println(estado);
    }
    public void addComunes(){
        
        
        Ldni=new JLabel("DNI: ");
        Tdni=new JTextField();
        Lnombre=new JLabel("Nombre: ");
        Tnombre=new JTextField();
        Lapellidos=new JLabel("Apellidos: ");
        Tapellidos=new JTextField();
        LnHijos=new JLabel("Nº de hijos: ");
        TnHijos=new JTextField();
        Lcategoria=new JLabel("Categoría: ");
        Tcategoria=new JTextField();
        
        c.add(Ldni);
        c.add(Tdni);
        c.add(Lnombre);
        c.add(Tnombre);
        c.add(Lapellidos);
        c.add(Tapellidos);
        c.add(LnHijos);
        c.add(TnHijos);
        c.add(Lcategoria);
        c.add(Tcategoria);
    }
    public void addPuesto(){
        Lpuesto=new JLabel("Puesto: ");
        Tpuesto=new JTextField();
        c.add(Lpuesto);
        c.add(Tpuesto);
        
    }
    public void addHoras(){
        Lhoras=new JLabel("Horas trabajadas: ");
        Thoras=new JTextField();
    }
    
    /**
     * @return the emp
     */
    public int getEmp() {
        return estado;
    }
    
    /*public  void limpiarPantalla(){
        Tdni.setText("");
        Tnombre.setText("");
        Tapellidos.setText("");
        TnHijos.setText("");
        Tcategoria.setText("");
        if(estado==0){
            Tpuesto.setText("");
        }
    }*/
 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(estado==0){
            Oficinas oficina=new Oficinas(Tdni.getText(),Tnombre.getText(),
                    Tapellidos.getText(),Integer.parseInt(TnHijos.getText()),
                    Tcategoria.getText().toUpperCase(),Tpuesto.getText());
            //limpiarPantalla();
            con.altaEmpleado(oficina);
            this.dispose();
            
        }
        if(estado==1){
            Laboral laboral=new Laboral(Tdni.getText(),Tnombre.getText(),
                    Tapellidos.getText(),Integer.parseInt(TnHijos.getText()),
                    Tcategoria.getText().toUpperCase());
            //limpiarPantalla();
            con.altaEmpleado(laboral);
            this.dispose();
        }
    }
    
    
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    

    
}
