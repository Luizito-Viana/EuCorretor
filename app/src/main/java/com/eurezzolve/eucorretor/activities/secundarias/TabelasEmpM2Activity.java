/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:51
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Valores;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class TabelasEmpM2Activity extends AppCompatActivity {

    private TextView textNome, textVenda, textAvaliacao;
    private Button buttonCall;
    private ProgressBar progressBarInfo;
    private Empreendimentos empInicial, empreendimentos;
    private String venda, avaliacao;

    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase().child("valores");
    private DatabaseReference infoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabelas_emp_m2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Tabela");

        textNome = findViewById(R.id.textNomeEmpre);
        textVenda = findViewById(R.id.textVendaRecebida);
        textAvaliacao = findViewById(R.id.textAvaliacaoRecebida);
        buttonCall = findViewById(R.id.buttonCall);
        progressBarInfo = findViewById(R.id.progressBarInfoM2);

        /*Ativa a progrees BAR*/
        ativaProgressBar();

        /*Recupera os dados passados pela intent*/
        empInicial = (Empreendimentos) getIntent().getSerializableExtra("info");

        String nome = empInicial.getNome();
        final String telefone = empInicial.getTelefone();

        /*Seta o nome do Empreendimento*/
        textNome.setText(nome);

        /*Seta o Botao com o numero */
        buttonCall.setText("Telefone: " + telefone);

        /*Recupera os dados*/
        recuperarDadosFirebase();

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",telefone,null));
                startActivity(callIntent);
            }
        });

    }

    public void recuperarDadosFirebase() {
        empreendimentos = (Empreendimentos) getIntent().getSerializableExtra("info");
        String codigoConst = empreendimentos.getCodigoConst();
        String codigo = empreendimentos.getCodigo();


        infoRef = firebaseRef.child(codigoConst).child(codigo);
        infoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    Valores valores = data.getValue(Valores.class);
                    avaliacao = valores.getAvaliacao();
                    venda = valores.getVenda();
                }
                textAvaliacao.setText(avaliacao);
                textVenda.setText(venda);
                desativaProgressBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /*Funcoes ativa e Desativa ProgreesBar*/
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
}
