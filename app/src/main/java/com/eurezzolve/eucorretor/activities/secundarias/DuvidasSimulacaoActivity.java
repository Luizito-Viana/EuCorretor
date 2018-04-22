package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterSimulacao;
import com.eurezzolve.eucorretor.model.Simulacao;

import java.util.ArrayList;
import java.util.List;

public class DuvidasSimulacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Simulacao> listaSimulacao = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_simulacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas Simulação");

        recyclerView = findViewById(R.id.recyclerSimulacao);

        //Configurar Listagem
        this.criarSimulacao();

        //Configurar Adapter
        AdapterSimulacao adapterSimulacao = new AdapterSimulacao(listaSimulacao);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterSimulacao);
    }

    //Volta para a anterior fehcando a atual
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

    //Cria a lista de documentacao
    public void criarSimulacao(){
        Simulacao simulacao = new Simulacao("Qual o valor deverá ser usado?",
                "Sempre o valor de avaliação do imóvel!");
        listaSimulacao.add(simulacao);

        simulacao = new Simulacao("Qual o valor da entrada?",
                "O valor da entrada é igual ao valor de compra e venda subtraído ao valor do financiamento e o subsídio.\n" +
                        "Entrada = Venda - (Financiamento + Subsídio).");
        listaSimulacao.add(simulacao);

        simulacao = new Simulacao("Qual data de nascimento deverá ser inserida?",
                "Sempre a data de nascimento do mais velho!");
        listaSimulacao.add(simulacao);

    }
}
