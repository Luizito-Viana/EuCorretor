/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:01
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;

import java.io.Serializable;


public class Terrenos implements Serializable {
    private String nomeTerrenos;
    private String donoTerreno;
    private String infoAdapter;
    private int imageTerreno;

    public Terrenos() {
    }

    public Terrenos(String nomeTerrenos, String donoTerreno, String infoAdapter, int imageTerreno) {
        this.nomeTerrenos = nomeTerrenos;
        this.donoTerreno = donoTerreno;
        this.infoAdapter = infoAdapter;
        this.imageTerreno = imageTerreno;
    }

    public String getNomeTerrenos() {
        return nomeTerrenos;
    }

    public void setNomeTerrenos(String nomeTerrenos) {
        this.nomeTerrenos = nomeTerrenos;
    }

    public String getDonoTerreno() {
        return donoTerreno;
    }

    public void setDonoTerreno(String donoTerreno) {
        this.donoTerreno = donoTerreno;
    }

    public String getInfoAdapter() {
        return infoAdapter;
    }

    public void setInfoAdapter(String infoAdapter) {
        this.infoAdapter = infoAdapter;
    }

    public int getImageTerreno() {
        return imageTerreno;
    }

    public void setImageTerreno(int imageTerreno) {
        this.imageTerreno = imageTerreno;
    }
}
