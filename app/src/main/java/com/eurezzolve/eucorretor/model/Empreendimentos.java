package com.eurezzolve.eucorretor.model;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class Empreendimentos {
    private String nome;
    private String construtora;
    private String venda;
    private String simulacao;
    private int imagem;
    private String codigo;
    private int act_flag;
    private String telefone;
    private int modelo;


    public Empreendimentos() {
    }

    public Empreendimentos(String nome, int act_flag ,int modelo){
        this.nome = nome;
        this.modelo = modelo;
        this.act_flag = act_flag;
    }

    public Empreendimentos(String nome, String construtora, String venda, String simulacao, int imagem, String codigo, int act_flag, String telefone, int modelo){
        this.nome = nome;
        this.construtora = construtora;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.telefone = telefone;
        this.modelo = modelo;
    }

    public Empreendimentos(String nome, String construtora, String venda, String simulacao, int imagem, String codigo, int act_flag, int modelo) {
        this.nome = nome;
        this.construtora = construtora;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.modelo = modelo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConstrutora() {
        return construtora;
    }

    public void setConstrutora(String construtora) {
        this.construtora = construtora;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public String getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(String simulacao) {
        this.simulacao = simulacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAct_flag() {
        return act_flag;
    }

    public void setAct_flag(int act_flag) {
        this.act_flag = act_flag;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
}
