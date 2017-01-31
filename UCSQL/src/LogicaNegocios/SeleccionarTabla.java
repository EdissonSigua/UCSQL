/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static datos.Seleccionar_Tabla.buscarSeleccionarTabla;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class SeleccionarTabla extends Comando {

    //SINLGETON
    private static SeleccionarTabla instancia = null;

    private SeleccionarTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static SeleccionarTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null)  {
            instancia = new SeleccionarTabla(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        //Aqui se va arealizar el proceso de seleccionar la tabla
        //SELECCIONAR DE nombre_tabla DONDE nombre_campo = “Algo”
        System.out.println("hola1");
        return buscarSeleccionarTabla(tokens);
    }

}
