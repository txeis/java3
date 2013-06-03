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
    
     JLabel mes;
     JLabel nombre;
     JLabel categoria;
     JLabel hijos;
     JLabel SB;
     JLabel IRPF;
     JLabel extra;
     JLabel SN;
     
    public Vnomina(String cadena, BaseDatos con,int estado){
        this.estado=estado;
        this.con=con;
        c=(JPanel)this.getContentPane();  
        this.setTitle(cadena);
        this.setSize(600,600);
        this.setLocation(800,200);
        this.setVisible(true);
        c.setBackground(Color.GREEN);
        c.setLayout(new GridLayout(8,1,10,10));
        
        mes=new JLabel("");
        nombre=new JLabel("");
        categoria=new JLabel("");
        hijos=new JLabel("");
        SB=new JLabel("");
        IRPF=new JLabel("");
        extra=new JLabel("");
        SN=new JLabel("");
        
        c.add(mes);
        c.add(nombre);
        c.add(categoria);
        c.add(hijos);
        c.add(SB);
        c.add(IRPF);
        c.add(extra);
        c.add(SN);
    }
    
    
    
}
