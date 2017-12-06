/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.UtilitiesJ;

/**
 *
 * @author Alejo
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String datoEncriptado = UtilitiesJ.Encriptar("123456");
        System.out.println("este essss el dato encriptado \n" + datoEncriptado);
        try {

            String datodesencriptado = UtilitiesJ.Desencriptar(datoEncriptado);
            System.out.println("desencriptado " + datodesencriptado);
        } catch (Exception ex) {
            Logger.getLogger(MainPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
