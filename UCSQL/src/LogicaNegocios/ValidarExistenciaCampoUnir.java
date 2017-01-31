/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Existencia_Campos_Unir.verificarExistenciaCampo;

/**
 *
 * @author ediss
 */
public class ValidarExistenciaCampoUnir extends Comando {

    //SINLGETON
    private static ValidarExistenciaCampoUnir instancia = null;

    private ValidarExistenciaCampoUnir(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarExistenciaCampoUnir getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaCampoUnir(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que el campo por el que se desea unir la tabla exista
        //UNIR nombre_tabla1, nombre_tabla2 POR nombre_campo
        if (verificarExistenciaCampo(tipoProceso.getTokens(), 4) == 0) {
            return true;
        }

        if (verificarExistenciaCampo(tipoProceso.getTokens(), 4) == 1) {
            errores += "El campo '" + tipoProceso.getTokens().get(4) + "' no existe en la tabla '" + tipoProceso.getTokens().get(1) + "'"+"\n";
            //System.out.println("El campo '" + tipoProceso.getTokens().get(4) + "' no existe en la tabla '" + tipoProceso.getTokens().get(1) + "'");
        }

        if (verificarExistenciaCampo(tipoProceso.getTokens(), 4) == 2) {
            errores += "El campo '" + tipoProceso.getTokens().get(4) + "' no existe en la tabla '" + tipoProceso.getTokens().get(2) + "'"+"\n";
            //System.out.println("El campo '" + tipoProceso.getTokens().get(4) + "' no existe en la tabla '" + tipoProceso.getTokens().get(2) + "'");
        }

        return false;
    }
}
