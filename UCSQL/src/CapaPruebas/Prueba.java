/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPruebas;

import LogicaNegocios.*;

/**
 *
 * @author ediss
 */
public class Prueba {
    
    public static String errores;
    public static String sentencia;
 
    public boolean Ejecutar(String  sentencia) {
        errores = "";
        //String sentencia=Prueba.sentencia;
        //String sentencia = "CREAR TABLA tabla99 CAMPOS cedula,ruc,apellidos,materia,calificacion CLAVE cedula LONGITUD 30";  
        //String sentencia = "MODIFICAR TABLA estudiantes CAMPO ruc POR cedula";
        //String sentencia = "ELIMINAR TABLA alumnoa    ";  
        //String sentencia="SELECCIONAR DE estudiantes DONDE calificacion = 98/100 ";
        //String sentencia= "UNIR tabla1, tabla3 POR peso";
        //String sentencia = "CREAR REGISTRO estudiantes VALOR 0105874915,Edisson,Sigua,Programacion3,98/100";
        //String sentencia="MODIFICAR REGISTRO estudiantes CLAVE 0105874911 CAMPO ruc POR 0105874910";
        //String sentencia="MODIFICAR REGISTRO alumno CLAVE 106039335 CAMPO edad POR 99";
        //String sentencia = "ELIMINAR REGISTRO estudiantes CLAVE 0105874915";

        //String sentencia = "ELIMINAR TABLA notas_estudiantes";
        //System.out.println(sentencia);
        ManejadorProcesos procesoCrearTabla = ProcesoCrearTablaSingleton.getInstance();

        ManejadorProcesos procesoModificarTabla = ProcesoModificarTablaSingleton.getInstance();
        procesoCrearTabla.ponerSucesor(procesoModificarTabla);

        ManejadorProcesos procesoEliminarTabla = ProcesoEliminarTablaSingleton.getInstance();
        procesoModificarTabla.ponerSucesor(procesoEliminarTabla);

        ManejadorProcesos procesoSeleccionarTabla = ProcesoSeleccionarTablaSingleton.getInstance();
        procesoEliminarTabla.ponerSucesor(procesoSeleccionarTabla);

        ManejadorProcesos procesoUnirTabla = ProcesoUnirTablaSingleton.getInstance();
        procesoSeleccionarTabla.ponerSucesor(procesoUnirTabla);

        ManejadorProcesos procesoCrearRegistro = ProcesoCrearRegistroSingleton.getInstance();
        procesoUnirTabla.ponerSucesor(procesoCrearRegistro);

        ManejadorProcesos procesoModificarRegistro = ProcesoModificarRegistroSingleton.getInstance();
        procesoCrearRegistro.ponerSucesor(procesoModificarRegistro);

        ManejadorProcesos procesoEliminarRegistro = ProcesoEliminarRegistroSingleton.getInstance();
        procesoModificarRegistro.ponerSucesor(procesoEliminarRegistro);
        
        //EL PROCESO ME DEVUELVE TRUEO FALSE DEPENDIENDO SI SE REALIZO O NO
        //SOLO CUANDO ME DEVUELVE FALSE MANDO A IMPRIMIR LOS ERRORES
        if (!procesoCrearTabla.EjecutarProceso(sentencia)){
            System.out.println("ERRORES: \n"+errores);
            sentencia="";
            return false;
            //procesoSeleccionarTabla=null;
        }
        return true;
        //procesoSeleccionarTabla=null;
    }

    
    
}
