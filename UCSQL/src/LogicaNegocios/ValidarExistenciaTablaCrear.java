/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static CapaPruebas.Prueba.errores;

/**
 *
 * @author ediss
 */
public class ValidarExistenciaTablaCrear extends Comando {

    //SINLGETON
    private static ValidarExistenciaTablaCrear instancia = null;

    private ValidarExistenciaTablaCrear(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarExistenciaTablaCrear getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarExistenciaTablaCrear(tipoProces);
        }
        return instancia;
    }
 
    
    
    
    @Override
    public boolean ejecutar() {
        //Aqui se va a validar si ya existe la tabla pero de la sentencia crear tabla
        //CREAR TABLA nombre_tabla CAMPOS campo1, … , campoN CLAVE campo1 LONGITUD 5 
        boolean existe = !super.validarExistenciaTabla(2);
        if(!existe) {
            //System.out.println("Mensaje -> YA existe una tabla con el nombre: '" + tipoProceso.getTokens().get(2)+"'");
            errores += "Mensaje -> YA existe una tabla con el nombre: '" + tipoProceso.getTokens().get(2)+"'"+"\n";
        }
            
        return existe;
    }
}
