package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class Documentacao {
    private String pergunta;
    private String resposta;

    public Documentacao(){

    }

    public Documentacao(String pergunta, String resposta) {
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

    public String padronizarPergunta(){
        String text = "<html><body>" + "<p align=\"justify\">" + pergunta + "</p> " + "</body></html>";
        return text;
    }

    public String padronizarResposta(){
        String text = "<html><body>" + "<p align=\"justify\">" + resposta + "</p> " + "</body></html>";
        return text;
    }
}
