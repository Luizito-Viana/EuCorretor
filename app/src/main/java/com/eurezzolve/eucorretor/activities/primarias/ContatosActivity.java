/*
 * Desenvolvido por Luiz F. Viana em 19/08/18 22:41
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.primarias;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.secundarias.AddContatoActivity;
import com.eurezzolve.eucorretor.activities.secundarias.DetalheClienteActivity;
import com.eurezzolve.eucorretor.adapter.AdapterContatos;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.RecyclerItemClickListener;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.eurezzolve.eucorretor.model.Clientes;
import com.eurezzolve.eucorretor.model.Config;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ContatosActivity extends AppCompatActivity {

    private RecyclerView recyclerContatos;
    private FloatingActionButton fabAddContatos;

    private AdapterContatos adapterContatos;

    private List<Clientes> listaClientes = new ArrayList<>();

    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private DatabaseReference contatosRef;

    private ValueEventListener valueEventListenerContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Meus Contatos");

        recyclerContatos = findViewById(R.id.recyclerContatos);
        fabAddContatos = findViewById(R.id.fabAddContato);

        //Configurar Adapter
        adapterContatos = new AdapterContatos(listaClientes);

        //Configuração adicional
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerContatos.setLayoutManager(layoutManager);
        recyclerContatos.setHasFixedSize(true);
        recyclerContatos.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerContatos.setAdapter(adapterContatos);

        fabAddContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContatosActivity.this, AddContatoActivity.class));
            }
        });

        recyclerContatos.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerContatos,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Clientes cliente = listaClientes.get(position);
                        Intent intent = new Intent(ContatosActivity.this, DetalheClienteActivity.class);
                        intent.putExtra("nomeCliente", cliente.getNomeCliente());
                        intent.putExtra("telefoneCliente", cliente.getTelefoneCliente());
                        intent.putExtra("interesseCliente", cliente.getInteresseCliente());
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
;
    }

    private void recuperarContatos() {
        listaClientes.clear();

        String emailUsuario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64( emailUsuario );
        contatosRef = firebaseRef.child("clientes")
                                 .child(idUsuario);

        //contatosRef.orderByChild("nomeCliente");


        valueEventListenerContatos = contatosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Clientes cliente = ds.getValue(Clientes.class);
                    listaClientes.add(cliente);
                }
                adapterContatos.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperarContatos();
    }

    @Override
    protected void onStop() {
        super.onStop();
        contatosRef.removeEventListener(valueEventListenerContatos);
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
