/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarSentenciaCrearRegistro extends Comando {

    //SINLGETON
    private static ValidarSentenciaCrearRegistro instancia = null;

    private ValidarSentenciaCrearRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarSentenciaCrearRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaCrearRegistro(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar la sentencia crear un registro
        //CREAR REGISTRO nombre_tabla VALOR vCampo1,vCampo2 ,... , vCampoN
        ArrayList<String> tokens = tipoProceso.getTokens();
        if (tokens.size() == 5) {
            if ("VALOR".equals(tokens.get(3))) {
                return true;
            }

            errores += "Error -> Expected: VALOR - but Founded: " + tokens.get(3)+"\n";
            //System.out.println("Error -> Expected: VALOR - but Founded: " + tokens.get(3));
            return false;
        }

        if (tokens.size() > 5) {
            errores += "Error -> hay un exceso de argumentos en sentencia CREAR REGISTRO!!"+"\n";
            //System.out.println("Error -> hay un exceso de argumentos en sentencia CREAR REGISTRO!!");
        } else {
            errores += "Error -> muy pocos argumentos en sentencia CREAR REGISTRO!!"+"\n";
            //System.out.println("Error -> muy pocos argumentos en sentencia CREAR REGISTRO!!");
        }

        return false;
    }

}
