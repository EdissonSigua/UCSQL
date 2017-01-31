/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocios;

import static datos.Crear_Registro.escribirCrearRegistro;

/**
 *
 * @author ediss
 */
public class CrearRegistro extends Comando {

    //SINLGETON
    private static CrearRegistro instancia = null;
    
    private CrearRegistro(ProccesManager tipoProceso) {
        super(tipoProceso);
    }
    
    public static CrearRegistro getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new CrearRegistro(tipoProces);
        }
        return instancia;
    }
    
    

    @Override
    public boolean ejecutar() {
        //Aqui se va a realizar el proceso de crear un registro
        //CREAR REGISTRO nombre_tabla VALOR vCampo1 , vCampo2 ,... , vCampoN
        return escribirCrearRegistro(tipoProceso.getTokens());
    }

}
