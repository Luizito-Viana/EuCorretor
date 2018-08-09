/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:51
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.eurezzolve.eucorretor.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0.0");

        Element equipe = new Element();
        equipe.setTitle("Fundador: EuRezzolve");

        String descricao = "Esse aplicativo tem como objetivo, auxiliar o Corretor na sua jornada!\n Tudo que você como Corretor precisa, e na palma da mão! ";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.ic_logotipo_)
                .setDescription(descricao)
                .addGroup("Fale Conosco")
                .addEmail("eurezzolve@gmail.com", "Email")
                //.addFacebook("luiz.goncalvesviana","Facebook")
                .addInstagram("eurezzolve","Instagram")
                .addGroup("Informações Gerais")
                .addItem(equipe)
                .addItem(versionElement)
                .create();
        setContentView(sobre);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Sobre");
    }

    //Volta para a anterior fechando a atual
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
