/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public class Oficinas extends Empleado{
    private String puesto="a";

    public Oficinas(String dni,String nom,String ape,int nHij,String categoria,String puesto){
        super(dni,nom,ape,nHij,categoria);
        this.puesto=puesto;
    }
    
    
    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}