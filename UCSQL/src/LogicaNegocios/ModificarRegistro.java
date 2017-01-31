/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Modificar_Registro.modificarRegistro;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ModificarRegistro extends Comando {

    //SINLGETON
    private static ModificarRegistro instancia = null;
    
    private ModificarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ModificarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ModificarRegistro(tipoProces);
        }
        return instancia;
    }
    
    
    
    

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a realizar el proceso de modificar un registro
        //MODIFICAR REGISTRO nombre_tabla CLAVE valorCampoClave CAMPO campo_anterior POR valor_campo_nuevo 
        return modificarRegistro(tokens);
    }

}
