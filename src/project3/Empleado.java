/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public abstract class Empleado {
    
    private String dni="a";
    private String nom="a";//nombre
    private String ape="a";//apellidos
    private int nHij=0;//numero de hijos
    private String categoria="C";
    
    public Empleado(String dni,String nom,String ape,int nHij,String categoria){
        this.dni=dni;
        this.nom=nom;
        this.ape=ape;
        this.nHij=nHij;
        this.categoria=categoria;
    }
    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the ape
     */
    public String getApe() {
        return ape;
    }

    /**
     * @param ape the ape to set
     */
    public void setApe(String ape) {
        this.ape = ape;
    }

    /**
     * @return the nHij
     */
    public int getnHij() {
        return nHij;
    }

    /**
     * @param nHij the nHij to set
     */
    public void setnHij(int nHij) {
        this.nHij = nHij;
    }

    /**
     * @return the categoría
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoría to set
     */
    public void setCategoría(String categoria) {
        this.categoria = categoria;
    }
    
    public void altaEmp(){
        System.out.println("ALTA DE EMPLEADO:  ");
        System.out.println("");
    }
    
            
}
