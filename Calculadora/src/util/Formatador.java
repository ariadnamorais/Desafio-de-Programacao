/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ariadna Morais
 */
public class Formatador {

    public double converterVirgulaParaPonto(String pValor) {

        String retorno = "";

        for (int i = 0; i < pValor.length(); i++) {
            if (pValor.charAt(i) == ',') {
                retorno += '.';

            } else {
                retorno += pValor.charAt(i);
            }
        }

        return Double.parseDouble(retorno);
    }

}
