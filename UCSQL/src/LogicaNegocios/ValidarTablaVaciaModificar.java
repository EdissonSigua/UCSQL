/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static CapaPruebas.Prueba.errores;
import static datos.Tabla_Vacia.verificarTablaVacia;

/**
 *
 * @author ediss
 */
public class ValidarTablaVaciaModificar extends Comando {

    
    //SINLGETON
    private static ValidarTablaVaciaModificar instancia = null;
    
    private ValidarTablaVaciaModificar(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static ValidarTablaVaciaModificar getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarTablaVaciaModificar(tipoProces);
        }
        return instancia;
    }
    
    

    @Override
    public boolean ejecutar() {
        //Aqui se va a validar que la tabla SI este vacia si se quiere modificar sus campos
        //MODIFICAR TABLA nombre_tabla CAMPO nombre_campo_anterior POR nombre_campo_nuevo
        if(verificarTablaVacia(tipoProceso.getTokens(),2))
            return true;
        
        errores += "La tabla '"+tipoProceso.getTokens().get(2)+"' no se puede modificar porque tiene registros"+"\n";
        //System.out.println("La tabla '"+tipoProceso.getTokens().get(2)+"' no se puede modificar porque tiene registros");
        return false;
    }
}
