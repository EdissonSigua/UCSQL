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
public class CommandManager {

    private Comando comando;

    public void setCommand(Comando command) {
        this.comando = command;
    }

    public boolean EjecutarProceso() {
        return comando.ejecutar();
    }
}
