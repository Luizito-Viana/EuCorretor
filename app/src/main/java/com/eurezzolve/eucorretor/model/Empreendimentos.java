/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:01
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;

import android.util.Log;

import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;
import java.util.List;

public class Empreendimentos implements Serializable{

    /*Observações: codigoConst, categoriaMetragem, faixa serão removidos*/
    private String codigoConst;
    private String faixa;

    private String codigo;
    private String nome;
    private String construtora;
    private String venda;
    private String simulacao;
    private int imagem;
    private int act_flag;
    private String telefone;
    private String descricaoImovel;
    private String descricaoEmp;
    private String localizacao;
    private Double latitude;
    private Double longitude;
    private List<String> listaImagens;

    public Empreendimentos() {
    }

    public void salvarFaixa(int id) {
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        switch (id){
            case 1:
                firebase.child("listaEmpPorFaixa")
                        .child("faixa1meio")
                        .child(codigo)
                        .setValue(this);
                break;
            case 2:
                firebase.child("listaEmpPorFaixa")
                        .child("faixa2")
                        .child(codigo)
                        .setValue(this);
                break;
            case 3:
                firebase.child("listaEmpPorFaixa")
                        .child("acima")
                        .child(codigo)
                        .setValue(this);
                break;
            case 4:
                firebase.child("listaEmpPorFaixa")
                        .child("indefinido")
                        .child(codigo)
                        .setValue(this);
                break;
        }
    }

    public void salvar(){
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("listaEmp")
                .child(codigo)
                .setValue(this);
    }

    public void salvarAtual(){
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("listaEmpCompleta")
                .child(codigo)
                .setValue(this);

        if(listaImagens.size() > 0){
            Log.d("TAG", "salvarAtual: " + "Salvou");
        } else {
            Log.d("TAG", "salvarAtual: " + "Salvou Errado");
        }

    }

    /*Esse é o COMPLETO */
    public Empreendimentos(String nome, String codigoConst, String venda,
                           String simulacao, int imagem, String codigo, int act_flag,
                           String telefone ,String construtora, String descricaoImovel,
                           String descricaoEmp, String localizacao, String faixa,
                           List<String> listaImagens, Double latitude, Double longitude) {
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
        this.faixa = faixa;
        this.listaImagens = listaImagens;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /*Getters and Setters*/
    public List<String> getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(List<String> listaImagens) {
        this.listaImagens = listaImagens;
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
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

    public String getDescricaoImovel() {
        return descricaoImovel;
    }

    public void setDescricaoImovel(String descricaoImovel) {
        this.descricaoImovel = descricaoImovel;
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

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
