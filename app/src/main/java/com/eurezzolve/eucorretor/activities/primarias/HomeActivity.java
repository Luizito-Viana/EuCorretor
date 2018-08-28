/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:39
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.primarias;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
import com.eurezzolve.eucorretor.model.Marcadores;
import com.google.firebase.auth.FirebaseUser;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
                 /*Trocando para o Fragment de BUSCA*/
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
                verificarEnderecoExistente(query);
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

    }

    private void verificarEnderecoExistente(String enderecoDestino) {
        if(!enderecoDestino.equals("") || enderecoDestino != null){
            Address addressDestino = recuperarEndereco (enderecoDestino);
            if( addressDestino != null ){
                final Marcadores marcadores = new Marcadores();
                marcadores.setCidade( addressDestino.getAdminArea() );
                marcadores.setCep( addressDestino.getPostalCode() );
                marcadores.setBairro( addressDestino.getSubLocality() );
                marcadores.setRua( addressDestino.getThoroughfare() );
                marcadores.setNumero( addressDestino.getFeatureName() );
                marcadores.setLatitude( String.valueOf(addressDestino.getLatitude()) );
                marcadores.setLongitude( String.valueOf(addressDestino.getLongitude()) );

                StringBuilder mensagem = new StringBuilder();
                mensagem.append( "Cidade: " + marcadores.getCidade() );
                mensagem.append( "\nRua: " + marcadores.getRua() );
                mensagem.append( "\nBairro: " + marcadores.getBairro() );
                mensagem.append( "\nNúmero: " + marcadores.getNumero() );
                mensagem.append( "\nCep: " + marcadores.getCep() );

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("Confirme o endereco!")
                        .setMessage(mensagem)
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                chamarFragmentEndereco(marcadores);


                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }
    }

    private void chamarFragmentEndereco(Marcadores marcadores) {
        EmpBuscaFragment fragment = EmpBuscaFragment.newInstance("Trocando Fragment");
        Bundle bundle = new Bundle();
        bundle.putDouble("longitude", Double.parseDouble(marcadores.getLongitude()));
        bundle.putDouble("latitude", Double.parseDouble(marcadores.getLatitude()));
        bundle.putString("titulo", marcadores.getRua());
        bundle.putString("subtitulo", marcadores.getBairro());
        fragment.setArguments(bundle);


        FragmentTransaction transactionTer = getSupportFragmentManager().beginTransaction();
        transactionTer.replace(R.id.containerPrincipal, fragment);
        transactionTer.commit();
    }

    private Address recuperarEndereco(String enderecoDestino) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> listaEnderecos = geocoder.getFromLocationName(enderecoDestino, 1);
            if( listaEnderecos != null && listaEnderecos.size() > 0){
                Address address = listaEnderecos.get(0);

                return address;
            }
        } catch (Exception e) {
            Toast.makeText(HomeActivity.this, "Não foi possível recuperar o endereço!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return null;
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
            case R.id.nav_perfil:
                startActivity(new Intent(HomeActivity.this, PerfilActivity.class));
                break;
            case R.id.nav_contatos:
                startActivity(new Intent(HomeActivity.this, ContatosActivity.class));
                break;
            case R.id.nav_empreendimentos:
                startActivity(new Intent(HomeActivity.this, EmpreendimentosActivity.class));
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
