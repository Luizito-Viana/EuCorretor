package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.eurezzolve.eucorretor.activities.introducao.MainActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.UsuarioFirebase;
import com.eurezzolve.eucorretor.fragments.MapsActivity;
import com.eurezzolve.eucorretor.fragments.TerceirosFragment;
import com.eurezzolve.eucorretor.fragments.TerrenosFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener
{

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

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
        transaction.add(R.id.containerPrincipal, new MapsActivity(), "MapsFragment"); //Adiciona o Fragment
        transaction.commit(); //Aplica o commit, para verificar se esta tudo certo

        preferences = getSharedPreferences(primeiraEx, MODE_PRIVATE);

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
            case R.id.nav_tabelas:
                startActivity(new Intent(HomeActivity.this, TabelasActivity.class));
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
                //Toast.makeText(HomeActivity.this, "Bottom Empreendimento Clidado", Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction(); //Responsavel por iniciar
                transaction.replace(R.id.containerPrincipal, new MapsActivity()); //Adiciona o Fragment
                transaction.commit(); //Aplica o commit, para verificar se esta tudo certo
                break;
            case R.id.bottom_terceiros:
                //Troca de Fragment
                //Toast.makeText(HomeActivity.this, "Bottom Terceiros Clidado", Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transactionTer = fragmentManager.beginTransaction();
                transactionTer.replace(R.id.containerPrincipal, new TerceirosFragment());
                transactionTer.commit();
                break;
            case R.id.bottom_terrenos:
                //Toast.makeText(HomeActivity.this, "Bottom Terrenos Clidado", Toast.LENGTH_SHORT).show();
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
