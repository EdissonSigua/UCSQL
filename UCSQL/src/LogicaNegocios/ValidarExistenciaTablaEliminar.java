/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;



/**
 *
 * @author ediss
 */
public class ValidarExistenciaTablaEliminar extends Comando {

    //SINLGETON
    private static ValidarExistenciaTablaEliminar instancia = null;

    private ValidarExistenciaTablaEliminar(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarExistenciaTablaEliminar getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaTablaEliminar(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la tabla que se dea eliminar exista
        //ELIMINAR TABLA nombre_tabla
        return super.validarExistenciaTabla(2);
    }
}
