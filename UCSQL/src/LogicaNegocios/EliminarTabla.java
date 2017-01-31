/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;


import static datos.Eliminar_Tabla.escribirEliminarTabla;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class EliminarTabla extends Comando {

    //SINLGETON
    private static EliminarTabla instancia = null;
    
    private EliminarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static EliminarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new EliminarTabla(tipoProces);
        }
        return instancia;
    }
    
     
    @Override
    public boolean ejecutar() {
        return escribirEliminarTabla(tipoProceso.getTokens());
    }
    
}
