package com.eurezzolve.eucorretor.activities.primarias;

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
import com.eurezzolve.eucorretor.adapter.AdapterTerceiros;
import com.eurezzolve.eucorretor.adapter.AdapterTerrenos;
import com.eurezzolve.eucorretor.model.Terrenos;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class TerrenosActivity extends AppCompatActivity {

    private RecyclerView recyclerTerrenos;
    private List<Terrenos> listaTerrenos = new ArrayList<>();
    private List<Terrenos> listaTerrenosBusca;
    private MaterialSearchView searchView;
    private AdapterTerrenos adapterTerrenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrenos);

        Toolbar toolbar = findViewById(R.id.toolbarTabela);
        toolbar.setTitle("Terrenos");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerTerrenos = findViewById(R.id.recyclerTerrenos);

        /*Cria a lista*/
        this.criarTerrenos();

        /*Adapter*/
        adapterTerrenos = new AdapterTerrenos(listaTerrenos, tbTerrenosOnClick(), descTerrenosOnClick(), 0);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerTerrenos.setLayoutManager(layoutManager);
        recyclerTerrenos.setHasFixedSize(true);
        recyclerTerrenos.setAdapter(adapterTerrenos);

        //Configurando o searchview
        searchView = findViewById(R.id.materialSearchTabelas);
        searchView.setHint("Buscar Terrenos");

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
                if(newText != null && !newText.isEmpty()){
                }
                return true;
            }
        });
    }

    private AdapterTerrenos.DescricaoTerrenosOnClickListener descTerrenosOnClick() {
        return new AdapterTerrenos.DescricaoTerrenosOnClickListener() {
            @Override
            public void descTerrenosOnClick(AdapterTerrenos.ViewHolderTerrenos holder, int position, int flagLista) {
                Toast.makeText(TerrenosActivity.this, "Ainda não Aprimorado", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private AdapterTerrenos.TabelasTerrenosOnClickListener tbTerrenosOnClick() {
        return new AdapterTerrenos.TabelasTerrenosOnClickListener() {
            @Override
            public void tbTerrenosOnClick(AdapterTerrenos.ViewHolderTerrenos holder, int position, int flagLista) {
                Toast.makeText(TerrenosActivity.this, "Ainda não Aprimorado", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void criarTerrenos() {
        Terrenos terrenos = new Terrenos("Imóvel do Luiz",
                "Luiz Viana",
                "4 Quartos\n3 Banheiros",
                R.drawable.avatar_terreno);
        listaTerrenos.add(terrenos);
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
