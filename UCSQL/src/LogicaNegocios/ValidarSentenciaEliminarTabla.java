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
public class ValidarSentenciaEliminarTabla extends Comando {

    //SINLGETON
    private static ValidarSentenciaEliminarTabla instancia = null;
    
    private ValidarSentenciaEliminarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarSentenciaEliminarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaEliminarTabla(tipoProces);
        }
        return instancia;
    }
    

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la sentencia eliminar tabla este bien escrita
        //ELIMINAR TABLA nombre_tabla
        ArrayList<String> tokens = tipoProceso.getTokens();
        if(tokens.size() == 3)
            return true;
        
        if(tokens.size() > 3)
            errores += "Error -> hay un exceso de argumentos en sentencia ELIMINAR TABLA!!"+"\n";
            //System.out.println("Error -> hay un exceso de argumentos en sentencia ELIMINAR TABLA!!");
        else
            errores += "Error -> muy pocos argumentos en sentencia ELIMINAR TABLA!!"+"\n";
            //System.out.println("Error -> muy pocos argumentos en sentencia ELIMINAR TABLA!!");
        return false;
    }
}
