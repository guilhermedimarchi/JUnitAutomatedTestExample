/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Resultado;

/**
 *
 * @author Guilherme
 */
class Juiz {

    private double maisPontos = Double.NEGATIVE_INFINITY;
    private double menosPontos = Double.POSITIVE_INFINITY;
    
    void julga(Jogo jogo) {
        for (Resultado resultado : jogo.getResultados()) {
            if (resultado.getMetrica() > maisPontos) {
                maisPontos = resultado.getMetrica();
            }
            if (resultado.getMetrica() < menosPontos) {
                menosPontos = resultado.getMetrica();
            }
        }
    }

     
    public double getPrimeiroColocado() {
        return maisPontos;
    }

    public double getUltimoColocado() {
        return menosPontos;
    }

}
