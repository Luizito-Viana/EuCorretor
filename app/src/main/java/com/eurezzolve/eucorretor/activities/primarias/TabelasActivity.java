package com.eurezzolve.eucorretor.activities.primarias;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterEmp;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class TabelasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Empreendimentos> listaEmpreendimentos = new ArrayList<>();
    private List<Empreendimentos> listaEmpreendimentosBusca;
    private MaterialSearchView searchView;
    private AdapterEmp adapterEmp;

    //OnCreate
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabelas);
        Toolbar toolbar = findViewById(R.id.toolbarTabela);
        toolbar.setTitle("Tabelas");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = findViewById(R.id.recyclerPostagem);

        //Listagem de Empreendimentos
        this.criarEmpreendimentos();

        //Configurar o Adapter
        adapterEmp = new AdapterEmp(listaEmpreendimentos, onClickTabelas(),0);

        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterEmp);


        //Configurando o searchview
        searchView = findViewById(R.id.materialSearchTabelas);

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
    }

    protected AdapterEmp.TabelasOnClickListener onClickTabelas() {
        return new AdapterEmp.TabelasOnClickListener() {
            @Override
            public void onClickTabelas(AdapterEmp.MyViewHoler holder, int idx, int flagLista) {
                if(flagLista == 0){
                    Empreendimentos emp = listaEmpreendimentos.get(idx);
                    Toast.makeText(TabelasActivity.this, "Clicado: " + emp.getNome(), Toast.LENGTH_SHORT).show();
                } else if(flagLista == 1){
                    Empreendimentos emp = listaEmpreendimentosBusca.get(idx);
                    Toast.makeText(TabelasActivity.this, "Clicado: " + emp.getNome(), Toast.LENGTH_SHORT).show();
                }

            }
        };
    }


    public void recarregarEmpreendimentos(){
        adapterEmp = new AdapterEmp(listaEmpreendimentos, onClickTabelas(),0);
        recyclerView.setAdapter(adapterEmp);
        adapterEmp.notifyDataSetChanged();
    }

    public void pesquisarEmpreendimentos(String texto){
        //Log.d("pesquisa", texto);
        listaEmpreendimentosBusca = new ArrayList<>();
        for( Empreendimentos emp : listaEmpreendimentos){
            String nomeEmp = emp.getNome().toLowerCase();
            String constEmp = emp.getConstrutora().toLowerCase();
            //String vendaEmp = emp.getVenda().toLowerCase();
            if(nomeEmp.contains(texto) || constEmp.contains(texto)){
                listaEmpreendimentosBusca.add(emp);
            }
        }
        adapterEmp = new AdapterEmp(listaEmpreendimentosBusca, onClickTabelas(),1);
        recyclerView.setAdapter(adapterEmp);
        adapterEmp.notifyDataSetChanged();
    }


    //Cria os Empreendimentos e Adiciona a lista que é enviada para o Adapter
    public void criarEmpreendimentos(){

        // Os empreendimentos serão exibidos por ordem Alfabetica de Empresa
        // E dentro dessa ordem Alfabetica teremos uma ordem de preços por empresa

        //AZM

        Empreendimentos empreendimentos = new Empreendimentos(
                "Residencial Flores do Cerrado",
                "azm",
                "Venda: R$ 109.900,00 a partir",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_azm,
                "azm_resFloresCerrado", 1, "+34 3213-4393",1,
                "AZM");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Tavares",
                "azm",
                "Venda: R$ 119.900,00 a partir",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_azm,
                "azm_resTavares",1,"+34 3213-4393",1,
                "AZM");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Vertentes III",
                "azm",
                "Venda: R$ 129.900,00 a partir",
                "Avaliação: R$ 150.000,00",
                R.drawable.img_azm,
                "azm_resVertentes", 1,"+34 3213-4393",1,
                "AZM");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Vida Boa",
                "azm",
                "Venda: R$ 134.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_azm,
                "azm_resVidaBoa",1,"+34 3213-4393",1,
                "AZM");
        listaEmpreendimentos.add(empreendimentos);

        //BARI

        empreendimentos = new Empreendimentos(
                "Évora Residence",
                "bari",
                "Venda: R$ 310.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_bari,
                "bari_evoraResidence",0,1,
                "BARI");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Caio Ferreira Residence",
                "bari",
                "Venda: R$ 330.000,00",
                "Avaliação: R$ 395.000,00",
                R.drawable.img_bari,
                "bari_caioFerreira",0,1,
                "BARI");
        listaEmpreendimentos.add(empreendimentos);

        //C&A

        empreendimentos = new Empreendimentos(
                "Jardins Residence",
                "cea",
                "Venda: R$ 127.990,00",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_cea,
                "cea_jardinsRes",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Lexus Office",
                "cea",
                "Venda: R$ 132.582,00 a partir",
                "Avaliação: Individual",
                R.drawable.img_cea,
                "cea_lexusOffice",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Estoril Residence",
                "cea",
                "Venda: R$ 142.990,00",
                "Avaliação: R$ 165.000,00",
                R.drawable.img_cea,
                "cea_estorilRes",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Zenith Residence",
                "cea",
                "Venda: R$ 142.990,00",
                "Avaliação: R$ 165.000,00",
                R.drawable.img_cea,
                "cea_zenithRes",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Jardim Brasília Residencial",
                "cea",
                "Venda: R$ 142.990,00",
                "Avaliação: R$ 168.000,00",
                R.drawable.img_cea,
                "cea_jardimBrasiliaRes",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Solaris",
                "cea",
                "Venda: R$ 149.990,00",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_cea,
                "cea_resSolaris",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Vila Real",
                "cea",
                "Venda: R$ 184.990,00",
                "Avaliação: R$ 185.000,00",
                R.drawable.img_cea,
                "cea_resVilaReal",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Plaza Norte Residence",
                "cea",
                "Venda: R$ 189.990,00 a partir",
                "Avaliação: R$ 190.000,00 a partir",
                R.drawable.img_cea,
                "cea_plazaNorteResidence",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Monsenhor",
                "cea",
                "Venda: R$ 195.990,00",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_cea,
                "cea_resMonsenhor",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Queens Residence",
                "cea",
                "Venda: R$ 198.990,00",
                "Avaliação: R$ 210.000,00",
                R.drawable.img_cea,
                "cea_queensRes",0,1,
                "C&A");
        listaEmpreendimentos.add(empreendimentos);

        //CIMA

        empreendimentos = new Empreendimentos(
                "Versato Residence",
                "cima",
                "Venda: R$ 307.382,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_cima,
                "cima_versatoRes",0,1,
                "CIMA");
        listaEmpreendimentos.add(empreendimentos);

        //CONEL

        empreendimentos = new Empreendimentos(
                "Acqua Torre Centro Sul",
                "conel",
                "Venda: R$ 271.265,92 a partir",
                "Avaliação: R$ 270.891,28 a partir",
                R.drawable.img_conel,
                "conel_acquaTorre",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Gran Plaza Residence",
                "conel",
                "Venda: R$ 284.628,00 a partir",
                "Avaliação: R$ 284.628,00 a partir",
                R.drawable.img_conel,
                "conel_granPlazaRes",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Barão 177",
                "conel",
                "Venda: R$ 299.627,38 a partir",
                "Avaliação: R$ 299.213,57 a partir",
                R.drawable.img_conel,
                "conel_barao177",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Edifício Califórnia",
                "conel",
                "Venda: R$ 328.629,35 a partir",
                "Avaliação: R$ 328.000,00 a partir",
                R.drawable.img_conel,
                "conel_edificioCalifor",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Lídice Premium",
                "conel",
                "Venda: R$1.016.836,38 a partir",
                "Avaliação: R$1.016.863,88 a partir",
                R.drawable.img_conel,
                "conel_lidicePremium",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Varandas Tapuirama",
                "conel",
                "Venda: R$ 1.022.625,81 a partir",
                "Avaliação: R$ 1.021.210,41 a partir",
                R.drawable.img_conel,
                "conel_VarandasTapui",0,1,
                "CONEL");
        listaEmpreendimentos.add(empreendimentos);

        //HLTS

        empreendimentos = new Empreendimentos(
                "Residencial Jardim Holanda",
                "hlts",
                "Venda: R$ 113.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_hlts,
                "hlts_resJardimHol",0,1,
                "HLTS");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Place Alto Umuarama",
                "hlts",
                "Venda: R$ 115.000,00 a partir",
                "Avaliação: R$ 128.000,00 a partir",
                R.drawable.img_hlts,
                "hlts_placeAltoUmu",0,1,
                "HLTS");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "New Quality Residence",
                "hlts",
                "Venda: R$ 138.000,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_hlts,
                "hlts_newQualityRes",0,1,
                "HLTS");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Prime Club Residence",
                "hlts",
                "Venda: R$ 314.300,00 a partir",
                "Avaliação: R$ 370.300,00 a partir",
                R.drawable.img_hlts,
                "hlts_primeClubRes",0,1,
                "HLTS");
        listaEmpreendimentos.add(empreendimentos);

        //HPR

        empreendimentos = new Empreendimentos(
                "Residencial Acácias",
                "hpr",
                "Venda: R$ 174.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_hpr,
                "hpr_resAcacias",0,1,
                "HPR");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Araucárias",
                "hpr",
                "Venda: R$ 179.900,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_hpr,
                "hpr_resAraucarias",0,1,
                "HPR");
        listaEmpreendimentos.add(empreendimentos);

        //L Silva

        empreendimentos = new Empreendimentos(
                "Edifício Rubi Residence",
                "lsilva",
                "Venda: R$ 220.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_lsilva,
                "lsilva_rubiRes",0,1,
                "L Silva");
        listaEmpreendimentos.add(empreendimentos);

        //Marca Registrada

        empreendimentos = new Empreendimentos("Residencial Mirante 1 e 2",
                "marcaRegistrada",
                "Venda: R$110.000,00",
                "Avaliação: R$110.000,00",
                R.drawable.img_marcaregistrada,
                "mr_resMirante",0,1,
                "Marca Registrada");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos("Residenciais Park",
                "marcaRegistrada",
                "Venda: R$120.000,00 a partir",
                "Avaliação: R$127.000,00",
                R.drawable.img_marcaregistrada,
                "mr_residenciaisPark",0,1,
                "Marca Registrada");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos("Residenciais Alpha",
                "marcaRegistrada",
                "Venda: R$120.000,00 a partir",
                "Avaliação: R$128.000,00",
                R.drawable.img_marcaregistrada,
                "mr_residenciaisAlpha",0,1,
                "Marca Registrada");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Gran Toro",
                "marcaRegistrada",
                "Venda: R$ 131.000,00 a partir",
                "Avaliação: R$ 145.000,00 a partir",
                R.drawable.img_marcaregistrada,
                "mr_granToro",0,1,
                "Marca Registrada");
        listaEmpreendimentos.add(empreendimentos);

        //MRV

        /* ARRUMAR O ICONE AQUI*/
        empreendimentos = new Empreendimentos(
                "Parque United States",
                "mrv",
                "Venda: R$ 128.000,00 a partir",
                "Avaliação: R$ 150.500,00 a partir",
                R.drawable.img_marcaregistrada,
                "mrv_parqueUnitedStates",0,1,
                "MRV");
        listaEmpreendimentos.add(empreendimentos);

        //MAXI

        empreendimentos = new Empreendimentos(
                "Provence Residence Club",
                "maxi",
                "Venda: R$334.700,00 a partir",
                "Avaliação: R$340.000,00 a partir",
                R.drawable.img_maxi,
                "maxi_provenceResClub",0,1,
                "MAXI");
        listaEmpreendimentos.add(empreendimentos);

        //Opcao

        empreendimentos = new Empreendimentos(
                "Residencial Platina",
                "opcao",
                "Venda: R$ 136.900,00 a partir",
                "Avaliação: R$ 170.000,00",
                R.drawable.img_opcao,
                "opcao_resPlatina",0,1,
                "Opcao");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Royale",
                "opcao",
                "Venda: R$ 140.900,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_opcao,
                "opcao_royale",0,1,
                "Opcao");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Flamboyant",
                "opcao",
                "Venda: R$ 141.900,00",
                "Avaliação: R$ 167.000,00 a partir",
                R.drawable.img_opcao,
                "opcao_resFlamboyant",0,1,
                "Opcao");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Village Sul",
                "opcao",
                "Venda: R$ 141.900,00 a partir",
                "Avaliação: R$ 180.000,00",
                R.drawable.img_opcao,
                "opcao_villageSul",0,1,
                "Opcao");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Morada do Praia",
                "opcao",
                "Venda: R$ 181.000,00 a partir",
                "Avaliação: R$ 190.000,00",
                R.drawable.img_opcao,
                "opcao_moradaPraia",0,1,
                "Opcao");
        listaEmpreendimentos.add(empreendimentos);

        //PACHECO

        empreendimentos = new Empreendimentos(
                "Residencial Veneza",
                "pacheco",
                "Venda: R$ 290.000,00 a partir",
                "Avaliação: R$ 300.000,00 a partir",
                R.drawable.img_pacheco,
                "pacheco_resVeneza",0,1,
                "Pacheco");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Unique",
                "pacheco",
                "Venda: R$ 355.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_pacheco,
                "pacheco_resUnique",0,1,
                "Pacheco");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Lídice Boulevard",
                "pacheco",
                "Venda: R$ 671.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_pacheco,
                "pacheco_resLidiceBou",0,1,
                "Pacheco");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Evidence",
                "pacheco",
                "Venda: R$ 1.397.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_pacheco,
                "pacheco_resEvidence",0,1,
                "Pacheco");
        listaEmpreendimentos.add(empreendimentos);

        //PDCA

        empreendimentos = new Empreendimentos(
                "Jardins do Cerrado",
                "pdca",
                "Venda: R$ 128.000,00",
                "Avaliação: R$ 128.000,00",
                R.drawable.img_pdca,
                "pdca_jardinsCerrado",0,1,
                "PDCA");
        listaEmpreendimentos.add(empreendimentos);

        //Portento

        empreendimentos = new Empreendimentos(
                "Residencial La Belle",
                "portento",
                "Venda: R$ 135.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_portento,
                "portento_laBelle",0,1,
                "Portento");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Ravena",
                "portento",
                "Venda: R$ 140.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_portento,
                "portento_ravena",0,1,
                "Portento");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Sevilha",
                "portento",
                "Venda: R$ 144.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_portento,
                "portento_sevilha",0,1,
                "Portento");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Valência",
                "portento",
                "Venda: R$ 145.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_portento,
                "portento_valencia",0,1,
                "Portento");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Residencial Milão",
                "portento",
                "Venda: R$ 330.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_portento,
                "portento_milao",0,1,
                "Portento");
        listaEmpreendimentos.add(empreendimentos);

        //R. Freitas

        empreendimentos = new Empreendimentos(
                "Condominio Bosque das Gameleiras",
                "rFreitas",
                "Venda: R$ 180.000,00 a partir",
                "Avaliação: R$ 187.000,00 a partir",
                R.drawable.img_rfreitas,
                "rfreitas_gameleiras",0,1,
                "R Freitas");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Edifício Aristides de Freitas",
                "rFreitas",
                "Venda: R$ 359.000,00 a partir",
                "Avaliação: R$ 400.000,00",
                R.drawable.img_rfreitas,
                "rfreitas_aristides",0,1,
                "R Freitas");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "UZ Tower",
                "rFreitas",
                "Venda: R$ 384.544,03 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_rfreitas,
                "rfreitas_uzTower",0,1,
                "R Freitas");
        listaEmpreendimentos.add(empreendimentos);

        //Realiza

        empreendimentos = new Empreendimentos(
                "Tropical Sul",
                "realiza",
                "Venda: R$ 180.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_rfreitas,
                "realiza_tropicalSul",0,1,
                "Realiza");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Anita Residence",
                "realiza",
                "Venda: R$ 310.500,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_rfreitas,
                "realiza_anitaRes",0,1,
                "Realiza");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Village Paradiso II",
                "realiza",
                "Venda: R$ 619.368,10 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_rfreitas,
                "realiza_villageParII",0,1,
                "Realiza");
        listaEmpreendimentos.add(empreendimentos);

        //TROIA

        empreendimentos = new Empreendimentos(
                "Splendia Residence",
                "troia",
                "Venda: R$ 540.000,00 a partir",
                "Avaliação: Não possui!",
                R.drawable.img_troia,
                "troia_splendiaRes",0,1,
                "Troia");
        listaEmpreendimentos.add(empreendimentos);

        //URBANI

        empreendimentos = new Empreendimentos(
                "Residencial Napoli",
                "urbani",
                "Venda: R$ 129.900,00 a partir",
                "Avaliação: R$ 163.000,00 a partir",
                R.drawable.img_urbani,
                "urbani_resNapoli",0,1,
                "Urbani");
        listaEmpreendimentos.add(empreendimentos);

        //Vivamus

        empreendimentos = new Empreendimentos(
                "Start Tower Vivamus JH II",
                "vivamus",
                "Venda: R$ 128.000,00",
                "Avaliação: R$ R$ 128.000,00",
                R.drawable.img_vivamus,
                "vivamus_startTower",0,1,
                "Vivamus");
        listaEmpreendimentos.add(empreendimentos);

        empreendimentos = new Empreendimentos(
                "Smart Tower Vivamus JH II",
                "vivamus",
                "Venda: R$ 151.990,00 a partir",
                "Avaliação: R$ 183.000,00",
                R.drawable.img_vivamus,
                "vivamus_smartTower",0,1,
                "Vivamus");
        listaEmpreendimentos.add(empreendimentos);
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

    //Evento de Click
        /*recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, final int position) {
                                Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
                                Toast.makeText(getApplicationContext(),"Escolhido: " + empreendimentos.getNome(),Toast.LENGTH_SHORT).show();
                                if(empreendimentos.getAct_flag() == 0){
                                    Intent i = new Intent(TabelasActivity.this, InformacoesActivity.class);
                                    i.putExtra("codigo",empreendimentos.getCodigo());
                                    i.putExtra("construtora",empreendimentos.getConstrutora());
                                    i.putExtra("nome",empreendimentos.getNome());
                                    startActivity(i);
                                } else if(empreendimentos.getAct_flag() == 1) {
                                    Intent j = new Intent(TabelasActivity.this, Informacoes2Activity.class);
                                    j.putExtra("codigo",empreendimentos.getCodigo());
                                    j.putExtra("construtora",empreendimentos.getConstrutora());
                                    j.putExtra("nome",empreendimentos.getNome());
                                    j.putExtra("telefone",empreendimentos.getTelefone());
                                    startActivity(j);
                                }

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),"Para abrir, clique apenas uma vez",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        ); */


}
