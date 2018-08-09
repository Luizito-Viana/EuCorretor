/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:56
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Indicacoes;

public class CadastroImoveisActivity extends AppCompatActivity {

    private EditText editNomeProp, editTelProp;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imoveis);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Imóveis");

        /*ACHANDO NO LAYOUT */
        editTelProp = findViewById(R.id.editTelefoneProp);
        editNomeProp = findViewById(R.id.editNomeProp);
        btEnviar = findViewById(R.id.btEnviarIndicacao);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarIndicacao();
            }
        });
    }

    public void enviarIndicacao(){
        String nomeProp = editNomeProp.getText().toString();
        String telprop = editTelProp.getText().toString();
        Indicacoes indicacoes = new Indicacoes(nomeProp, telprop, 0);
        indicacoes.salvarIndicacoes();
        Toast.makeText(CadastroImoveisActivity.this, "Mensagem enviada! Agradecemos o contato.", Toast.LENGTH_SHORT).show();
        finish();
    }

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
}
