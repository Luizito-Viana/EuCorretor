/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:39
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.primarias;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.secundarias.DescricaoEmpActivity;
import com.eurezzolve.eucorretor.activities.secundarias.FiltrarActivity;
import com.eurezzolve.eucorretor.activities.secundarias.TabelasEmpActivity;
import com.eurezzolve.eucorretor.activities.secundarias.TabelasEmpM2Activity;
import com.eurezzolve.eucorretor.adapter.AdapterEmp;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.CriarEmpreendimentos;
import com.eurezzolve.eucorretor.model.Config;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.ImagensEmp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class EmpreendimentosActivity extends AppCompatActivity {

    private int filtroFaixa = 0;
    private int filtroConstrutora = 0;
    private Boolean filtrandoPorFaixa = false;

    private Button btnConstrutora, btnFaixa;
    private ProgressBar loadBar;
    private RecyclerView recyclerView;
    private List<Empreendimentos> listaEmpreendimentos = new ArrayList<>();
    private List<Empreendimentos> listaEmpreendimentosBusca;
    private MaterialSearchView searchView;
    private AdapterEmp adapterEmp;

    private DatabaseReference empRef;
    private DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase();
    private ValueEventListener valueEventListenerEmp;

    //OnCreate
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabelas);
        Toolbar toolbar = findViewById(R.id.toolbarTabela);
        toolbar.setTitle("Empreendimentos");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getWindow().setEnterTransition(new Explode());

        loadBar = findViewById(R.id.progressLoadEmp);
        recyclerView = findViewById(R.id.recyclerPostagem);
        btnConstrutora = findViewById(R.id.btnConstrutora);
        btnFaixa = findViewById(R.id.btnFaixa);

        //Configurar o Adapter
        adapterEmp = new AdapterEmp(listaEmpreendimentos, tabelasEmpOnClickListener(), descricaoEmpOnClickListener(),0);


        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapterEmp);

        //Configurando o searchview
        searchView = findViewById(R.id.materialSearchTabelas);
        searchView.setHint("Buscar Empreendimento");
        //searchView.setSuggestions(getResources().getStringArray(R.array.emp_suggestions));

        //Listener para o searchview
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                recarregarEmpreendimentos();
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
                    pesquisarEmpreendimentos(newText);
                }
                return true;
            }
        });
        ativaProgressBar();

    }

    public void ativaProgressBar(){
        loadBar.setVisibility(View.VISIBLE);
    }

    public void desativaProgressBar(){
        loadBar.setVisibility(View.GONE);
    }

    public AdapterEmp.DescricaoEmpOnClickListener descricaoEmpOnClickListener () {
        return new AdapterEmp.DescricaoEmpOnClickListener() {
            @Override
            public void descEmpOnClick(AdapterEmp.MyViewHoler holer, int position, int flagLista) {
                if(flagLista == 0){
                    Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
                    Intent i = new Intent(EmpreendimentosActivity.this, DescricaoEmpActivity.class);
                    i.putExtra("info", empreendimentos);
                    startActivity(i);
                } else if(flagLista == 1){
                    Empreendimentos emp = listaEmpreendimentosBusca.get(position);
                    Intent j = new Intent(EmpreendimentosActivity.this, DescricaoEmpActivity.class);
                    j.putExtra("info", emp);
                    startActivity(j);
                }

            }
        };
    }

    public AdapterEmp.TabelasEmpOnClickListener tabelasEmpOnClickListener () {
        return new AdapterEmp.TabelasEmpOnClickListener() {
            @Override
            public void tbEmpOnClick(AdapterEmp.MyViewHoler holer, int position, int flafLista) {
                //Toast.makeText(EmpreendimentosActivity.this, "Tabelas ainda não aprimorado", Toast.LENGTH_SHORT).show();
                if(flafLista == 0){
                    Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
                    if(empreendimentos.getAct_flag() == 0){
                        Intent i = new Intent(EmpreendimentosActivity.this, TabelasEmpActivity.class);
                        i.putExtra("info", empreendimentos);
                        startActivity(i);
                    } else {
                        Intent j = new Intent(EmpreendimentosActivity.this, TabelasEmpM2Activity.class);
                        j.putExtra("info", empreendimentos);
                        startActivity(j);
                    }

                } else if(flafLista == 1){
                    Empreendimentos empreendimentos = listaEmpreendimentosBusca.get(position);
                    if(empreendimentos.getAct_flag() == 0){
                        Intent j = new Intent(EmpreendimentosActivity.this, TabelasEmpActivity.class);
                        j.putExtra("info", empreendimentos);
                        startActivity(j);
                    } else {
                        Intent j = new Intent(EmpreendimentosActivity.this, TabelasEmpM2Activity.class);
                        j.putExtra("info", empreendimentos);
                        startActivity(j);
                    }
                }
            }
        };
    }

    public void recarregarEmpreendimentos(){
        adapterEmp = new AdapterEmp(listaEmpreendimentos, tabelasEmpOnClickListener(), descricaoEmpOnClickListener(), 0);
        recyclerView.setAdapter(adapterEmp);
        adapterEmp.notifyDataSetChanged();
    }

    public void pesquisarEmpreendimentos(String texto){

        listaEmpreendimentosBusca = new ArrayList<>();
        for( Empreendimentos emp : listaEmpreendimentos){
            String nomeEmp = emp.getNome().toLowerCase();
            String constEmp = emp.getConstrutora().toLowerCase();
            //String vendaEmp = emp.getVenda().toLowerCase();
            if(nomeEmp.contains(texto) || constEmp.contains(texto)){
                listaEmpreendimentosBusca.add(emp);
            }
        }

        adapterEmp = new AdapterEmp(listaEmpreendimentosBusca, tabelasEmpOnClickListener(), descricaoEmpOnClickListener(),1);
        recyclerView.setAdapter(adapterEmp);
        adapterEmp.notifyDataSetChanged();
    }

    private void recuperarEmpreendimentos() {
        listaEmpreendimentos.clear();

        /*listaEmpreendimentos = CriarEmpreendimentos.retornaEmp();
        Log.d("Lista", "recuperarEmpreendimentos: " + listaEmpreendimentos.get(0).getNome());
        for(Empreendimentos emp : listaEmpreendimentos){
            emp.salvar();
            switch (emp.getFaixa()) {
                case "Faixa 1,5":
                    emp.salvarFaixa(1);
                    break;
                case "Faixa 2":
                    emp.salvarFaixa(2);
                    break;
                case "Acima":
                    emp.salvarFaixa(3);
                    break;
                default:
                    emp.salvarFaixa(4);
                    break;
            }
        }*/

        empRef = reference.child("listaEmp");
        valueEventListenerEmp = empRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Empreendimentos empreendimentos = ds.getValue(Empreendimentos.class);
                    empreendimentos.setImagem(Integer.parseInt(String.valueOf(empreendimentos.getImagem())));
                    listaEmpreendimentos.add(empreendimentos);
                }
                adapterEmp.notifyDataSetChanged();
                desativaProgressBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
    protected void onStart() {
        super.onStart();
        recuperarEmpreendimentos();
    }

    @Override
    protected void onStop() {
        super.onStop();
        empRef.removeEventListener(valueEventListenerEmp);
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

    /*Filtros*/
    public void filtrarPorFaixaEsc(View view) {
        AlertDialog.Builder dialogEstado = new AlertDialog.Builder(this);
        dialogEstado.setTitle("Selecione a Faixa desejada");

        //Configurar spinner
        View viewSpinner = getLayoutInflater().inflate(R.layout.dialog_spinner, null);

        //Configura spinner de estados
        final Spinner spinnerFaixas = viewSpinner.findViewById(R.id.spinnerFiltro);
        String[] faixas = getResources().getStringArray(R.array.faixas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,
                faixas
        );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerFaixas.setAdapter( adapter );

        dialogEstado.setView( viewSpinner );

        dialogEstado.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                recuperarAnunciosPorFaixa(spinnerFaixas.getSelectedItemPosition());
                filtrandoPorFaixa = true;
            }
        });

        dialogEstado.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = dialogEstado.create();
        dialog.show();
    }

    public void filtrarPorConstrutoraEsc(View view) {
        AlertDialog.Builder dialogEstado = new AlertDialog.Builder(this);
        dialogEstado.setTitle("Selecione a Construtora desejada");

        //Configurar spinner
        View viewSpinner = getLayoutInflater().inflate(R.layout.dialog_spinner, null);

        //Configura spinner de estados
        final Spinner spinnerConstr = viewSpinner.findViewById(R.id.spinnerFiltro);
        String[] construtoras = getResources().getStringArray(R.array.construtorasLista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,
                construtoras
        );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerConstr.setAdapter( adapter );

        dialogEstado.setView( viewSpinner );

        dialogEstado.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                recuperarAnunciosPorConstrutora(spinnerConstr.getSelectedItemPosition());
                filtrandoPorFaixa = true;
            }
        });

        dialogEstado.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = dialogEstado.create();
        dialog.show();
    }

    private void recuperarAnunciosPorConstrutora(int id) {
        String[] construtoras = getResources().getStringArray(R.array.construtorasListaIds);
        String construtoraEscolhida = construtoras[id];
        Toast.makeText(EmpreendimentosActivity.this, "Escolha: " + construtoraEscolhida, Toast.LENGTH_SHORT).show();
        if(listaEmpreendimentosBusca != null){
            listaEmpreendimentosBusca.clear();
        } else {
            listaEmpreendimentosBusca = new ArrayList<>();
        }
    }

    private void recuperarAnunciosPorFaixa(int id) {
        ativaProgressBar();
        String[] faixas = getResources().getStringArray(R.array.faixasIds);
        String faixaEscolhida = faixas[id];
        Log.d("Faixa", "recuperarAnunciosPorFaixa: " + faixaEscolhida);
        if(listaEmpreendimentosBusca != null){
            listaEmpreendimentosBusca.clear();
        } else {
            listaEmpreendimentosBusca = new ArrayList<>();
        }

        if(faixaEscolhida.equals("todos")){
            recarregarEmpreendimentos();
        } else {
            DatabaseReference faixaRef = reference.child("listaEmpPorFaixa").child(faixaEscolhida);
            valueEventListenerEmp = faixaRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Empreendimentos empreendimentos = ds.getValue(Empreendimentos.class);
                        empreendimentos.setImagem(Integer.parseInt(String.valueOf(empreendimentos.getImagem())));
                        listaEmpreendimentosBusca.add(empreendimentos);
                    }
                    adapterEmp = new AdapterEmp(listaEmpreendimentosBusca, tabelasEmpOnClickListener(), descricaoEmpOnClickListener(),1);
                    recyclerView.setAdapter(adapterEmp);
                    adapterEmp.notifyDataSetChanged();
                    desativaProgressBar();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
