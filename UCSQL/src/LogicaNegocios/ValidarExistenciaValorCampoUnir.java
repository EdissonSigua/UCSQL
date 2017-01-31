/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Existencia_Valor_Campo.verificarExistenciaValorCampo;

/**
 *
 * @author David
 */
public class ValidarExistenciaValorCampoUnir extends Comando{
    //SINLGETON
    private static ValidarExistenciaValorCampoUnir instancia = null;
    
    private ValidarExistenciaValorCampoUnir(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarExistenciaValorCampoUnir getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaValorCampoUnir(tipoProces);
        }
        return instancia;
    }
      
    @Override
    public boolean ejecutar() {
       return verificarExistenciaValorCampo(tipoProceso.getTokens());
    }
}
