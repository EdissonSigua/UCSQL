/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo
 */
public class Crear_Registro {

    public static boolean escribirCrearRegistro(ArrayList<String> tokens) {

        boolean escrito = true;

        try {
            File archivo_tabla = new File("Tablas/" + tokens.get(2) + ".CSV");
            CsvWriter escritor = new CsvWriter(new FileWriter(archivo_tabla, true), ';');

            String campos_ingresados = tokens.get(4), campo = "";
            for (int i = 0; i < campos_ingresados.length(); i++) {
                if (campos_ingresados.charAt(i) == ',') {
                    escritor.write(campo);
                    campo = "";
                } else {
                    campo += campos_ingresados.charAt(i);
                }
            }
            escritor.write(campo);
            escritor.endRecord();
            escritor.flush();
            escritor.close();

        } catch (IOException ex) {
            Logger.getLogger(Crear_Registro.class.getName()).log(Level.SEVERE, null, ex);
            escrito = false;
        }

        return escrito;
    }
}
