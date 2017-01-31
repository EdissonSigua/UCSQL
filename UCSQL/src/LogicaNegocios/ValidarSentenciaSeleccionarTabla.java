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
public class ValidarSentenciaSeleccionarTabla extends Comando {

    //SINLGETON
    private static ValidarSentenciaSeleccionarTabla instancia = null;

    private ValidarSentenciaSeleccionarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarSentenciaSeleccionarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaSeleccionarTabla(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        //Aqui se va a validar que la sentencia seleccionar tabla este bien escrita
        //SELECCIONAR DE nombre_tabla DONDE nombre_campo = “Algo”
        
        if (tokens.size() == 7) {
            if (tokens.get(1).equals("DE")) {
                if (tokens.get(3).equals("DONDE")) {
                    if (tokens.get(5).equals("=")) {
                        return true;
                    } else {
                        errores += "Error -> Expected: '=' in: " + tokens.get(4)+"\n";
                        //System.out.println("Error -> Expected: '=' in: " + tokens.get(4));
                        return false;
                    }
                } else {
                    errores += "Error -> Expected: DONDE - but Founded: " + tokens.get(3)+"\n";
                    //System.out.println("Error -> Expected: DONDE - but Founded: " + tokens.get(3));
                    return false;
                }
            } else {
                errores += "Error -> Expected: DE - but Founded: " + tokens.get(1)+"\n";
                //System.out.println("Error -> Expected: DE - but Founded: " + tokens.get(1));
                return false;
            }
        }
        errores += "Error falta o hay un exceso de argumentos!!"+"\n";
        //System.out.println("Error falta o hay un exceso de argumentos!!");
        return false;
    }

}
