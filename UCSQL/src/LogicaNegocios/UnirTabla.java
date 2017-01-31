/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Unir_Tabla.proceso_unir_tabla;

/**
 *
 * @author ediss
 */
public class UnirTabla extends Comando {

    //SINLGETON
    private static UnirTabla instancia = null;
    
    private UnirTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static UnirTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new UnirTabla(tipoProces);
        }
        return instancia;
    }
    
     
    @Override
    public boolean ejecutar() {
        //Aqui se va a validar realizar el proceso de unir las tablas
        //UNIR nombre_tabla1, nombre_tabla2 POR nombre_campo
        return proceso_unir_tabla(tipoProceso.getTokens());
    }

}
