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

    public Trivia() {
    }

    public Trivia(String temat) {
        this.temat = temat;
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
