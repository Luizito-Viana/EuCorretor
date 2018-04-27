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
        adapterTerceiros = new AdapterTerceiros(listaTerceiros, tbOnClickListener() ,descOnClickListener());

        //Cria e configura o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerTerceiros.setLayoutManager(layoutManager);
        recyclerTerceiros.setHasFixedSize(true);
        recyclerTerceiros.setAdapter(adapterTerceiros);

        //Configurando o searchview
        searchView = findViewById(R.id.materialSearchTabelas);

        //Listener para o searchview
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

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
                /*if(newText != null && !newText.isEmpty()){

                }*/
                return true;
            }
        });

    }

    //Cria os terceiros
    public void criarTerceiros(){
        Terceiros terceiros = new Terceiros("Imóvel do Luiz", "Luiz Viana", "4 Quartos\n3 Banheiros", R.drawable.casa_imovel);
        listaTerceiros.add(terceiros);
    }

    /*Métodos de Cliquues no Tabela e Descrição*/
    protected AdapterTerceiros.DescricaoTerceirosOnClickListener descOnClickListener(){
        return new AdapterTerceiros.DescricaoTerceirosOnClickListener() {
            @Override
            public void descTerceirosOnClick(AdapterTerceiros.TerceirosHolder holder, int position) {
                Terceiros terceiros = listaTerceiros.get(position);
                //Toast.makeText(TerceirosActivity.this, "Descrição: " + terceiros.getNome(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(TerceirosActivity.this, DescricaoTerceirosActivity.class);
                i.putExtra("info", terceiros);
                startActivity(i);
            }
        };
    }

    protected AdapterTerceiros.TabelasTerceirosOnClickListener tbOnClickListener(){
        return new AdapterTerceiros.TabelasTerceirosOnClickListener() {
            @Override
            public void tbTerceirosOnClick(AdapterTerceiros.TerceirosHolder holder, int position) {
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
