/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Tabla_Vacia.verificarTablaVacia;

/**
 *
 * @author ediss
 */
public class ValidarTablaVaciaEliminarRegistro extends Comando {

    //SINLGETON
    private static ValidarTablaVaciaEliminarRegistro instancia = null;

    private ValidarTablaVaciaEliminarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarTablaVaciaEliminarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarTablaVaciaEliminarRegistro(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la tabla de la que se quiere eliminar un registro exista
        //ELIMINAR REGISTRO nombre_tabla CLAVE valorCampoClave
        if(!verificarTablaVacia(tipoProceso.getTokens(),2))
            return true;
         
        errores += "La tabla '"+tipoProceso.getTokens().get(2)+"' no tiene registros para eliminar"+"\n";
        //System.out.println("La tabla '"+tipoProceso.getTokens().get(2)+"' no tiene registros para eliminar");
        return false;
    }

}
