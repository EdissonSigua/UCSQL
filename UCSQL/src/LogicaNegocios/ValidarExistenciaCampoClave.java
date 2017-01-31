/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Existencia_Valor_Campo_Clave.verificarExistenciaValorCampoClave;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarExistenciaCampoClave extends Comando {

    //SINLGETON
    private static ValidarExistenciaCampoClave instancia = null;
    
    private ValidarExistenciaCampoClave(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarExistenciaCampoClave getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaCampoClave(tipoProces);
        }
        return instancia;
    }
    

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a validar que exista un registro con el campo clave que ingreso en la sentencia.
        //ELIMINAR REGISTRO nombre_tabla CLAVE valorCampoClave
        return verificarExistenciaValorCampoClave(tipoProceso.getTokens());
    }

}