/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:55
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterLegenda;
import com.eurezzolve.eucorretor.model.Legenda;

import java.util.ArrayList;
import java.util.List;

public class LegendaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Legenda> listaLegenda = new ArrayList<>();

    //On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legenda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Legenda");

        recyclerView = findViewById(R.id.recyclerLegenda);

        //Configura Listagem
        this.criarLegendas();

        //Configura Adapter
        AdapterLegenda adapterLegenda = new AdapterLegenda(listaLegenda);

        //Configura o Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterLegenda);
    }

    private void criarLegendas() {
        Legenda legenda = new Legenda(R.drawable.ic_mapa_buscafiltrada, "Resultado de buscas");
        listaLegenda.add(legenda);

        legenda = new Legenda(R.drawable.ic_mapa_empreendimentos,"Empreendimentos");
        listaLegenda.add(legenda);

        legenda = new Legenda(R.drawable.ic_mapa_imobiliaria,"Imobiliária");
        listaLegenda.add(legenda);

        legenda = new Legenda(R.drawable.ic_mapa_terceiros,"Terceiros");
        listaLegenda.add(legenda);

        legenda = new Legenda(R.drawable.ic_mapa_terrenos,"Terrenos");
        listaLegenda.add(legenda);

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
}
