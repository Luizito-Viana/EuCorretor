/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 22:01
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.model;

import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;


public class Usuario {
    private String idUsuario;
    private String nome;
    private String email;
    private String senha;


    public Usuario() {
    }

    public void salvar(){
        DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase();
        reference.child("usuarios")
                .child(this.idUsuario)
                .setValue(this);
    }


    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
