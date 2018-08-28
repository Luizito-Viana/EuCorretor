/*
 * Desenvolvido por Luiz F. Viana em 21/08/18 21:15
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.helper;

import android.util.Log;

import com.bumptech.glide.load.resource.transcode.BitmapToGlideDrawableTranscoder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class GeradorChaveAleatoria {
    public static String geraAleatoria(String codigo){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        String armazena = "_";
        Random random = new Random();
        int index = -1;
        for( int i = 0; i < 3; i++ ) {
            index = random.nextInt( letras.length() );
            armazena += letras.substring( index, index+1);
        }

        return codigo + armazena;
    }
}
