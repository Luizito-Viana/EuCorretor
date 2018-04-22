package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eurezzolve.eucorretor.R;

public class SimuladorActivity extends AppCompatActivity {

    private Button buttonBB, buttonCaixa;

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Simulador");

        buttonBB = findViewById(R.id.buttonBB);
        buttonCaixa = findViewById(R.id.buttonCaixa);
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

    //Leva para o Simulador Habitacional do BB
    public void btBBEntrar(View view){
        /*String site = "https://www42.bb.com.br/portalbb/cim/creditoimobiliario/simular,802,2250,2250.bbx";
        Intent simulador = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        getApplicationContext().startActivity(Intent.createChooser(simulador,"Choose browser"));*/

        String site = "https://www42.bb.com.br/portalbb/cim/creditoimobiliario/simular,802,2250,2250.bbx";
        Intent simulador = new Intent(Intent.ACTION_VIEW);
        simulador.setData(Uri.parse(site));
        startActivity(simulador);

    }

    //Leva para o Simulador Habitacional da Caixa
    public void btCaixaEntrar(View view){
        String site = "http://www8.caixa.gov.br/siopiinternet-web/simulaOperacaoInternet.do?method=inicializarCasoUso";
        Intent simulador = new Intent(Intent.ACTION_VIEW);
        simulador.setData(Uri.parse(site));
        startActivity(simulador);
    }
}
