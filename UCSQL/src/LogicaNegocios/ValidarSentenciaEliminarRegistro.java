/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarSentenciaEliminarRegistro extends Comando {

    //SINLGETON
    private static ValidarSentenciaEliminarRegistro instancia = null;
    
    private ValidarSentenciaEliminarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarSentenciaEliminarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaEliminarRegistro(tipoProces);
        }
        return instancia;
    }
    

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a validar que la sentencia eliminar registro este bien escrita
        //ELIMINAR REGISTRO nombre_tabla CLAVE valorCampoClave
        if(tokens.size() == 5){
            if("ELIMINAR".equals(tokens.get(0))) {
                if("REGISTRO".equals(tokens.get(1))) {
                    if("CLAVE".equals(tokens.get(3))){
                        return true;
                    }
                    errores += "Error -> Expected: CLAVE - but Founded: "+tokens.get(3)+"\n";
                    //System.out.println("Error -> Expected: CLAVE - but Founded: "+tokens.get(3));
                    return false;
                }
                errores += "Error -> Expected: REGISTRO - but Founded: "+tokens.get(1)+"\n";
                //System.out.println("Error -> Expected: REGISTRO - but Founded: "+tokens.get(1));
                return false;
            }
            errores += "Error -> Expected: ELIMINAR - but Founded: "+tokens.get(0)+"\n";
            //System.out.println("Error -> Expected: ELIMINAR - but Founded: "+tokens.get(0));
            return false;
        }
        errores += "Error falta o hay un exceso de argumentos!!"+"\n";
        //System.out.println("Error falta o hay un exceso de argumentos!!");
        return false;
    }

}
