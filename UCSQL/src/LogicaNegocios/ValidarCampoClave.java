/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;
 
import static datos.Existencia_Campo_Clave.verificarNoExistenciaCampoClave;

/**
 *
 * @author Mateo
 */
public class ValidarCampoClave extends Comando {

    //SINLGETON
    private static ValidarCampoClave instancia = null;

    private ValidarCampoClave(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarCampoClave getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarCampoClave(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la el campo clave que nosotros querramos ingresar no exista en algun registro
        //CREAR REGISTRO nombre_tabla VALOR vCampo1,vCampo2,...,vCampoN
        return verificarNoExistenciaCampoClave(tipoProceso.getTokens());
    }

}
