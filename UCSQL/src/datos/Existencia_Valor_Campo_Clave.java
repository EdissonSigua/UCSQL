/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static CapaPruebas.Prueba.errores;
import LogicaNegocios.ValidarTablaVaciaEliminarRegistro;
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
public class Existencia_Valor_Campo_Clave {

    public static boolean verificarExistenciaValorCampoClave(ArrayList<String> tokens) {
        boolean existe = false;
        ArrayList<String> campos = new ArrayList<>();
        File archivoMetaBD = new File("ArchivoMetaBD/METABD.CSV");
        File archivoTabla = new File("Tablas/" + tokens.get(2) + ".CSV");
        String campoClaveMetaBd = "";

        try {
            CsvReader lectorMetaBd = new CsvReader(new FileReader(archivoMetaBD), ';');
            lectorMetaBd.readHeaders();
            while (lectorMetaBd.readRecord()) {
                // almacenar en una variable el campo clave del METABD 
                if (lectorMetaBd.get("Nombre_Tabla").equals(tokens.get(2))) {
                    campoClaveMetaBd = lectorMetaBd.get("Campo_Clave");
                }
            }

            CsvReader lectorTabla = new CsvReader(new FileReader(archivoTabla), ';');
            lectorTabla.readHeaders();
            String[] cabecerasTabla = lectorTabla.getHeaders();
            // buscar en las cabeceras de la  tabla cual es el campo clave
            for (int i = 0; i < cabecerasTabla.length; i++) {
                if (cabecerasTabla[i].equals(campoClaveMetaBd)) {
                    // buscar en la tabla  que el valor del campo clave exista
                    while (lectorTabla.readRecord()) {
                        if (lectorTabla.get(campoClaveMetaBd).equals(tokens.get(4))) {
                            existe = true;
                        }
                    }
                }
            }

            lectorTabla.close();
            lectorMetaBd.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarTablaVaciaEliminarRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarTablaVaciaEliminarRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (existe) {
            return true;
        } else {
            errores += "El valor '" + tokens.get(4) + "' del campo clave '" + campoClaveMetaBd + "' no existe en la tabla '" + tokens.get(2) + "'" + "\n";
            //System.out.println("El valor '" + tokens.get(4) + "' del campo clave '" + campoClaveMetaBd + "' no existe en la tabla '" + tokens.get(2) + "'");
            return false;
        }
    }
}
