/*
 * Desenvolvido por Luiz F. Viana em 29/08/18 18:29
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;

import java.util.List;

public class ImagensEmp {
    private String codigo;
    private String construtora;
    private List<String> urlImagens;

    public ImagensEmp() {
    }

    public ImagensEmp(String codigo, String construtora, List<String> urlImagens) {
        this.codigo = codigo;
        this.construtora = construtora;
        this.urlImagens = urlImagens;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConstrutora() {
        return construtora;
    }

    public void setConstrutora(String construtora) {
        this.construtora = construtora;
    }

    public List<String> getUrlImagens() {
        return urlImagens;
    }

    public void setUrlImagens(List<String> urlImagens) {
        this.urlImagens = urlImagens;
    }
}
