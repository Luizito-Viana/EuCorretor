package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 17/04/2018.
 */

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
