package com.eurezzolve.eucorretor.model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by viana_2 on 25/04/2018.
 */

public class Terceiros implements Serializable {
    private String nome;
    private String dono;
    private String infoAdapter;
    private int imageThumb;
    private String bairro;
    private String metragem;
    private int vagasGaragem;
    private int quartos;
    private int suites;
    private int banheiros;
    /* Info Completo não foi implementado, capaz que usaremos um Array de Strings
    private String infoCompleto;*/

    public Terceiros() {
    }

    public Terceiros(String nome, String dono, String infoAdapter, int imageThumb, String bairro, String metragem, int vagasGaragem, int quartos, int suites, int banheiros) {
        this.nome = nome;
        this.dono = dono;
        this.infoAdapter = infoAdapter;
        this.imageThumb = imageThumb;
        this.bairro = bairro;
        this.metragem = metragem;
        this.vagasGaragem = vagasGaragem;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.suites = suites;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMetragem() {
        return metragem;
    }

    public void setMetragem(String metragem) {
        this.metragem = metragem;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public String padronizarDescricaoTerceiros(){
        String y = "";
        if(suites == 0){
            y = "Sem suíte";
        } else if (suites == 1){
            y = "1 suíte";
        } else {
            y = String.valueOf(suites) + " suítes";
        }
        String padrao = "";
        padrao = "Descrição: \nImóvel localizado no bairro " + bairro + ", um ótimo lugar para residir, com segurança e variados comércios na região.\n" +
                " > " + metragem + " metros quadrados\n" +
                " > " + String.valueOf(quartos) +  " Quartos (" + y + ")\n" +
                " > " + String.valueOf(banheiros) + " Banheiros\n" +
                " > " + String.valueOf(vagasGaragem) + " Vagas na Garagem\n" +
                " > Entre outros...";
        return padrao;
    }
}
