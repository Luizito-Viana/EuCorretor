/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:39
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.introducao;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity {

    private Button btResetar;
    private TextInputEditText recuperarEmail;
    private TextInputLayout textEmailLayout;
    private FirebaseAuth firebaseAuth;

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Reset Password");

        btResetar = findViewById(R.id.btResetar);
        recuperarEmail = findViewById(R.id.recuperarSenha);
        textEmailLayout = findViewById(R.id.textInputEmail);

        //btResetar = findViewById(R.id.btResetar);
        //recuperarEmail = findViewById(R.id.recuperarSenha);

        firebaseAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
    }

    //Volta para a activity anterior finalizando a atual
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    //Envia o email de recuperar senha
    public void enviarReset (View view) {
        if(recuperarEmail.getText().toString().isEmpty()){
            textEmailLayout.setErrorEnabled(true);
            textEmailLayout.setError("Preencha o Email");
        } else {
            textEmailLayout.setErrorEnabled(false);
            firebaseAuth.sendPasswordResetEmail(recuperarEmail.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetActivity.this,"Email enviado!", Toast.LENGTH_LONG).show();
                                finish();

                            } else {
                                Toast.makeText(ResetActivity.this,"Houve falhas. Tente Novamente!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }
                    });
        }

    }

}
