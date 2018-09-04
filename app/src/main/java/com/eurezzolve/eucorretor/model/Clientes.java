/*
 * Desenvolvido por Luiz F. Viana em 19/08/18 22:43
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;


import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.eurezzolve.eucorretor.activities.secundarias.DetalheClienteActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class Clientes implements Serializable{
    private String codigoCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String interesseCliente;
    private int modeloCliente;
    private String casadoCliente;
    private String filhoMenorIdade;
    private String carteiraAssinada;


    public void salvar(){
        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();

        firebase.child("clientes")
                .child(idUsuario)
                .child(codigoCliente)
                .setValue(this);
    }

    public boolean remover(){
        if(!getCodigoCliente().equals("")){
            FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
            DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
            firebase.child("clientes")
                    .child(idUsuario)
                    .child(getCodigoCliente());

            firebase.removeValue();
            return true;
        } else {
            return false;
        }
    }

    public Clientes() {
    }

    public Clientes(String codigoCliente, String nomeCliente, String telefoneCliente, String interesseCliente, int modeloCliente, String casadoCliente, String filhoMenorIdade, String carteiraAssinada) {
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.interesseCliente = interesseCliente;
        this.modeloCliente = modeloCliente;
        this.casadoCliente = casadoCliente;
        this.filhoMenorIdade = filhoMenorIdade;
        this.carteiraAssinada = carteiraAssinada;
    }

    public String getCasadoCliente() {
        return casadoCliente;
    }

    public void setCasadoCliente(String casadoCliente) {
        this.casadoCliente = casadoCliente;
    }

    public String getFilhoMenorIdade() {
        return filhoMenorIdade;
    }

    public void setFilhoMenorIdade(String filhoMenorIdade) {
        this.filhoMenorIdade = filhoMenorIdade;
    }

    public String getCarteiraAssinada() {
        return carteiraAssinada;
    }

    public void setCarteiraAssinada(String carteiraAssinada) {
        this.carteiraAssinada = carteiraAssinada;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getInteresseCliente() {
        return interesseCliente;
    }

    public void setInteresseCliente(String interesseCliente) {
        this.interesseCliente = interesseCliente;
    }

    public int getModeloCliente() {
        return modeloCliente;
    }

    public void setModeloCliente(int modeloCliente) {
        this.modeloCliente = modeloCliente;
    }
}
