package com.eurezzolve.eucorretor.activities.primarias;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.secundarias.DuvidasSimplificadaActivity;
import com.eurezzolve.eucorretor.adapter.AdapterMenuDuvidas;
import com.eurezzolve.eucorretor.config.RecyclerItemClickListener;
import com.eurezzolve.eucorretor.model.MenuDuvida;

import java.util.ArrayList;
import java.util.List;

public class DuvidasActivity extends AppCompatActivity {

    private Button btnEmail;
    private SearchView searchViewPesquisa;
    private RecyclerView recyclerPesquisa;
    private AdapterMenuDuvidas adapterMenuDuvidas;
    private List<MenuDuvida> listaMenu = new ArrayList<>();
    private List<MenuDuvida> listaBusca = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas);

        Toolbar toolbar = findViewById(R.id.toolbarDuvidas);
        toolbar.setTitle("Dúvidas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        /*Identificando as Variaveis*/
        btnEmail = findViewById(R.id.btnEmail);
        searchViewPesquisa = findViewById(R.id.search_duvidas);
        recyclerPesquisa = findViewById(R.id.recyclerDuvidasMenu);

        /*Cria as Duvidas*/
        this.criarDuvidas();

        /*Cria o Adapter*/
        adapterMenuDuvidas = new AdapterMenuDuvidas(listaMenu);

        /*Recycler Configuracoes*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPesquisa.setLayoutManager(layoutManager);
        recyclerPesquisa.setHasFixedSize(true);
        recyclerPesquisa.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerPesquisa.setAdapter(adapterMenuDuvidas);

        recyclerPesquisa.addOnItemTouchListener(new RecyclerItemClickListener(
                this,
                recyclerPesquisa,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {
                        List<MenuDuvida> listaReal = adapterMenuDuvidas.getListaItens();
                        MenuDuvida item = listaReal.get(position);
                        Intent i = new Intent(DuvidasActivity.this, DuvidasSimplificadaActivity.class);
                        i.putExtra("opcao", item.getIdTema());
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }
        ));

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaDeConfirmacao();
            }
        });

        searchViewPesquisa.setQueryHint("Buscar dúvida");
        searchViewPesquisa.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String textoDigitado = newText.toLowerCase();
                pesquisarItem(textoDigitado);
                return true;
            }
        });

    }

    private void pesquisarItem(String textoDigitado) {
        listaBusca.clear();
        for(MenuDuvida itemMenu : listaMenu){
            String item = itemMenu.getItemMenu().toLowerCase();
            if(item.contains(textoDigitado)){
                listaBusca.add(itemMenu);
            }
        }

        adapterMenuDuvidas = new AdapterMenuDuvidas(listaBusca);
        recyclerPesquisa.setAdapter(adapterMenuDuvidas);
        adapterMenuDuvidas.notifyDataSetChanged();

    }

    private void criarDuvidas() {
        MenuDuvida itemMenu = new MenuDuvida("Documentação", 2);
        listaMenu.add(itemMenu);

        itemMenu = new MenuDuvida("Financiamento", 1);
        listaMenu.add(itemMenu);

        itemMenu = new MenuDuvida("Simulação", 3);
        listaMenu.add(itemMenu);
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
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nova dúvida!");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"eurezzolve@gmail.com"});
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DuvidasActivity.this, "Evento cancelado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
