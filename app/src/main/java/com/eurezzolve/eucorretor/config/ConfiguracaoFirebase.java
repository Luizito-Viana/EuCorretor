/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:59
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class ConfiguracaoFirebase {
    private static FirebaseAuth autenticacao;
    private static StorageReference storage;
    private static DatabaseReference reference;

    //retornar a isntancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

    //retorna a instancia do FirebaseDatabase
    public static DatabaseReference getFirebaseDatabase(){
        if(reference == null){
            reference = FirebaseDatabase.getInstance().getReference();
        }
        return reference;
    }

    //retorna a instancia do storage
    public static StorageReference getFirebaseStorage(){
        if(storage == null){
            storage = FirebaseStorage.getInstance().getReference();
        }
        return storage;
    }

    //Adiciona os usuarios
    public void getMessagingPatterns(){
        FirebaseMessaging.getInstance().subscribeToTopic("alertas");
        FirebaseMessaging.getInstance().subscribeToTopic("tabelas");
        FirebaseMessaging.getInstance().subscribeToTopic("emp");
    }
}
