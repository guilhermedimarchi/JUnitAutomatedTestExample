/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.value.projects.service;

import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Participante;
import br.com.value.projects.dominio.Resultado;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author Guilherme
 */
public class Julgamento {

    @Test
    public void Teste() {
        Participante joao = new Participante("João");
        Participante pedro = new Participante("Pedro");
        Participante katia = new Participante("Katia");
        Participante maria = new Participante("Maria");

        Jogo jogo = new Jogo("Derruba barreiras");
        jogo.anota(new Resultado(joao, 90.0));
        jogo.anota(new Resultado(pedro, 91.0));
        jogo.anota(new Resultado(katia, 93.0));
        jogo.anota(new Resultado(maria, 94.0));

        Juiz juiz = new Juiz();
        juiz.julga(jogo);
        double vencedorJogo = 94;
        double ultimoColocadoJogo = 90;

        Assert.assertEquals(vencedorJogo, juiz.getPrimeiroColocado(), 0.00001);
        Assert.assertEquals(ultimoColocadoJogo, juiz.getUltimoColocado(), 0.00001);

    }

    @Test
    public void naoDeveAceitarDoisResultadosDoMesmoParticipante() {
        Jogo jogo = new Jogo("Caça Peças");
        Participante leonardo = new Participante("Leonardo");

        jogo.anota(new Resultado(leonardo, 500.0));
        //Deve ser ignorado
        jogo.anota(new Resultado(leonardo, 600.0));

        Assert.assertEquals(1, jogo.getResultados().size());
        Assert.assertEquals(500.0, jogo.getResultados().get(0).getMetrica(), 0.00001);

    }

    @Test
    public void deveIdentificarTodasColocacoesComecandoPeloVencedor() {
        Jogo jogo = new Jogo("Caça Peças");
        
        Participante leonardo = new Participante("Leonardo");
        Participante daniel = new Participante("Daniel");
        Participante alex = new Participante("Alex");
        Participante guilherme = new Participante("Guilherme");

        jogo.anota(new Resultado(leonardo, 500.0));
        jogo.anota(new Resultado(alex, 400.0));
        jogo.anota(new Resultado(daniel, 550.0));
        jogo.anota(new Resultado(guilherme, 509.0));

        Assert.assertEquals(4, jogo.getResultados().size());
        Assert.assertEquals(550.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
        Assert.assertEquals(509.0, jogo.getResultados().get(1).getMetrica(), 0.00001);
        Assert.assertEquals(500.0, jogo.getResultados().get(2).getMetrica(), 0.00001);
        Assert.assertEquals(400.0, jogo.getResultados().get(3).getMetrica(), 0.00001);

    }

}
