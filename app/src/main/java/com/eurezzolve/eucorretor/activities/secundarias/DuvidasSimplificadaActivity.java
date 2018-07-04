package com.eurezzolve.eucorretor.activities.secundarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.terciarias.RespostasActivity;
import com.eurezzolve.eucorretor.adapter.AdapterPerguntasRespostas;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.RecyclerItemClickListener;
import com.eurezzolve.eucorretor.model.PerguntasRespostas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DuvidasSimplificadaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView titulo;
    private ProgressBar progressBar;
    private SearchView searchPesquisa;

    private List<PerguntasRespostas> listaPerguntas = new ArrayList<>();
    private List<PerguntasRespostas> listaBusca = new ArrayList<>();

    private DatabaseReference perguntasRef = ConfiguracaoFirebase.getFirebaseDatabase().child("duvidas");

    private AdapterPerguntasRespostas adapterPerguntasRespostas;

    private int opcao;
    private String escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_simplificadas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas");

        titulo = findViewById(R.id.textEscolhaDuvida);
        progressBar = findViewById(R.id.progressDuvidas);
        searchPesquisa = findViewById(R.id.search_especifica);

        Bundle dados = getIntent().getExtras();
        opcao = dados.getInt("opcao");
        if (opcao == 1) {
            escolha = "Financiamento";
        } else if (opcao == 2) {
            escolha = "Documentação";
        } else {
            escolha = "Simulação";
        }
        titulo.setText("Dúvidas sobre " + escolha);

        recyclerView = findViewById(R.id.recyclerRespostas);

        //Configurar Listagem
        this.criarPerguntaseRespostas();

        //Configurar Adapter
        adapterPerguntasRespostas = new AdapterPerguntasRespostas(listaPerguntas);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterPerguntasRespostas);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                List<PerguntasRespostas> listaReal = adapterPerguntasRespostas.getPerguntasLista();
                PerguntasRespostas perguntasRespostas = listaReal.get(position);
                Intent i = new Intent(DuvidasSimplificadaActivity.this, RespostasActivity.class);
                i.putExtra("pergunta",  perguntasRespostas.getPergunta());
                i.putExtra("resposta", perguntasRespostas.getResposta());
                startActivity(i);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));

        progressBar.setVisibility(View.VISIBLE);

        searchPesquisa.setQueryHint("Buscar dúvida");
        searchPesquisa.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        for(PerguntasRespostas perguntasRespostas : listaPerguntas){
            String pergunta = perguntasRespostas.getPergunta().toLowerCase();
            if(pergunta.contains(textoDigitado)){
                listaBusca.add(perguntasRespostas);
            }
        }

        adapterPerguntasRespostas = new AdapterPerguntasRespostas(listaBusca);
        recyclerView.setAdapter(adapterPerguntasRespostas);
        adapterPerguntasRespostas.notifyDataSetChanged();

    }

    private void criarPerguntaseRespostas() {
        String escolhido;
        if (opcao == 1) {
            escolhido = "financiamento";
        } else if (opcao == 2) {
            escolhido = "documentacao";
        } else {
            escolhido = "simulacao";
        }

        perguntasRef.child(escolhido).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    PerguntasRespostas perguntas = ds.getValue(PerguntasRespostas.class);
                    listaPerguntas.add(perguntas);
                }
                adapterPerguntasRespostas.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
