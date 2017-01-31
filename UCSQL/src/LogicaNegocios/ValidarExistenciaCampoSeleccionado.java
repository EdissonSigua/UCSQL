/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Existencia_Campo.verificarExistenciaCampo;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarExistenciaCampoSeleccionado extends Comando {

    //SINLGETON
    private static ValidarExistenciaCampoSeleccionado instancia = null;
    
    private ValidarExistenciaCampoSeleccionado(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarExistenciaCampoSeleccionado getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaCampoSeleccionado(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a validar que el campo seleccionado exista en la tabla
        //SELECCIONAR DE nombre_tabla DONDE nombre_campo = “Algo”
        if (verificarExistenciaCampo(tokens,4)) {
            return true;
        }
        errores += "La Tabla '"+tipoProceso.getTokens().get(2)+"' no tiene el campo '"+tipoProceso.getTokens().get(4)+"'"+"\n";
        //System.out.println("La Tabla '"+tipoProceso.getTokens().get(2)+"' no tiene el campo '"+tipoProceso.getTokens().get(4)+"'");
        return false;
    }
}
