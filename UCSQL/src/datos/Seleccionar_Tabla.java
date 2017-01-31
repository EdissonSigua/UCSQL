/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import LogicaNegocios.SeleccionarTabla;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo
 */
public class Seleccionar_Tabla {
    public static String seleccionar;

    public static boolean buscarSeleccionarTabla(ArrayList<String> parametros) {
        boolean aux = false;
        int pos = 0;
        String seleccion = "";
        try {
            File archivo = new File("Tablas/" + parametros.get(2) + ".CSV");
            CsvReader lector = new CsvReader(new FileReader(archivo), ';');
            lector.readHeaders();
            String[] arrayHeaders = lector.getHeaders();
            for (int i = 0; i < arrayHeaders.length; i++) {
                if (arrayHeaders[i].equals(parametros.get(4))) {
                    pos = i;
                }
            }
            while (lector.readRecord()) {
                if (lector.get(pos).equals(parametros.get(6))) {
                    seleccion += Arrays.toString(lector.getValues()) + "\n";
                    aux = true;
                }
            }
            System.out.println(seleccion);
            seleccionar=seleccion;
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SeleccionarTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SeleccionarTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
}
