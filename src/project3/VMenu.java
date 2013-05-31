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
public class VMenu extends JFrame implements ActionListener, WindowListener{
    
    JPanel c;
        
        JButton alta;
        JButton baja;
        JButton modificacion;
        JButton consulta;
        JButton nomina;
        
        BaseDatos con;
        int estado=0;//0 para oficinas, 1 para laborales
        
    VMenu(String cadena, BaseDatos con, int estado){
        this.con=con; 
        this.estado=estado;
        
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(300,400);
        this.setLocation(600,200);
        this.setVisible(true);
        c.setBackground(Color.GREEN);
        c.setLayout(new GridLayout(5,1,10,10));
        
        alta=new JButton("ALTA");
        baja=new JButton("BAJA");
        modificacion=new JButton("MODIFICACIÓN");
        consulta=new JButton("CONSULTA");
        nomina=new JButton("NÓMINA");
        
        c.add(alta);
        c.add(baja);
        c.add(modificacion);
        c.add(consulta);
        c.add(nomina);
       
        alta.addActionListener(this);
        baja.addActionListener(this);
        modificacion.addActionListener(this);
        consulta.addActionListener(this);
        nomina.addActionListener(this);
        
        this.addWindowListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object control=e.getSource();
        
        if(control.equals(alta)){
            if(estado==0){
                estado=0;
                VAlta vAlta=new VAlta("ALTA OFICINAS", con, estado);
            }
            if(estado==1){
                estado=1;
                VAlta vAlta=new VAlta("ALTA LABORAL", con, estado);
            }
        }
        if(control.equals(baja)){
            if(estado==0){
                VBaja vBaja=new VBaja("BAJA OFICINAS", con, estado);
            }
            if(estado==1){
                VBaja vBaja=new VBaja("BAJA LABORAL", con, estado);
            }
        }
        if(control.equals(modificacion)){
        }
        if(control.equals(consulta)){
        }
        if(control.equals(nomina)){
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
