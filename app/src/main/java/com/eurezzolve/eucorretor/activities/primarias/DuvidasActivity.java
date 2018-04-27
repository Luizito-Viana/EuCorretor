package com.eurezzolve.eucorretor.activities.primarias;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        Toolbar toolbar = findViewById(R.id.toolbarDuvidas);
        toolbar.setTitle("Dúvidas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        buttonDoc = findViewById(R.id.buttonDoc);
        buttonFin = findViewById(R.id.buttonFin);
        buttonSim = findViewById(R.id.buttonSim);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_duvidas, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            case R.id.menu_duv_novaPergunta:
                alertaDeConfirmacao();
            default:
                break;
        }
        return true;
    }

    private void alertaDeConfirmacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enviar dúvida");
        builder.setMessage("Deseja enviar uma dúvida?");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DuvidasActivity.this, "Escolheu Confirmar", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DuvidasActivity.this, "Escolheu Cancelar", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
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
