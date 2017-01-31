/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;


import static datos.Crear_Tabla.escribirCrearTabla;

/**
 *
 * @author ediss
 */
public class CrearTabla extends Comando {

    
    //SINLGETON
    private static CrearTabla instancia = null;
    
    private CrearTabla(ProccesManager tipoProceso) {   
        super(tipoProceso);
    }
    
    public static CrearTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new CrearTabla(tipoProces);
        }
        return instancia;
    }
    
    
     
    @Override
    public boolean ejecutar() {
        //Aqui se va crear la tabla
        //CREAR TABLA nombre_tabla CAMPOS campo1, … , campoN CLAVE campo1 LONGITUD 5 
        return escribirCrearTabla(tipoProceso.getTokens()); 
    }
}
