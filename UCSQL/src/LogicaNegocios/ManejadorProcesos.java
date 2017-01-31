/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

/**
 *
 * @author ediss
 */
public interface ManejadorProcesos {
    public void ponerSucesor (ManejadorProcesos sucesor);
    public ManejadorProcesos getSucesor();
    public boolean EjecutarProceso(String sentencia);
}
