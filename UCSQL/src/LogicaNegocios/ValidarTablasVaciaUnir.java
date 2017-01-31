/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Tabla_Vacia.verificarTablaVacia;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class ValidarTablasVaciaUnir extends Comando {

    //SINLGETON
    private static ValidarTablasVaciaUnir instancia = null;

    private ValidarTablasVaciaUnir(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarTablasVaciaUnir getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarTablasVaciaUnir(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        //Aqui se va a validar que las tablas que se desean unir tengan datos que no esten vacias
        //UNIR nombre_tabla1, nombre_tabla2 POR nombre_campo

        if (!verificarTablaVacia(tipoProceso.getTokens(), 1)) {
            if (!verificarTablaVacia(tipoProceso.getTokens(), 2)) {
                return true;
            }
            errores += "La tabla '" + tipoProceso.getTokens().get(1) + "' no se unir porque no tiene registros"+"\n";
            //System.out.println("La tabla '" + tipoProceso.getTokens().get(1) + "' no se unir porque no tiene registros");
            return false;
        }
        errores += "La tabla '" + tipoProceso.getTokens().get(2) + "' no se puede unir porque no tiene registros"+"\n";
        //System.out.println("La tabla '" + tipoProceso.getTokens().get(2) + "' no se puede unir porque no tiene registros");
        return false;
    }
}
