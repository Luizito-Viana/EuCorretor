package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.UsuarioFirebase;
import com.eurezzolve.eucorretor.fragments.EmpBuscaFragment;
import com.eurezzolve.eucorretor.fragments.MapsActivity;
import com.eurezzolve.eucorretor.fragments.SearchFragment;
import com.eurezzolve.eucorretor.fragments.TerceirosFragment;
import com.eurezzolve.eucorretor.fragments.TerrenosFragment;
import com.eurezzolve.eucorretor.helper.NotificationUtil;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Marcadores;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseUser;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener
{
    private SearchFragment searchFragment;

    /*Variaveis para uso de pesquisa*/
    private String nome, subtitulo;
    private Double latitude, longitude;


    private static final String primeiraEx = "firstRun";
    private FragmentManager fragmentManager;
    private CircleImageView circleImageView;
    private TextView textNomeNav;
    private SharedPreferences preferences;
    private MaterialSearchView searchView;
    private List<Marcadores> listaMarcadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //searchFragment = new SearchFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*Navigation View*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerLayout = navigationView.getHeaderView(0);
        circleImageView = headerLayout.findViewById(R.id.circleImage);
        textNomeNav = headerLayout.findViewById(R.id.textNomeNav);

        /*Bottom Navigation*/
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        searchView = findViewById(R.id.search_view);
        searchView.setHint("Pesquisar");
        //searchView.setSuggestions(getResources().getStringArray(R.array.emp_suggestions));



        /*Listener para o SearchView*/
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                 /*Trocando para os Fragment Principal*/
                searchFragment = new SearchFragment();
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
                transaction.setCustomAnimations( android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.replace(R.id.containerPrincipal, searchFragment); //Adiciona o Fragment
                transaction.commit();
            }

            @Override
            public void onSearchViewClosed() {
                /*Trocando para os Fragment Principal*/
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
                transaction.replace(R.id.containerPrincipal, new MapsActivity()); //Adiciona o Fragment
                transaction.commit();
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                enviarCompleto(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //SearchFragment searchFragment = SearchFragment.newInstace();
                if(newText != null & !newText.isEmpty()) {
                    searchFragment.pesquisarEmp(newText.toLowerCase());
                }
                return true;
            }
        });

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
        transaction.add(R.id.containerPrincipal, new MapsActivity(), "MapsFragment"); //Adiciona o Fragment
        transaction.commit(); //Aplica o commit, para verificar se esta tudo certo

        preferences = getSharedPreferences(primeiraEx, MODE_PRIVATE);

        this.criarListaMarcadoresBuscas();

    }



    /*EnviarCompleto e EnviarPartes*/
    public void enviarCompleto(String texto){
        for(Marcadores marcador : listaMarcadores){
            String nomeMarcador = marcador.getNome().toLowerCase();
            String nomePesquisaM1 = marcador.getPesquisaM1().toLowerCase();
            String nomePesquisaM2 = marcador.getPesquisaM2().toLowerCase();
            String nomePesquisaM3 = marcador.getPesquisaM3().toLowerCase();
            String nomePesquisaM4 = marcador.getPesquisaM4().toLowerCase();

            if(nomeMarcador.equals(texto)|| nomePesquisaM1.equals(texto) || nomePesquisaM2.equals(texto) || nomePesquisaM3.equals(texto) || nomePesquisaM4.equals(texto)){
                nome = marcador.getNome();
                subtitulo = marcador.getSubtitulo();
                latitude = marcador.getLatitude();
                longitude = marcador.getLongitude();
                chamarFragmentResultado(nome, subtitulo, latitude, longitude);
            }
        }

    }

    public void chamarFragmentResultado(String nome, String subtitulo, Double latitude, Double longitude){
        EmpBuscaFragment fragment = EmpBuscaFragment.newInstance(nome);
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", latitude);
        bundle.putDouble("longitude", longitude);
        bundle.putString("titulo", nome);
        bundle.putString("subtitulo", subtitulo);
        fragment.setArguments(bundle);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transactionTer = fragmentManager.beginTransaction();
        transactionTer.replace(R.id.containerPrincipal, fragment);
        transactionTer.commit();
    }


    @Override
    protected void onResume () {
        super.onResume();
        recuperarDadosNav();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            finishAffinity();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        MenuItem item = menu.findItem(R.id.searchHome);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void recuperarDadosNav(){
        //Recuperar do Firebase
        FirebaseUser usuarioFirebase = UsuarioFirebase.getUsuarioAtual();
        Uri url = usuarioFirebase.getPhotoUrl();

        if(url != null){
            Glide.with(HomeActivity.this)
                    .load(url)
                    .into(circleImageView);
        } else {
            circleImageView.setImageResource(R.drawable.circulo_avatar);
            textNomeNav.setText("Usúario");
        }

        textNomeNav.setText(usuarioFirebase.getDisplayName());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_principal:
                break;
            case R.id.nav_empreendimentos:
                Intent intent = new Intent(HomeActivity.this, EmpreendimentosActivity.class);
                startActivity(intent);
                //startActivity(new Intent(HomeActivity.this, EmpreendimentosActivity.class));
                break;
            case R.id.nav_terceiros:
                startActivity(new Intent(HomeActivity.this, TerceirosActivity.class));
                break;
            case R.id.nav_terrenos:
                startActivity(new Intent(HomeActivity.this, TerrenosActivity.class));
                break;
            case R.id.nav_simulador:
                startActivity(new Intent(HomeActivity.this, SimuladorActivity.class));
                break;
            case R.id.nav_duvidas:
                startActivity(new Intent(HomeActivity.this, DuvidasActivity.class));
                break;
            case R.id.nav_configuracoes:
                startActivity(new Intent(HomeActivity.this,ConfiguracoesActivity.class));
                break;
            case R.id.bottom_emp:
                /*Trocando para os Fragment Principal*/
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
                transaction.replace(R.id.containerPrincipal, new MapsActivity()); //Adiciona o Fragment
                transaction.commit(); //Aplica o commit, para verificar se esta tudo certo
                break;
            case R.id.bottom_terceiros:
                /*Trocando para os Fragment de Terceiros*/
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transactionTer = fragmentManager.beginTransaction();
                transactionTer.replace(R.id.containerPrincipal, new TerceirosFragment());
                transactionTer.commit();
                break;
            case R.id.bottom_terrenos:
                /*Trocando para os Fragment de Terrenos*/
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transactionTerrenos = fragmentManager.beginTransaction();
                transactionTerrenos.replace(R.id.containerPrincipal, new TerrenosFragment());
                transactionTerrenos.commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void criarListaMarcadoresBuscas() {

        /*AZM*/
        Marcadores marcadores = new Marcadores("Residencial Vertentes III",
                "vertentes",
                "residencial vertentes",
                "res vertentes",
                "residencial vertentes iii",
                -18.941298,
                -48.348096,
                "Venda: R$129.900,00 a partir");
        listaMarcadores.add(marcadores);

        marcadores = new Marcadores("Residencial Tavares",
                "tavares",
                "res tavares",
                "residencial tav",
                "tavares residencial",
                -18.945764, -48.350587,
                "Venda: R$119.900,00 a partir");
        listaMarcadores.add(marcadores);

        marcadores = new Marcadores("Residencial Vida Boa",
                "vida boa",
                "res vida boa",
                "residencial vida boa",
                "vida boa residencial",
                -18.948985,-48.318978,
                "Venda: R$134.900,00 a partir");
        listaMarcadores.add(marcadores);

        marcadores = new Marcadores("Residencial Flores do Cerrado",
                "flores do cerrado",
                "res flores do cerrado",
                "residencial flores",
                "flores do cerrado residencial",
                -18.965741,-48.339644,
                "Venda: R$109.900,00 a partir");
        listaMarcadores.add(marcadores);

        /*Bari*/
        marcadores = new Marcadores("Evora Residence",
                "evora",
                "evora residencial",
                "evora res",
                "residencial evora",
                -18.923276,-48.233178,
                "Venda: R$310.000,00 a partir");
        listaMarcadores.add(marcadores);

        /*C&A*/
        marcadores = new Marcadores("Plaza Norte Residence",
                "plaza norte",
                "res plaza norte",
                "res plaza",
                "plaza norte res",
                -18.8974186, -48.2784520,
                "Venda: R$189.990,00 a partir");
        listaMarcadores.add(marcadores);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(preferences.getBoolean(primeiraEx,true)){
            ConfiguracaoFirebase configuracaoFirebase = new ConfiguracaoFirebase();
            configuracaoFirebase.getMessagingPatterns();
            preferences.edit().putBoolean(primeiraEx, false).apply();
            Toast.makeText(getApplicationContext(), "Seja bem vindo ao EuCorretor", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }

}
