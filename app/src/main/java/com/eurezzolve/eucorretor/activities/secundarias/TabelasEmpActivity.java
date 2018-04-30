package com.eurezzolve.eucorretor.activities.secundarias;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterValores;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Valores;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TabelasEmpActivity extends AppCompatActivity {

    private RecyclerView recyclerViewInfo;
    private TextView textNome;
    private AdapterValores adapterInfo;
    private List<Valores> informacoesLista = new ArrayList<>();
    private ProgressBar progressBarInfo;

    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private DatabaseReference infoRef;
    private ValueEventListener valueEventListener;
    private Empreendimentos empInicial;
    private Empreendimentos empreendimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabelas_emp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Tabela");

        //Define as Variaveis do Layout XML
        recyclerViewInfo = findViewById(R.id.recyclerInfo);
        textNome = findViewById(R.id.textNomeEmpreendimento);
        progressBarInfo = findViewById(R.id.progressBarInfo);

        /*Ativa a ProgressBar*/
        ativaProgressBar();

        /*Recupera os dados da activity passada*/
        empInicial = (Empreendimentos) getIntent().getSerializableExtra("info");

        /*Seta o nome do emp*/
        String nome = empInicial.getNome();
        textNome.setText(nome);

        //Cria o adapter
        adapterInfo = new AdapterValores(informacoesLista,this);

        //Cria o Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewInfo.setLayoutManager(layoutManager);
        recyclerViewInfo.setHasFixedSize(true);
        recyclerViewInfo.setAdapter(adapterInfo);

    }

    public void criarInformacoes(){
        empreendimentos = (Empreendimentos) getIntent().getSerializableExtra("info");
        String codigoConst = empreendimentos.getCodigoConst();
        String codigo = empreendimentos.getCodigo();

        Log.i("Teste", "Codigo" + codigo);
        Log.i("Teste", "Construtora" + codigoConst);

        infoRef = firebaseRef.child("valores").child(codigoConst).child(codigo);

        valueEventListener = infoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                informacoesLista.clear();
                for(DataSnapshot dados : dataSnapshot.getChildren()){
                    Valores valores = dados.getValue(Valores.class);
                    informacoesLista.add(valores);
                }
                adapterInfo.notifyDataSetChanged();
                /*Desativa a progressBar*/
                desativaProgressBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void ativaProgressBar(){
        progressBarInfo.setVisibility(View.VISIBLE);
    }

    public void desativaProgressBar(){
        progressBarInfo.setVisibility(View.GONE);
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
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        criarInformacoes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        infoRef.removeEventListener(valueEventListener);
    }
}
