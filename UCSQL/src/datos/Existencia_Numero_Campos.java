/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static CapaPruebas.Prueba.errores;
import LogicaNegocios.ValidarExistenciaTablaCrearRegistro;
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
public class Existencia_Numero_Campos {

    public static boolean verificarExistenciaNumeroCamposYLongitud(ArrayList<String> tokens) {
        int numero_campos_nuevos = 0, numero_campos_tabla = 0, longitud_campo = 0;

        try {
            File archivo = new File("ArchivoMetaBD/MetaBD.CSV");
            CsvReader lector = new CsvReader(new FileReader(archivo), ';');
            lector.readHeaders();
            while (lector.readRecord()) {
                if (tokens.get(2).equals(lector.get("Nombre_Tabla"))) {
                    numero_campos_tabla = Integer.parseInt(lector.get("Numero_Campos"));
                    longitud_campo = Integer.parseInt(lector.get("Longitud_Campos"));
                }
            }
            lector.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarExistenciaTablaCrearRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarExistenciaTablaCrearRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

        //obtenemos el numero de campos que fueron ingresados en la tabla
        //y verificamos que el tamaño no esceda el maximo permitido para 
        //los campos de la tabla seleccionada
        boolean equal_tam_campo = true;
        int cont = 0;
        for (int i = 0; i < tokens.get(4).length(); i++) {
            if ((tokens.get(4).charAt(i)) == ',') {
                numero_campos_nuevos++;
                if (cont > longitud_campo) {
                    equal_tam_campo = false;
                }
                cont = 0;
            } else {
                cont++;
            }
        }
        numero_campos_nuevos++;

        if (numero_campos_nuevos != numero_campos_tabla) {
            errores += "Error -> el numero de campos no coincide. Numero de Campos de la Tabla '" + tokens.get(2) + "' es " + numero_campos_tabla+"\n";
            //System.out.println("Error -> el numero de campos no coincide. Numero de Campos de la Tabla '" + tokens.get(2) + "' es " + numero_campos_tabla);
            return false;
        }

        if (!equal_tam_campo) {
            errores += "Error -> el tamaño de algun campo excede el tamaño maximo permitido. Longitud Maxima permitida de Campos de la Tabla '" + tokens.get(2) + "' es " + longitud_campo + " caracteres."+"\n";
            //System.out.println("Error -> el tamaño de algun campo excede el tamaño maximo permitido. Longitud Maxima permitida de Campos de la Tabla '" + tokens.get(2) + "' es " + longitud_campo + " caracteres.");
            return false;
        }

        return true;
    }
}
