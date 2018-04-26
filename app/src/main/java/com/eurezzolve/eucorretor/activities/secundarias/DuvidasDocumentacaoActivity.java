package com.eurezzolve.eucorretor.activities.secundarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterDocumentacao;
import com.eurezzolve.eucorretor.model.Documentacao;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;

import java.util.ArrayList;
import java.util.List;

public class DuvidasDocumentacaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Documentacao> listaDocumentacao = new ArrayList<>();

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_documentacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas Documentação");

        recyclerView = findViewById(R.id.recyclerDoc);

        //Criar uma listagem
        this.criarDocumentacao();

        //Configurar um adapter
        AdapterDocumentacao adapterDocumentacao = new AdapterDocumentacao(listaDocumentacao);


        //Configurar um recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterDocumentacao);

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
    public void criarDocumentacao(){
        Documentacao documentacao = new Documentacao("Quais os documentos necessários para Renda Formal?",
                "> RG/CPG;\n" +
                        "> Certidão de Estado Civil atualizados;\n" +
                        "> Certidão de Nascimento de dependentes (se tiver);\n" +
                        "> Carteira de Trabalho;\n" +
                        "> Três últimos holerites;\n" +
                        "> Comprovante de endereço atualizado;\n" +
                        "> Cópia da declaração do Imposto de Renda completo com recibo de entrega.");
        listaDocumentacao.add(documentacao);

        documentacao = new Documentacao("Quais os documentos necessários para Renda Informal?",
                "> RG/CPG;\n" +
                        "> Certidão de Estado Civil atualizados;\n" +
                        "> Certidão de Nascimento de dependentes (se tiver);\n" +
                        "> Carteira de Trabalho;\n" +
                        "> Comprovante de endereço atualizado em seu nome;\n" +
                        "> Seis últimos extratos bancários;\n" +
                        "> Seis últimas faturas do cartão de crédito;\n" +
                        "> Seis últimos recibos do aluguel(se pagar);\n" +
                        "> Declaração do Imposto de Renda completo com recibo de entrega.");
        listaDocumentacao.add(documentacao);

    }

}
