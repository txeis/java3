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
    private double bruto, neto, irpf, irpfHijos, extra;
    private int hMes;
    private String mesL;
    
    
    public Nomina(int irpf,double salario){
        this.irpf=irpf;
        this.salario=salario;
        
    }
    
    public void calculaNomina(Empleado empleado){
        
    }
    public String tablaMes(int mes)
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
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }
}
