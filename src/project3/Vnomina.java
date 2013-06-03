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
 * @author idoia
 */
public class Vnomina extends JFrame{

     JPanel c;
     int estado;
     BaseDatos con;
    
     JLabel mesHoras;
     JLabel nombre;
     JLabel categoria;
     JLabel hijos;
     JLabel SB;
     JLabel IRPF;
     JLabel extra;
     JLabel SN;
     
    public Vnomina(String cadena, BaseDatos con,int estado, Empleado emp, int mes){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(600,600);
        this.setLocation(800,200);
        this.setVisible(true);
        c.setBackground(Color.GREEN);
        c.setLayout(new GridLayout(8,1,10,10));
        
        
        Nomina nomina=new Nomina(con,estado,emp,mes);
        
        
        mesHoras=new JLabel("");
        nombre=new JLabel("");
        categoria=new JLabel("");
        hijos=new JLabel("");
        SB=new JLabel("");
        IRPF=new JLabel("");
        extra=new JLabel("");
        SN=new JLabel("");
        
        c.add(mesHoras);
        c.add(nombre);
        c.add(categoria);
        c.add(hijos);
        c.add(SB);
        c.add(IRPF);
        c.add(extra);
        c.add(SN);
    }
    
    
    
}
