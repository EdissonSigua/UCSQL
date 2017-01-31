/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import static datos.Obtener_Tablas.obtener_nombres_tablas;
import datos.Seleccionar_Tabla;
import datos.Unir_Tabla;

/**
 *
 * @author Mateo
 */
public class ObtenerInformacion {
    public static String[] NombresTablas() {
        return obtener_nombres_tablas();
    }
    public static String obtenerSeleccionar(){
        return Seleccionar_Tabla.seleccionar;
    }
    public static String obtenerUnir(){
        return Unir_Tabla.unir;
    }
}
