/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;


import java.util.ArrayList;
import static datos.Longitud_Campos.verificarLongitudCampos;
/**
 *
 * @author Mateo
 */
public class ValidarLongitudCampo extends Comando{

    //SINLGETON
    private static ValidarLongitudCampo instancia = null;
    
    private ValidarLongitudCampo(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarLongitudCampo getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarLongitudCampo(tipoProces);
        }
        return instancia;
    }
    
    
     
    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens  = tipoProceso.getTokens();
        //Aqui se va a validar que exista el campo calve y el campo anterior de la sentencia
        //MODIFICAR REGISTRO nombre_tabla CLAVE valorCampoClave CAMPO campo_anterior POR valor_campo_nuevo 
        return verificarLongitudCampos(tokens,tokens.get(8).length(),tokens.get(8))==0;
    }
    
}
