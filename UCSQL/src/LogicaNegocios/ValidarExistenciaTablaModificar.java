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
public class ValidarExistenciaTablaModificar extends Comando {

    //SINLGETON
    private static ValidarExistenciaTablaModificar instancia = null;

    private ValidarExistenciaTablaModificar(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarExistenciaTablaModificar getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaTablaModificar(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la tabla que se ingresa en la sentencia exista en la base de datos
        //MODIFICAR TABLA nombre_tabla CAMPO nombre_campo_anterior POR nombre_campo_nuevo
        return super.validarExistenciaTabla(2);
    }
}
