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
 * @author idoia
 * 
 * 
 * Pide dni + boton eliminar, se introduce, busca en la BBDD correspondiente,
 * si lo encuentra salen todos los datos + boton eliminar,
 * si le das al boton, mensaje "confirmar eliminar".
 */
public class VBaja extends JFrame implements ActionListener, WindowListener{
    
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
    JButton baja;
    JButton confirmar;
    
    BaseDatos con;
    
    private int estado=0; //controla si es oficina(0) o laboral(1)
    
    public VBaja(String cadena, BaseDatos con, int estado){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(400,400);
        this.setLocation(800,400);
        this.setVisible(true);
        c.setBackground(Color.GREEN);
        c.setLayout(new GridLayout(7,2,10,10));
        
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
        Lpuesto=new JLabel("Puesto: ");
        Tpuesto=new JTextField();
        baja=new JButton("BAJA");
        
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
        String cat=Tcategoria.getText().toUpperCase();
        if(estado==0){
            c.add(Lpuesto);
            c.add(Tpuesto);
        }
        if(estado==1){
        }
        c.add(baja);
        
        baja.addActionListener(this);
        
        this.addWindowListener(this);
        
    }
    public  void limpiarPantalla(){
        Tdni.setText("");
        Tnombre.setText("");
        Tapellidos.setText("");
        TnHijos.setText("");
        Tcategoria.setText("");
        if(estado==0){
            Tpuesto.setText("");
        }
    }
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        Object control=e.getSource();
        Empleado empleado=null;
        
            String dni=Tdni.getText();
            empleado=con.buscarEmpleado(dni, estado);
            if(empleado!=null){
                Tnombre.setText(empleado.getNom());
                Tapellidos.setText(empleado.getApe());
                TnHijos.setText(Integer.toString(empleado.getnHij()));
                Tcategoria.setText(empleado.getCategoria());
                if(estado==0){
                    Oficinas oficinas=(Oficinas) empleado;
                    Tpuesto.setText(oficinas.getPuesto());
                }
                VconfirmarBaja confirmar=new VconfirmarBaja(empleado, con, this);
                
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
