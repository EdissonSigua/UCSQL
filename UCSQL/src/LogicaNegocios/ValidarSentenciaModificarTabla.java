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
public class ValidarSentenciaModificarTabla extends Comando {

    //SINLGETON
    private static ValidarSentenciaModificarTabla instancia = null;

    private ValidarSentenciaModificarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarSentenciaModificarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaModificarTabla(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        //Aqui se va a validar que la sentencia modificar una tabla este bien escrita
        //MODIFICAR TABLA nombre_tabla CAMPO nombre_campo_anterior POR nombre_campo_nuevo

        if (tokens.size() == 7) {
            if ("MODIFICAR".equals(tokens.get(0))) {
                if ("TABLA".equals(tokens.get(1))) {
                    if ("CAMPO".equals(tokens.get(3))) {
                        if ("POR".equals(tokens.get(5))) {
                            return true;
                        }
                        errores += "Error -> Expected: POR- but Founded:  " + tokens.get(5)+"\n";
                        //System.out.println("Error -> Expected: POR- but Founded:  " + tokens.get(5));
                        return false;
                    }
                    errores += "Error -> Expected: CAMPO - but Founded:  " + tokens.get(3)+"\n";
                    //System.out.println("Error -> Expected: CAMPO - but Founded:  " + tokens.get(3));
                    return false;
                }

                errores += "Error -> Expected: TABLA - but Founded:  " + tokens.get(1)+"\n";
                //System.out.println("Error -> Expected: TABLA - but Founded:  " + tokens.get(1));
                return false;

            }
            errores += "Error -> Expected: MODIFICAR - but Founded: " + tokens.get(0)+"\n";
            //System.out.println("Error -> Expected: MODIFICAR - but Founded: " + tokens.get(0));
            return false;
        }
        errores += "Error falta o hay un exceso de argumentos!!"+"\n";
        //System.out.println("Error falta o hay un exceso de argumentos!!");
        return false;
    }

}
