package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.secundarias.DescricaoTerceirosActivity;
import com.eurezzolve.eucorretor.adapter.AdapterTerceiros;
import com.eurezzolve.eucorretor.model.Terceiros;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class TerceirosActivity extends AppCompatActivity {

    private RecyclerView recyclerTerceiros;
    private List<Terceiros> listaTerceiros = new ArrayList<>();
    private List<Terceiros> listaTerceirosBusca;
    private AdapterTerceiros adapterTerceiros;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceiros);
        Toolbar toolbar = findViewById(R.id.toolbarTabela);
        toolbar.setTitle("Terceiros");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerTerceiros = findViewById(R.id.recyclerViewTerceiros);

        //Cria a lista
        this.criarTerceiros();

        //Define o Adapter
        adapterTerceiros = new AdapterTerceiros(listaTerceiros, tbOnClickListener() ,descOnClickListener(),0);

        //Cria e configura o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerTerceiros.setLayoutManager(layoutManager);
        recyclerTerceiros.setHasFixedSize(true);
        recyclerTerceiros.setAdapter(adapterTerceiros);

        //Configurando o searchview
        searchView = findViewById(R.id.materialSearchTabelas);
        searchView.setHint("Buscar Terceiros");

        //Listener para o searchview
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                recarregarTerceiros();
            }
        });

        //Listener para caixa de texto
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    pesquisarTerceiros(newText);
                }
                return true;
            }
        });

    }

    /*Funcao pesquisar terceiros*/
    public void pesquisarTerceiros(String texto){
        listaTerceirosBusca = new ArrayList<>();
        for(Terceiros terceiros : listaTerceiros){
            String nomeTerceiro = terceiros.getNome().toLowerCase();
            if(nomeTerceiro.contains(texto)){
                listaTerceirosBusca.add(terceiros);
            }
        }
        adapterTerceiros = new AdapterTerceiros(listaTerceirosBusca, tbOnClickListener(), descOnClickListener(),1);
        recyclerTerceiros.setAdapter(adapterTerceiros);
        adapterTerceiros.notifyDataSetChanged();
    }

    public void recarregarTerceiros() {
        adapterTerceiros = new AdapterTerceiros(listaTerceiros, tbOnClickListener(), descOnClickListener(),0);
        recyclerTerceiros.setAdapter(adapterTerceiros);
        adapterTerceiros.notifyDataSetChanged();
    }

    //Cria os terceiros
    public void criarTerceiros(){
        Terceiros terceiros = new Terceiros("Imóvel do Luiz",
                "Luiz Viana",
                "4 Quartos\n3 Banheiros",
                R.drawable.casa_imovel,
                "Cidade Jardim",
                250.00,
                2, 4, 1, 3);
        listaTerceiros.add(terceiros);
    }

    /*Métodos de Cliquues no Tabela e Descrição*/
    protected AdapterTerceiros.DescricaoTerceirosOnClickListener descOnClickListener(){
        return new AdapterTerceiros.DescricaoTerceirosOnClickListener() {
            @Override
            public void descTerceirosOnClick(AdapterTerceiros.TerceirosHolder holder, int position, int flagLista) {
                if(flagLista == 0){
                    Terceiros terceiros = listaTerceiros.get(position);
                    Intent i = new Intent(TerceirosActivity.this, DescricaoTerceirosActivity.class);
                    i.putExtra("info", terceiros);
                    startActivity(i);
                } else {
                    Terceiros terceiros = listaTerceirosBusca.get(position);
                    Intent j = new Intent(TerceirosActivity.this, DescricaoTerceirosActivity.class);
                    j.putExtra("info", terceiros);
                    startActivity(j);
                }
            }
        };
    }

    protected AdapterTerceiros.TabelasTerceirosOnClickListener tbOnClickListener(){
        return new AdapterTerceiros.TabelasTerceirosOnClickListener() {
            @Override
            public void tbTerceirosOnClick(AdapterTerceiros.TerceirosHolder holder, int position, int flagLista) {
                Terceiros terceiros = listaTerceiros.get(position);
                Toast.makeText(TerceirosActivity.this, "Tabelas: " + terceiros.getNome(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tabelas, menu);

        //Configurar botao de pesquisa
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return super.onCreateOptionsMenu(menu);
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
        //return super.onOptionsItemSelected(item);
        return true;
    }
}
