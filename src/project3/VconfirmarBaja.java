/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author idoia
 */
public class VconfirmarBaja extends JFrame implements ActionListener{
    JLabel mnsj;
    JPanel c; 
    JButton confirmar;
    Empleado empleado;
    BaseDatos con;
    private Boolean borrado;
    VBaja vBaja;
    VconfirmarBaja(Empleado empleado, BaseDatos con, VBaja vBaja) {
        this.empleado=empleado;
        this.con=con;
        this.vBaja=vBaja;
        c=(JPanel)this.getContentPane();     
        this.setTitle("ALERTA");
        this.setSize(500, 100);
        this.setLocation(600,100);
        c.setLayout(new GridLayout(1, 1, 20,20));
        this.setVisible(true);
        mnsj=new JLabel("Esta seguro de que desea borrar el registro?");
        confirmar=new JButton("CONFIRMAR");
        c.add(mnsj);
        c.add(confirmar);
        confirmar.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(empleado!=null){
                con.bajaEmpleado(empleado);
                borrado=true;
            }
            else{
                borrado=false;
            }
        this.dispose();
        vBaja.dispose();
    }

    /**
     * @return the borrado
     */
    public Boolean getBorrado() {
        return borrado;
    }
}

    