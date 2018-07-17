package com.eurezzolve.eucorretor.model;

import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class Empreendimentos implements Serializable{

    private String nome;
    private String construtora;
    private String venda;
    private String simulacao;
    private int imagem;
    private String codigo;
    private int act_flag;
    private String telefone;
    private String codigoConst;
    private String descricaoImovel;
    private String descricaoEmp;
    private String localizacao;
    private int categoriaMetragem;
    private String faixa;




    public Empreendimentos() {
    }

    public void salvar(){
        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("listaEmpreendimentos")
                .child(codigo)
                .setValue(this);
    }

    public Empreendimentos(String nome, int act_flag){
        this.nome = nome;
        this.act_flag = act_flag;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag, String telefone, String construtora){
        this.nome = nome;
        this.codigoConst = codigoConst;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.telefone = telefone;
        this.construtora = construtora;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag, String telefone,  String construtora, String descricaoImovel, String descricaoEmp){
        this.nome = nome;
        this.codigoConst = codigoConst;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.telefone = telefone;
        this.construtora = construtora;
        this.descricaoImovel = descricaoImovel;
        this.descricaoEmp = descricaoEmp;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, String construtora, int act_flag, String descricaoImovel, String localizacao){
        this.nome = nome;
        this.codigoConst = codigoConst;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.telefone = telefone;
        this.construtora = construtora;
        this.descricaoImovel = descricaoImovel;
        this.localizacao = localizacao;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag, String construtora) {
        this.nome = nome;
        this.codigoConst = codigoConst;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.construtora = construtora;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag, String construtora, String descricaoImovel, String localizacao, int categoriaMetragem, String faixa) {
        this.nome = nome;
        this.construtora = construtora;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        //this.telefone = telefone;
        this.codigoConst = codigoConst;
        this.descricaoImovel = descricaoImovel;
        this.localizacao = localizacao;
        this.categoriaMetragem = categoriaMetragem;
        this.faixa = faixa;
    }

    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag, String construtora, String descricaoImovel, String descricaoEmp, String localizacao, int categoriaMetragem, String faixa) {
        this.nome = nome;
        this.construtora = construtora;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        //this.telefone = telefone;
        this.codigoConst = codigoConst;
        this.descricaoImovel = descricaoImovel;
        this.descricaoEmp = descricaoEmp;
        this.localizacao = localizacao;
        this.categoriaMetragem = categoriaMetragem;
        this.faixa = faixa;
    }

    /*Esse é o COMPLETO com telefone, ao final, adicionar o telefone AQUI*/
    public Empreendimentos(String nome, String codigoConst, String venda, String simulacao, int imagem, String codigo, int act_flag,String telefone ,String construtora, String descricaoImovel, String descricaoEmp, String localizacao, int categoriaMetragem, String faixa) {
        this.nome = nome;
        this.construtora = construtora;
        this.venda = venda;
        this.simulacao = simulacao;
        this.imagem = imagem;
        this.codigo = codigo;
        this.act_flag = act_flag;
        this.telefone = telefone;
        this.codigoConst = codigoConst;
        this.descricaoImovel = descricaoImovel;
        this.descricaoEmp = descricaoEmp;
        this.localizacao = localizacao;
        this.categoriaMetragem = categoriaMetragem;
        this.faixa = faixa;
    }

    public String getDescricaoEmp() {
        return descricaoEmp;
    }

    public void setDescricaoEmp(String descricaoEmp) {
        this.descricaoEmp = descricaoEmp;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricaoImovel() {
        return descricaoImovel;
    }

    public void setDescricaoImovel(String descricaoImovel) {
        this.descricaoImovel = descricaoImovel;
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


    public String getCodigoConst() {
        return codigoConst;
    }

    public void setCodigoConst(String codigoConst) {
        this.codigoConst = codigoConst;
    }

}
