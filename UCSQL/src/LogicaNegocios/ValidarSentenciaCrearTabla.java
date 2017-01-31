/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import java.util.ArrayList;
import static CapaPruebas.Prueba.errores;

/**
 *
 * @author ediss
 */
public class ValidarSentenciaCrearTabla extends Comando {

    //SINLGETON
    private static ValidarSentenciaCrearTabla instancia = null;

    private ValidarSentenciaCrearTabla(ProccesManager tipoProceso) {
        super(tipoProceso);
    }

    public static ValidarSentenciaCrearTabla getInstance(ProccesManager tipoProces) {
        if (instancia == null) {
            instancia = new ValidarSentenciaCrearTabla(tipoProces);
        }
        return instancia;
    }

    @Override
    public boolean ejecutar() {
        ArrayList<String> tokens = tipoProceso.getTokens();
        ArrayList<String> listaCampos = new ArrayList<>();
        //Aqui se va a validar la sentencia crear una tabla
        //CREAR TABLA nombre_tabla CAMPOS campo1, … , campoN CLAVE campo1 LONGITUD 5 
        int aux = 0;
        if (tokens.size() == 9) {
            if ("CAMPOS".equals(tokens.get(3))) {
                String campos[] = tokens.get(4).split(",");
                for (int j = 0; j < campos.length; j++) {
                    if (!listaCampos.contains(campos[j])) {
                        listaCampos.add(campos[j]);
                    }
                }
                if (listaCampos.size() == campos.length) {
                    if ("CLAVE".equals(tokens.get(5))) {
                        for (int i = 0; i < campos.length; i++) {
                            if (campos[i].equals(tokens.get(6))) {
                                aux = 1;
                            }
                        }
                        if (aux == 1) {
                            if ("LONGITUD".equals(tokens.get(7))) {
                                if (isNumeric(tokens.get(8))) {
                                    return true;
                                } else {
                                    //System.out.println("Error -> Expected numeric date >0 && <256 - but Founded: " + tokens.get(8));
                                    errores += "Error -> Expected numeric date >0 && <256 - but Founded: " + tokens.get(8)+"\n";
                                    return false;
                                }
                            } else {
                                //System.out.println("Error -> Expected: LONGITUD - but Founded: " + tokens.get(7));
                                errores += "Error -> Expected: LONGITUD - but Founded: " + tokens.get(7)+"\n";
                                return false;
                            }
                        } else {
                            //System.out.println("Error -> Expected: " + tokens.get(6) + " in " + tokens.get(4));
                            errores += "Error -> Expected: " + tokens.get(6) + " in " + tokens.get(4)+"\n";
                            return false;
                        }
                    } else {
                        //System.out.println("Error -> Expected: CLAVE - but Founded: " + tokens.get(5));
                        errores += "Error -> Expected: CLAVE - but Founded: " + tokens.get(5)+"\n";
                        return false;
                    }
                } else {
                    //System.out.println("Error no se puede crear tabla con campos repetidos!");
                    errores += "Error no se puede crear tabla con campos repetidos!"+"\n";
                    return false;
                }
            } else {
                //System.out.println("Error -> Expected: CAMPOS - but Founded: " + tokens.get(3));
                errores += "Error -> Expected: CAMPOS - but Founded: " + tokens.get(3)+"\n";
                return false;
            }
        }
        //System.out.println("Error falta o hay un exceso de argumentos!!");
        errores += "Error falta o hay un exceso de argumentos!!"+"\n";
        return false;
    }

    private static boolean isNumeric(String cadena) {
        int num;
        try {
            num = Integer.parseInt(cadena);
            return num > 0 && num < 256;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
