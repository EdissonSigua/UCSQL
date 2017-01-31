/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static datos.Existencia_Numero_Campos.verificarExistenciaNumeroCamposYLongitud;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarExistenciaTablaCrearRegistro extends Comando {

    //SINLGETON
    private static ValidarExistenciaTablaCrearRegistro instancia = null;

    private ValidarExistenciaTablaCrearRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarExistenciaTablaCrearRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaTablaCrearRegistro(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        //Aqui se va a validar que la tabla en donde se va a crear el registro exista
        //CREAR REGISTRO nombre_tabla VALOR vCampo1 , vCampo2 ,... , vCampoN
        if (super.validarExistenciaTabla(2)) {
            return verificarExistenciaNumeroCamposYLongitud(tokens);
        }

        return false;

    }
}
