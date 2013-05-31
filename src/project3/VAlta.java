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
    JButton alta;
    
    JLabel Lh1;
    JTextField Th1;
    JLabel Lh2;
    JTextField Th2;
    JLabel Lh3;
    JTextField Th3;
    JLabel Lh4;
    JTextField Th4;
    JLabel Lh5;
    JTextField Th5;
    JLabel Lh6;
    JTextField Th6;
    JLabel Lh7;
    JTextField Th7;
    JLabel Lh8;
    JTextField Th8;
    JLabel Lh9;
    JTextField Th9;
    JLabel Lh10;
    JTextField Th10;
    JLabel Lh11;
    JTextField Th11;
    JLabel Lh12;
    JTextField Th12;

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
        Lh1=new JLabel("h enero");
        Th1=new JTextField();
        Lh2=new JLabel("h enero");
        Th2=new JTextField();
        Lh3=new JLabel("h enero");
        Th3=new JTextField();
        Lh4=new JLabel("h enero");
        Th4=new JTextField();
        Lh5=new JLabel("h enero");
        Th5=new JTextField();
        Lh6=new JLabel("h enero");
        Th6=new JTextField();
        Lh7=new JLabel("h enero");
        Th7=new JTextField();
        Lh8=new JLabel("h enero");
        Th8=new JTextField();
        Lh9=new JLabel("h enero");
        Th9=new JTextField();
        Lh10=new JLabel("h enero");
        Th10=new JTextField();
        Lh11=new JLabel("h enero");
        Th11=new JTextField();
        Lh12=new JLabel("h enero");
        Th12=new JTextField();
        
        c.add(Lh1);
        c.add(Th1);
        c.add(Lh2);
        c.add(Th2);
        c.add(Lh3);
        c.add(Th3);
        c.add(Lh4);
        c.add(Th4);
        c.add(Lh5);
        c.add(Th5);
        c.add(Lh6);
        c.add(Th6);
        c.add(Lh7);
        c.add(Th7);
        c.add(Lh8);
        c.add(Th8);
        c.add(Lh9);
        c.add(Th9);
        c.add(Lh10);
        c.add(Th10);
        c.add(Lh11);
        c.add(Th11);
        c.add(Lh12);
        c.add(Th12);
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
