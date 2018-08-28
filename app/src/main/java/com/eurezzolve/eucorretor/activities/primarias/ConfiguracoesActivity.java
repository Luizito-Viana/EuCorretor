/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:39
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.introducao.MainActivity;
import com.eurezzolve.eucorretor.activities.secundarias.CadastroImoveisActivity;
import com.eurezzolve.eucorretor.activities.secundarias.LegendaActivity;
import com.eurezzolve.eucorretor.activities.secundarias.NotificacaoActivity;
import com.eurezzolve.eucorretor.activities.secundarias.SobreActivity;
import com.eurezzolve.eucorretor.adapter.AdapterConfig;
import com.eurezzolve.eucorretor.model.Config;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.RecyclerItemClickListener;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracoesActivity extends AppCompatActivity {

    private static final int REQUEST_INVITE = 78;
    private FirebaseAuth autenticacao;

    private RecyclerView recyclerViewConfig;
    private List<Config> listaConfig = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Configurações");

        recyclerViewConfig = findViewById(R.id.recyclerConfiguracoes);

        //Criar Listagem
        this.criarConfiguracoes();

        //Configurar Adapter
        AdapterConfig adapterConfig = new AdapterConfig(listaConfig);

        //Configurar Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewConfig.setLayoutManager(layoutManager);
        recyclerViewConfig.setHasFixedSize(true);
        recyclerViewConfig.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewConfig.setAdapter(adapterConfig);

        //Evento de click
        recyclerViewConfig.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerViewConfig,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Config config = listaConfig.get(position);
                        int order = config.getOrder();
                        executarAcoes(order);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }

    //Listagem de configuracoes para mandar ao adpter
    public void criarConfiguracoes() {

        Config config = new Config("Legenda",R.drawable.ic_config_legenda,0);
        listaConfig.add(config);

        config = new Config("Notificações", R.drawable.ic_config_alertas,4);
        listaConfig.add(config);

        config = new Config("Cadastro de imóveis", R.drawable.ic_config_cadastroimoveis, 6);
        listaConfig.add(config);

        config = new Config("Indique", R.drawable.ic_config_indique, 5);
        listaConfig.add(config);

        config = new Config("Sobre",R.drawable.ic_config_sobre,3);
        listaConfig.add(config);

        config = new Config("Sair",R.drawable.ic_config_sair,1);
        listaConfig.add(config);

    }

    //Cria e executa as ações de acordo com o item selecionado
    public void executarAcoes(int order) {
        switch (order) {
            case 0: //Abre as legendas
                startActivity(new Intent(ConfiguracoesActivity.this, LegendaActivity.class));
                break;
            case 1: //Sai do app
                autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                autenticacao.signOut();
                startActivity(new Intent(ConfiguracoesActivity.this, MainActivity.class));
                finish();
                break;
            case 3: //Abre a Pagina Sobre
                startActivity(new Intent(ConfiguracoesActivity.this, SobreActivity.class));
                break;
            case 4:
                startActivity(new Intent(ConfiguracoesActivity.this, NotificacaoActivity.class));
                break;
            case 5: //Chama a funcao para enviar a um novo usuario
                //inviteCall();
                Toast.makeText(ConfiguracoesActivity.this,"Ainda não aprimorado",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                startActivity(new Intent(ConfiguracoesActivity.this, CadastroImoveisActivity.class));
                break;
            default:
                break;
        }
    }

    //Invita um novo usuario
    private void inviteCall(){
        String messageEnviar = "Eu estou usando o aplicativo EuCorretor e estou gostando muito, vale o investimento!\n" +
                "Venha você também usar!";
        Intent intent = new AppInviteInvitation.IntentBuilder("EuCorretor")
                .setMessage(messageEnviar)
                .build();

        startActivityForResult(intent, REQUEST_INVITE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_INVITE){
            if(requestCode == RESULT_OK) {
                String ids[] = AppInviteInvitation.getInvitationIds(resultCode,data);
            } else {

            }
        }
    }

    //Volta para a anterior fechando a atual
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
