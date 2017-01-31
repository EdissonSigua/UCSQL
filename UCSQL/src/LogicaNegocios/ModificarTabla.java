/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Modificar_Tabla.proceso_modificar_tabla;

/**
 *
 * @author ediss
 */
public class ModificarTabla extends Comando {

    //SINLGETON
    private static ModificarTabla instancia = null;
    
    private ModificarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ModificarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ModificarTabla(tipoProces);
        }
        return instancia;
    }
    

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar modificar la tabla
        //MODIFICAR TABLA nombre_tabla CAMPO nombre_campo_anterior POR nombre_campo_nuevo
        return proceso_modificar_tabla(tipoProceso.getTokens());
    }

}
