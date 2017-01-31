/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class Tabla_Vacia {
    public static boolean verificarTablaVacia(ArrayList<String> tokens,int pos) {
        boolean vacio=true;
        File archivo =new File("Tablas/"+tokens.get(pos)+".CSV");
        try {
            CsvReader lector = new CsvReader(new FileReader(archivo), ';');
            lector.readHeaders();
            while (lector.readRecord()) {
                vacio=false;
            }
            lector.close();
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ValidarTablaVaciaModificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ValidarTablaVaciaModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        if(vacio)
            return true;
        
        return false;
    }
    
}
