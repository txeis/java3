/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public class Laboral extends Empleado{
    private int horas[]=new int[12];

    public Laboral(String dni,String nom,String ape,int nHij,String categoria, int horas[]){
        super(dni,nom,ape,nHij,categoria);
        this.horas=horas;
    }

    /**
     * @return the horas
     */
    public int[] getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int[] horas) {
        this.horas = horas;
    }
    
   
}

