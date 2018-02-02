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
public class Preguntas {

    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private char respuestacorrecta;
    private String rutaimagen;
    private int fkTrivia;

    public Preguntas() {
    }

    public Preguntas(String pregunta, String respuesta1, String respuesta2, String respuesta3, char respuestacorrecta, String rutaimagen) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuestacorrecta = respuestacorrecta;
        this.rutaimagen = rutaimagen;
    }

    public Preguntas(String pregunta, String respuesta1, String respuesta2, String respuesta3, char respuestacorrecta, int fkTrivia) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuestacorrecta = respuestacorrecta;
        this.fkTrivia = fkTrivia;
    }

    public int getFkTrivia() {
        return fkTrivia;
    }

    public void setFkTrivia(int fkTrivia) {
        this.fkTrivia = fkTrivia;
    }

    /**
     * Get the value of rutaimagen
     *
     * @return the value of rutaimagen
     */
    public String getRutaimagen() {
        return rutaimagen;
    }

    /**
     * Set the value of rutaimagen
     *
     * @param rutaimagen new value of rutaimagen
     */
    public void setRutaimagen(String rutaimagen) {
        this.rutaimagen = rutaimagen;
    }

    /**
     * Get the value of respuestacorrecta
     *
     * @return the value of respuestacorrecta
     */
    public char getRespuestacorrecta() {
        return respuestacorrecta;
    }

    /**
     * Set the value of respuestacorrecta
     *
     * @param respuestacorrecta new value of respuestacorrecta
     */
    public void setRespuestacorrecta(char respuestacorrecta) {
        this.respuestacorrecta = respuestacorrecta;
    }

    /**
     * Get the value of respuesta3
     *
     * @return the value of respuesta3
     */
    public String getRespuesta3() {
        return respuesta3;
    }

    /**
     * Set the value of respuesta3
     *
     * @param respuesta3 new value of respuesta3
     */
    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    /**
     * Get the value of respuesta2
     *
     * @return the value of respuesta2
     */
    public String getRespuesta2() {
        return respuesta2;
    }

    /**
     * Set the value of respuesta2
     *
     * @param respuesta2 new value of respuesta2
     */
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    /**
     * Get the value of respuesta1
     *
     * @return the value of respuesta1
     */
    public String getRespuesta1() {
        return respuesta1;
    }

    /**
     * Set the value of respuesta1
     *
     * @param respuesta1 new value of respuesta1
     */
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    /**
     * Get the value of pregunta
     *
     * @return the value of pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Set the value of pregunta
     *
     * @param pregunta new value of pregunta
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Preguntas{" + "pregunta=" + pregunta + ", respuesta1=" + respuesta1 + ", respuesta2=" + respuesta2 + ", respuesta3=" + respuesta3 + ", respuestacorrecta=" + respuestacorrecta + '}';
    }

}
