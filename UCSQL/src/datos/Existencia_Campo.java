/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import LogicaNegocios.ValidarExistenciaCampoSeleccionado;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo
 */
public class Existencia_Campo {

    public static boolean verificarExistenciaCampo(ArrayList<String> tokens, int pos) {
        boolean existencia = false;
        File archivo = new File("Tablas/" + tokens.get(2) + ".CSV");
        try {
            CsvReader lector = new CsvReader(new FileReader(archivo), ';');
            lector.readHeaders();
            String[] arrayHeaders = lector.getHeaders();
            for (int i = 0; i < arrayHeaders.length; i++) {
                if (arrayHeaders[i].equals(tokens.get(pos))) {
                    existencia = true;
                }
            }
            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarExistenciaCampoSeleccionado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarExistenciaCampoSeleccionado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existencia;
    }

}
