package com.eurezzolve.eucorretor.model;

import java.io.Serializable;

/**
 * Created by viana_2 on 25/04/2018.
 */

public class Terceiros implements Serializable {
    private String nome;
    private String dono;
    private String infoAdapter;
    private int imageThumb;
    /* Info Completo não foi implementado, capaz que usaremos um Array de Strings
    private String infoCompleto;*/

    public Terceiros() {
    }

    public Terceiros(String nome, String dono, String infoAdapter, int imageThumb) {
        this.nome = nome;
        this.dono = dono;
        this.infoAdapter = infoAdapter;
        this.imageThumb = imageThumb;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getInfoAdapter() {
        return infoAdapter;
    }

    public void setInfoAdapter(String infoAdapter) {
        this.infoAdapter = infoAdapter;
    }

    public int getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(int imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String padronizarDescricao(){
        String padrao = "";
        padrao = "Descrição do Imóvel: \n";
        return padrao;
    }
}
