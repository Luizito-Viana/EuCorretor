package com.eurezzolve.eucorretor.activities.introducao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_4)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .build()
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void cadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void entrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    //Verifica se o usuario esta logado
    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if(autenticacao.getCurrentUser() != null){
            abrirHomeActivity();
        }
    }

    public void abrirHomeActivity(){
        startActivity(new Intent(this, HomeActivity.class));
    }
}
