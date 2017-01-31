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
public class ValidarSentenciaModificarRegistro extends Comando {

    //SINLGETON
    private static ValidarSentenciaModificarRegistro instancia = null;
    
    private ValidarSentenciaModificarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarSentenciaModificarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaModificarRegistro(tipoProces);
        }
        return instancia;
    }
    
    
    
    

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a validar que la sentencia modificar registro este bien escrita
        //MODIFICAR REGISTRO nombre_tabla CLAVE valorCampoClave CAMPO campo_anterior POR valor_campo_nuevo 
        if(tokens.size()==9){
            if(tokens.get(3).equals("CLAVE")){
                if(tokens.get(5).equals("CAMPO")){
                    if(tokens.get(7).equals("POR")){
                        return true;
                    }else{
                        errores += "Error -> Expected: POR - but Founded: "+tokens.get(7)+"\n";
                        //System.out.println("Error -> Expected: POR - but Founded: "+tokens.get(7));
                        return false;
                    }
                }else{
                    errores += "Error -> Expected: CAMPO - but Founded: "+tokens.get(5)+"\n";
                    //System.out.println("Error -> Expected: CAMPO - but Founded: "+tokens.get(5));
                    return false;
                }
            }else{
                errores += "Error -> Expected: CLAVE - but Founded: "+tokens.get(3)+"\n";
                //System.out.println("Error -> Expected: CLAVE - but Founded: "+tokens.get(3));
                return false;
            }
        }
        errores += "Error falta o hay un exceso de argumentos!!"+"\n";
        //System.out.println("Error falta o hay un exceso de argumentos!!");
        return false;
    }
}
