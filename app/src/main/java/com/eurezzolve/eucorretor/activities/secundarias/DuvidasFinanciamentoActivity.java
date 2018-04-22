package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterFinanciamento;
import com.eurezzolve.eucorretor.model.Financiamento;

import java.util.ArrayList;
import java.util.List;

public class DuvidasFinanciamentoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Financiamento> listaFinanciamento = new ArrayList<>();

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_financiamento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas Financiamento");

        recyclerView = findViewById(R.id.recyclerFinanciamento);

        //Criar Listagem de Duvidas
        this.criarFinanciamento();

        //Configurar Adapter
        AdapterFinanciamento adapterFinanciamento = new AdapterFinanciamento(listaFinanciamento);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFinanciamento);

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
    public void criarFinanciamento(){
        Financiamento financiamento = new Financiamento("Como funciona o Subsídio?",
                "O subsídio do programa MCMV (Minha Casa Minha Vida) é um desconto em que o governo oferece, custeando parte do valor do imóvel.\n" +
                        "Assim facilitando as condições de compra, ajudando o brasileiro a adquirir o imóvel próprio, lembrando que esse valor é abatido direto no valor do imóvel!");
        listaFinanciamento.add(financiamento);

        financiamento = new Financiamento("O que seria a inadimplência?",
                "As pessoas que possuírem inadimplência nos orgãos do SPC/SERASA estarão impossibilitadas de adquirir imóvel pelo programa MCMV.\n" +
                        "A recomendação é que o corretor auxulie no processo de limpeza do nome para prosseguir com o processo de financiamento.");
        listaFinanciamento.add(financiamento);

        financiamento = new Financiamento("Posso financiar possuindo renda Informal?",
                "Sim! Mas os clientes que não possuírem renda formalizada (dos quais não emitem contra cheque) estão sujeitas a maior burocracia no processo de financiamento," +
                        " pois, para a comprovação de tal feito, é necessário diversos documentos extras, estando assim, mais sujeitos a reprovação.");
        listaFinanciamento.add(financiamento);

        financiamento = new Financiamento("Fui reprovado, o que fazer?",
                "Em casos de reprovação de crédito do financiamento, é recomendado que o Corretor auxilie o cliente a ter um maior relacionamento com o banco financiador.");
        listaFinanciamento.add(financiamento);

        financiamento = new Financiamento("Como posso ter um bom relacionamento?",
                "O bom relacionamento com o Banco financiador é dado por alguns critérios:\n" +
                        "> Abrir uma conta corrente;\n" +
                        "> Adquirir produtos do Banco (cartões de créditos, cheque especial);\n" +
                        "> Seguro de vida;\n" +
                        "> Portabilidade de salário;\n" +
                        "> Entre outros...");
        listaFinanciamento.add(financiamento);

        financiamento = new Financiamento("Como funciona o dependente?",
                "Dependente é o sujeito que entra em conjunto com a pessoa que realiza o financiamento, não necessariamente necessita ser filhos, pode ser qualquer pessoa desde que o mesmo não tenha renda comprovada!\n" +
                        "Lembrando que a pessoa que não for filho e/ou receber através de renda comprovada, entra como coparticipante no financiamento, logo, possui parte do imóvel para si.");
        listaFinanciamento.add(financiamento);

    }
}
