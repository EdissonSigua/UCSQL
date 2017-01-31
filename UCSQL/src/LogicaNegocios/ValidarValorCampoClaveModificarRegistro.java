/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;


import static datos.Existencia_Valor_Campo_Clave.verificarExistenciaValorCampoClave;

/**
 *
 * @author Mateo
 */
public class ValidarValorCampoClaveModificarRegistro extends Comando{

    //SINLGETON
    private static ValidarValorCampoClaveModificarRegistro instancia = null;
    
    private ValidarValorCampoClaveModificarRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarValorCampoClaveModificarRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarValorCampoClaveModificarRegistro(tipoProces);
        }
        return instancia;
    }
    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que exista el valor del campo clave 
        //MODIFICAR REGISTRO nombre_tabla CLAVE valorCampoClave CAMPO campo_anterior POR valor_campo_nuevo 
        return verificarExistenciaValorCampoClave(tipoProceso.getTokens());
    }
    
}
