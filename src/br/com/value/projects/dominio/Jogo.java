package br.com.value.projects.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jogo {

    private String descricao;
    private List<Resultado> resultados;

    public Jogo(String descricao) {
        this.descricao = descricao;
        this.resultados = new ArrayList<Resultado>();
    }

    public void anota(Resultado resultado) {
        if (resultados.isEmpty()
                || !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
            resultados.add(resultado);

        }

    }

    private int ultimoResultadoVisto() {
        return resultados.size() - 1;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Resultado> getResultados() {
        Collections.sort(resultados, new Comparator<Resultado>() {
            @Override
            public int compare(Resultado result1, Resultado result2) {
                if (result1.getMetrica() > result2.getMetrica()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return Collections.unmodifiableList(resultados);
    }

}
