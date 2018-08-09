/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:01
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;



public class Legenda {
    int imagemLegenda;
    String textLegenda;

    public Legenda() {
    }

    public Legenda(int imagemLegenda, String textLegenda) {
        this.imagemLegenda = imagemLegenda;
        this.textLegenda = textLegenda;
    }

    public int getImagemLegenda() {
        return imagemLegenda;
    }

    public void setImagemLegenda(int imagemLegenda) {
        this.imagemLegenda = imagemLegenda;
    }

    public String getTextLegenda() {
        return textLegenda;
    }

    public void setTextLegenda(String textLegenda) {
        this.textLegenda = textLegenda;
    }
}
