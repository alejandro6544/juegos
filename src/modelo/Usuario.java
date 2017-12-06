/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dacastro
 */
public class Usuario {
    
    private String idu;
    private String nombre1u;
    private String nombre2u;
    private String apellidou1;
    private String apellidou2;
    private String correou;
    private String contraseniau;
    private String celularu;
    private boolean adminu;

    public Usuario() {
    }

    public Usuario(String idu, String nombre1u, String nombre2u, String apellidou1, String apellidou2, String correou, String contraseniau, String celularu, boolean adminu) {
        this.idu = idu;
        this.nombre1u = nombre1u;
        this.nombre2u = nombre2u;
        this.apellidou1 = apellidou1;
        this.apellidou2 = apellidou2;
        this.correou = correou;
        this.contraseniau = contraseniau;
        this.celularu = celularu;
        this.adminu = adminu;
    }

    /**
     * Get the value of adminu
     *
     * @return the value of adminu
     */
    public boolean isAdminu() {
        return adminu;
    }

    /**
     * Set the value of adminu
     *
     * @param adminu new value of adminu
     */
    public void setAdminu(boolean adminu) {
        this.adminu = adminu;
    }


    /**
     * Get the value of stringcelularu
     *
     * @return the value of stringcelularu
     */
    public String getCelularu() {
        return celularu;
    }

    /**
     * Set the value of stringcelularu
     *
     * @param stringcelularu new value of stringcelularu
     */
    public void setCelularu(String stringcelularu) {
        this.celularu = stringcelularu;
    }


    /**
     * Get the value of contraseniau
     *
     * @return the value of contraseniau
     */
    public String getContraseniau() {
        return contraseniau;
    }

    /**
     * Set the value of contraseniau
     *
     * @param contraseniau new value of contraseniau
     */
    public void setContraseniau(String contraseniau) {
        this.contraseniau = contraseniau;
    }


    /**
     * Get the value of correou
     *
     * @return the value of correou
     */
    public String getCorreou() {
        return correou;
    }

    /**
     * Set the value of correou
     *
     * @param correou new value of correou
     */
    public void setCorreou(String correou) {
        this.correou = correou;
    }


    /**
     * Get the value of apellidou2
     *
     * @return the value of apellidou2
     */
    public String getApellidou2() {
        return apellidou2;
    }

    /**
     * Set the value of apellidou2
     *
     * @param apellidou2 new value of apellidou2
     */
    public void setApellidou2(String apellidou2) {
        this.apellidou2 = apellidou2;
    }


    /**
     * Get the value of apellidou1
     *
     * @return the value of apellidou1
     */
    public String getApellidou1() {
        return apellidou1;
    }

    /**
     * Set the value of apellidou1
     *
     * @param apellidou1 new value of apellidou1
     */
    public void setApellidou1(String apellidou1) {
        this.apellidou1 = apellidou1;
    }


    /**
     * Get the value of stringnombre2u
     *
     * @return the value of stringnombre2u
     */
    public String getNombre2u() {
        return nombre2u;
    }

    /**
     * Set the value of stringnombre2u
     *
     * @param stringnombre2u new value of stringnombre2u
     */
    public void setNombre2u(String stringnombre2u) {
        this.nombre2u = stringnombre2u;
    }


    /**
     * Get the value of nombre1u
     *
     * @return the value of nombre1u
     */
    public String getNombre1u() {
        return nombre1u;
    }

    /**
     * Set the value of nombre1u
     *
     * @param nombre1u new value of nombre1u
     */
    public void setNombre1u(String nombre1u) {
        this.nombre1u = nombre1u;
    }


    /**
     * Get the value of idu
     *
     * @return the value of idu
     */
    public String getIdu() {
        return idu;
    }

    /**
     * Set the value of idu
     *
     * @param idu new value of idu
     */
    public void setIdu(String idu) {
        this.idu = idu;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idu=" + idu + ", nombre1u=" + nombre1u + ", nombre2u=" + nombre2u + ", apellidou1=" + apellidou1 + ", apellidou2=" + apellidou2 + ", correou=" + correou + ", contraseniau=" + contraseniau + ", celularu=" + celularu + ", adminu=" + adminu + '}';
    }

}
