/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejo
 */
public class Trivia {
    
    private String temat;
    private int idT;

    public Trivia() {
    }

    public Trivia(String temat) {
        this.temat = temat;
    }

    public Trivia(String temat, int idT) {
        this.temat = temat;
        this.idT = idT;
    }
    
   /**
     * Get the value of idT
     *
     * @return the value of idT
     */
    public int getIdT() {
        return idT;
    }

    /**
     * Set the value of idT
     *
     * @param idT new value of idT
     */
    public void setIdT(int idT) {
        this.idT = idT;
    }
    
    /**
     * Get the value of temat
     *
     * @return the value of temat
     */
    public String getTemat() {
        return temat;
    }

    /**
     * Set the value of temat
     *
     * @param temat new value of temat
     */
    public void setTemat(String temat) {
        this.temat = temat;
    }

    @Override
    public String toString() {
        return "Trivia{" + "temat=" + temat + '}';
    }

}
