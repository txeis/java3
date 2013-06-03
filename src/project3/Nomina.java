/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Alumno
 */
public class Nomina {
    private double bruto, neto, irpf, irpfHijos, extra, brutoMirpf;
    
    private int hMes, dinCat;
    private String mesL, mesN;
    
    BaseDatos con;
    int estado;
    Empleado emp;
    int mes;
    
    public Nomina(BaseDatos con,int estado, Empleado emp, int mes){
        this.con=con;
        this.estado=estado;
        this.emp=emp;
        this.mes=mes;
    }
    
   
    public void recogeDatos(){
        String cat=emp.getCategoria();
        dinCat=con.dineroCat(cat);
        if(estado==0){
            bruto=dinCat;
        }
        if(estado==1){
            tablaMes();
        hMes=con.hMes(emp,mesL);
            bruto=dinCat*hMes;
        }
    }
    
    public  void calculoIRPF(){
        if(bruto<600){
            irpf=bruto*0.01;
        }
        else if(bruto>=600 && bruto<=1200){
            irpf=bruto*0.15;
        }
        else{
            irpf=bruto*0.25;
        }
        int numHijos=emp.getnHij();
        if(numHijos>0){
            irpf-=(irpf*0.04);
        }
        irpf=((int)(irpf*100))/100; //dejamos dos decimales
        brutoMirpf=bruto-irpf;
    }
    public void pagasExtraordinarias(){
        if(mes==6 || mes==12){
            extra=brutoMirpf;
        }
        if(mes==9){
            int numHijos=emp.getnHij();
            if(numHijos>0){
                extra=numHijos*100;
            }
        }       
    }
     //ponemos nombre del mes en vez de numero
    public String muestraMes()
    {
        switch(mes)
        {
            case 1:
                mesN="Enero";
                break;
            case 2:
                mesN="Febrero";
                break;
            case 3:
                mesN="Marzo";
                break;
            case 4:
                mesN="Abril";
                break;
            case 5:
                mesN="Mayo";
                break;
            case 6:
                mesN="Junio";
                break;
            case 7:
                mesN="Julio";
                break;
            case 8:
                mesN="Agosto";
                break;
            case 9:
                mesN="Septiembre";
                break;
            case 10:
                mesN="Octubre";
                break;
            case 11:
                mesN="Noviembre";
                break;
            case 12:
                mesN="Diciembre";
                break;
        }
        return mesN;
    }
    //para el nombre del campo de la tabla de la BBDD
    public String tablaMes()
    {
        switch(mes)
        {
            case 1:
                mesL="hEnero";
                break;
            case 2:
                mesL="hFebrero";
                break;
            case 3:
                mesL="hMarzo";
                break;
            case 4:
                mesL="hAbril";
                break;
            case 5:
                mesL="hMayo";
                break;
            case 6:
                mesL="hJunio";
                break;
            case 7:
                mesL="hJulio";
                break;
            case 8:
                mesL="hAgosto";
                break;
            case 9:
                mesL="hSeptiembre";
                break;
            case 10:
                mesL="hOctubre";
                break;
            case 11:
                mesL="hNoviembre";
                break;
            case 12:
                mesL="hDiciembre";
                break;
        }
        return mesL;
    }

    /**
     * @return the bruto
     */
    public double getBruto() {
        return bruto;
    }

    /**
     * @param bruto the bruto to set
     */
    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    /**
     * @return the neto
     */
    public double getNeto() {
        return neto;
    }

    /**
     * @param neto the neto to set
     */
    public void setNeto(double neto) {
        this.neto = neto;
    }

    /**
     * @return the irpf
     */
    public double getIrpf() {
        return irpf;
    }

    /**
     * @param irpf the irpf to set
     */
    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

    /**
     * @return the irpfHijos
     */
    public double getIrpfHijos() {
        return irpfHijos;
    }

    /**
     * @param irpfHijos the irpfHijos to set
     */
    public void setIrpfHijos(double irpfHijos) {
        this.irpfHijos = irpfHijos;
    }

    /**
     * @return the extra
     */
    public double getExtra() {
        return extra;
    }

    /**
     * @param extra the extra to set
     */
    public void setExtra(double extra) {
        this.extra = extra;
    }

    /**
     * @return the hMes
     */
    public int gethMes() {
        return hMes;
    }

    /**
     * @param hMes the hMes to set
     */
    public void sethMes(int hMes) {
        this.hMes = hMes;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mesL;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mesL) {
        this.mesL = mesL;
    }
}
