package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 25/06/2018.
 */

public class PerguntasRespostas {
    private String pergunta;
    private String resposta;

    public PerguntasRespostas(){

    }

    public PerguntasRespostas(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
