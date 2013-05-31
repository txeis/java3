/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class BaseDatos extends JFrame{
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    String user="usuario";
    String password="1234";
    String url="jdbc:mysql://localhost/empleados";
  
    BaseDatos(){
        
        
        try {
            con=DriverManager.getConnection(url,user,password);
            st=con.createStatement();
            System.out.println("establezco conexion");
            
        } 
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("ERROR: "+ex);
            System.out.println(("ERROR: "+ex));
            
        } 
    }
    
    public void listado(String tabla){
        try{
            rs = st.executeQuery("SELECT * FROM "+tabla);
        while(rs.next()){
                 //   al=new Alumno(rs.getString(1),rs.getString(2),rs.getInt(3));
                 //   vL.imprime(al);
                }
            }
            catch(SQLException ex){
                Vmensaje m=new Vmensaje("error:  "+ex);
                System.out.println(("ERROR: "+ex));
            } 
    }
    
    public Empleado buscarEmpleado(String dni, int estado){
        try{
            
            if(estado==0){
                rs=st.executeQuery("Select * from oficinas where dni LIKE '"+dni+"';");
                if(rs.next()){
                    Oficinas oficinas=new Oficinas(rs.getString(1),rs.getString(2),
                            rs.getString(3),Integer.parseInt(rs.getString(4)),rs.getString(5),
                            rs.getString(6));
                    return oficinas;
                }
                else{
                    Vmensaje msj=new Vmensaje("No existe el dni.");
                }
            }
            if(estado==1){
                rs=st.executeQuery("Select * from laboral where dni LIKE '"+dni+"';");
                if(rs.next()){
                    Laboral laboral=new Laboral(rs.getString(1),rs.getString(2),
                            rs.getString(3),Integer.parseInt(rs.getString(4)),rs.getString(5));
                    return laboral;
                }
                else{
                    Vmensaje msj=new Vmensaje("No existe el dni.");
                }
            }
        }
        catch (SQLException ex){
            System.out.println ("ERROR: "+ex);
        }  
        return null;
    }
    /**
     * Controla si el empleado ya existe en la tabla
     */
    public boolean existe(Empleado empleado){
        try{
            if(empleado instanceof Oficinas){
                rs=st.executeQuery("Select dni from oficinas where dni LIKE '"+empleado.getDni()+"';");
            }
            else if(empleado instanceof Laboral){
                rs=st.executeQuery("Select dni from laboral where dni LIKE '"+empleado.getDni()+"';");
            }
            else{
                Vmensaje msj=new Vmensaje("No se ha recivido el objeto correcto.");
            }
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException ex){
            System.out.println ("ERROR: "+ex);
        } 
        return false;
    }
    public void cerrar(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
            if (con!=null){
                con.close();
            }
            System.out.println("conexion cerrada");
        }
        catch (SQLException ex){
            Vmensaje msj=new Vmensaje("Error cerrando la conexión");
            System.out.println(("ERROR: "+ex));
        }   
    }
    /**
     * Compruebo que el registro no exista ya, y si no existe lo creo
     * @param empleado 
     */
    public void altaEmpleado(Empleado empleado){  
      
        try {
            if(!existe(empleado)){
                if(empleado instanceof Laboral){
                    Laboral laboral=(Laboral)empleado;
                    st.executeUpdate("INSERT INTO laboral VALUES ('"+laboral.getDni()+
                        "','"+laboral.getNom()+"','"+laboral.getApe()+
                        "','"+laboral.getnHij()+
                        "','"+laboral.getCategoria()+"');");
                }
                if(empleado instanceof Oficinas){
                    Oficinas oficina=(Oficinas)empleado;
                    st.executeUpdate("INSERT INTO oficinas VALUES ('"+oficina.getDni()+
                        "','"+oficina.getNom()+
                        "','"+oficina.getApe()+
                        "','"+oficina.getnHij()+
                        "','"+oficina.getCategoria()+
                        "','"+oficina.getPuesto()+"');");
                }
            }
            else{
                Vmensaje msj=new Vmensaje("Ya existe un empleado con ese dni.");
            }
        } catch (SQLException ex){
           Vmensaje msj=new Vmensaje("ERROR: "+ex);
           System.out.println(("ERROR: "+ex));
        }
    } 
    
    
    /*public void altaCategoria(Categoria cat){  
      
        try {
                st.executeUpdate("INSERT INTO categoria VALUES ('"+cat.getCategoria()+
                        "','"+cat.getSueldo()+"');");
        } 
        catch (SQLException ex){
                Mensaje msj=new Mensaje("ERROR: "+ex);
                System.out.println(("ERROR: "+ex));
        }
    } */
    
   /* public Laboral buscaLaboral(){
        
    }*/
    
    public void bajaEmpleado(Empleado empleado){  
        try {
            if(empleado instanceof Laboral){
                System.out.println("entro a borrar de laboral");
                st.executeUpdate("DELETE from laboral where dni LIKE '"+empleado.getDni()+"';");
            }
            if(empleado instanceof Oficinas){
                System.out.println("entro a borrar de oficina");
                st.executeUpdate("DELETE from oficinas where dni LIKE '"+empleado.getDni()+"';");
            }
        } 
        catch (SQLException ex){
                Vmensaje msj=new Vmensaje("ERROR: "+ex);
                System.out.println(("ERROR: "+ex));
        }
    } 
    
    
    
}
