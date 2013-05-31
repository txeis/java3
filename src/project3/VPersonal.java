/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class VPersonal extends JFrame implements ActionListener, WindowListener{
 
        JPanel c;
        
        JButton oficinas;
        JButton laboral;
        JButton listado;
        
        BaseDatos con;
        private int estado=0;//0 para oficinas y 1 para laborales
        
    VPersonal(BaseDatos con){
        
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle("PERSONAL");
        this.setSize(300,350);
        this.setLocation(300,200);
        this.setVisible(true);
        c.setLayout(new GridLayout(3,1,0,0));
        
        oficinas=new JButton("OFICINAS");
        laboral=new JButton("LABORAL");
        listado=new JButton("LISTADO");
        
        c.add(oficinas);
        c.add(laboral);
        c.add(listado);
       
        oficinas.addActionListener(this);
        laboral.addActionListener(this);
        listado.addActionListener(this);
        
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        Object control=e.getSource();
        if(control.equals(oficinas)){
            estado=0;
            VMenu vOficinas= new VMenu("OFICINAS", con, estado);
        }
        if(control.equals(laboral)){
            estado=1;
            VMenu vLaboral= new VMenu("LABORAL", con, estado);
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
