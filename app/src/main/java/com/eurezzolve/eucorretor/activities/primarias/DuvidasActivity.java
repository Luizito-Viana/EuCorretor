package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.secundarias.DuvidasDocumentacaoActivity;
import com.eurezzolve.eucorretor.activities.secundarias.DuvidasFinanciamentoActivity;
import com.eurezzolve.eucorretor.activities.secundarias.DuvidasSimulacaoActivity;

public class DuvidasActivity extends AppCompatActivity {

    private Button buttonDoc, buttonFin, buttonSim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas");

        buttonDoc = findViewById(R.id.buttonDoc);
        buttonFin = findViewById(R.id.buttonFin);
        buttonSim = findViewById(R.id.buttonSim);
    }

    //Volta para a activity anterior
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

    //Abre a activity de Duvidas de financiamento
    public void abrirDuvidasFinaciamento(View view){
        startActivity(new Intent(this, DuvidasFinanciamentoActivity.class));

    }

    //Abre a activity de Duvidas de Documentacao
    public void abrirDuvidasDocumentacao(View view){
        startActivity(new Intent(this, DuvidasDocumentacaoActivity.class));

    }

    //Abre a activity de Duvidas de Simulacao
    public void abrirDuvidasSimulacao(View view){

        startActivity(new Intent(this, DuvidasSimulacaoActivity.class));

    }

}
