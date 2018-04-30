package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 29/04/2018.
 */

public class Valores {
    String andar;
    String avaliacao;
    String venda;

    public Valores(String andar, String avaliacao, String venda) {
        this.andar = andar;
        this.avaliacao = avaliacao;
        this.venda = venda;
    }

    public Valores() {
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }
}
