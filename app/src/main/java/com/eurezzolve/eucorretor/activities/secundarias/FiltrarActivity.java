package com.eurezzolve.eucorretor.activities.secundarias;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;

import java.util.ArrayList;
import java.util.List;

public class FiltrarActivity extends AppCompatActivity {

    private List<String> listaConstrutoras = new ArrayList<>();
    private List<String> listaMetragens = new ArrayList<>();
    private List<String> listaFaixas = new ArrayList<>();

    private Button btFiltrar;

    private String[] construtoras = new String[]{"Todas as construtoras", "AZM", "Cima","Conel","Vivamus"};
    private String[] metragens = new String[]{"Todas as metragens", "< 45m²", "de 45m² até 60m²", "de 60m² até 90m²", "> 90m²"};
    private String[] faixas = new String[]{"Todas", "Faixa 1,5", "Faixa 2", "Acima da Faixa 2"};

    private String constEscolhida;
    private String metrageEscolhida;
    private String faixaEscolhida;

    private Spinner spinnerCons, spinnerMetragem, spinnerFaixa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Filtrar");

        criarListas();


        ArrayAdapter<String> adapterConst = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaConstrutoras);
        adapterConst.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterFaixa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaFaixas);
        adapterFaixa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMetragem = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaMetragens);
        adapterMetragem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCons = findViewById(R.id.spinnerCons);
        spinnerFaixa = findViewById(R.id.spinnerFaixa);
        spinnerMetragem = findViewById(R.id.spinnerMetragem);
        btFiltrar = findViewById(R.id.btFiltrar);

        /*Setando todos os adapters*/
        spinnerCons.setAdapter(adapterConst);
        spinnerFaixa.setAdapter(adapterFaixa);
        spinnerMetragem.setAdapter(adapterMetragem);

        constEscolhida = listaConstrutoras.get(0);
        metrageEscolhida = listaMetragens.get(0);
        constEscolhida = listaConstrutoras.get(0);

        spinnerCons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                constEscolhida = listaConstrutoras.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerFaixa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                faixaEscolhida = listaFaixas.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerMetragem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                metrageEscolhida = listaMetragens.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FiltrarActivity.this, "Escolhido: " + constEscolhida + " " + metrageEscolhida + " " + faixaEscolhida + "!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void criarListas() {
        listaConstrutoras.add("Todas as construtoras");
        listaConstrutoras.add("AZM");
        listaConstrutoras.add("Cima");
        listaConstrutoras.add("CONEL");
        listaConstrutoras.add("Vivamus");

        listaFaixas.add("Todas");
        listaFaixas.add("Faixa 1,5");
        listaFaixas.add("Faixa 2");
        listaFaixas.add("Acima da Faixa 2");

        listaMetragens.add("Todas as metragens");
        listaMetragens.add("< 45m²");
        listaMetragens.add("de 45m² até 60m²");
        listaMetragens.add("de 60m² até 90m²");
        listaMetragens.add("> 90m²");
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
