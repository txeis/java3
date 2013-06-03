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
    JButton buscar;
    JButton borrar;
    Empleado empleado=null;
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
        c.setLayout(new GridLayout(8,2,10,10));
        
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
        buscar=new JButton("BUSCAR");
        borrar=new JButton("BORRAR");
        
        c.add(Ldni);
        c.add(Tdni);
        c.add(buscar);
        c.add(borrar);
        c.add(Lnombre);
        c.add(Tnombre);
        c.add(Lapellidos);
        c.add(Tapellidos);
        c.add(LnHijos);
        c.add(TnHijos);
        c.add(Lcategoria);
        c.add(Tcategoria);
        
        if(estado==0){
            c.add(Lpuesto);
            c.add(Tpuesto);
        }
        c.add(baja);
        
        baja.addActionListener(this);
        buscar.addActionListener(this);
        borrar.addActionListener(this);
        
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
        
        if(control.equals(baja)){
           VconfirmarBaja confirmar=new VconfirmarBaja(empleado, con, this);
        }
        if(control.equals(borrar)){
            limpiarPantalla();
        }
        if(control.equals(buscar)){
            String dni=Tdni.getText();
            System.out.println(dni);
            if(Empleado.dniCorrecto(dni)){
                System.out.println("correcto");
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
                }
            }
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
