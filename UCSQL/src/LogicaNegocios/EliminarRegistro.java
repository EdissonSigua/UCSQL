/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Eliminar_Registro.proceso_eliminar_registro;

/**
 *
 * @author ediss
 */
public class EliminarRegistro extends Comando {

    //SINLGETON
    private static EliminarRegistro instancia = null;
    
    private EliminarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static EliminarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new EliminarRegistro(tipoProces);
        }
        return instancia;
    }
    

    @Override
    public boolean ejecutar() {
        //Aqui se va a realizar el proceso de eliminar un registro
        //ELIMINAR REGISTRO nombre_tabla CLAVE valorCampoClave
        if (proceso_eliminar_registro(tipoProceso.getTokens())) 
            return true;
        
        errores += "No se pudo eliminar el registro debido a un error inesperado... Intentelo de nuevo!"+"\n";
        //System.out.println("No se pudo eliminar el registro debido a un error inesperado... Intentelo de nuevo!");
        return false;
    }

}