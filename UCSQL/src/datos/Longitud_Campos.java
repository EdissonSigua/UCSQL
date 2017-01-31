/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static CapaPruebas.Prueba.errores;
import LogicaNegocios.ValidarLongitudCampo;
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
public class Longitud_Campos {
    public static int verificarLongitudCampos(ArrayList<String> tokens,int longitud,String texto) {
        boolean comprobacion=false;
        int longitudCampo=0;
        File archivo = new File("ArchivoMetaBD/MetaBD.CSV");
        try {
            CsvReader lector = new CsvReader(new FileReader(archivo), ';');
            lector.readHeaders();
            while (lector.readRecord()){
                if(tokens.get(2).equals(lector.get("Nombre_Tabla"))){
                   if(longitud<=Integer.parseInt(lector.get("Longitud_Campos")))
                       comprobacion=true;
                   else
                       longitudCampo=Integer.parseInt(lector.get("Longitud_Campos"));
                       
                }
            }
            lector.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarLongitudCampo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarLongitudCampo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(comprobacion)
            return 0;
        else{
            errores += "El campo '"+texto+"' ingresado excede la longitud de '"+longitudCampo+"' del campo '"+tokens.get(6)+"'"+"\n";
            //System.out.println("El campo '"+texto+"' ingresado excede la longitud de '"+longitudCampo+"' del campo '"+tokens.get(6)+"'");
            return 1;
        }
    }
}
