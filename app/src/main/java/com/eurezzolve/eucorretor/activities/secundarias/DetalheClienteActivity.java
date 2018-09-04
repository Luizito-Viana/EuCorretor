/*
 * Desenvolvido por Luiz F. Viana em 21/08/18 21:45
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.eurezzolve.eucorretor.model.Clientes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetalheClienteActivity extends AppCompatActivity {

    private TextView tvNomeCliente, tvInteresseCliente, tvCasadoCliente, tvFilhosCliente, tvCarteiraCliente;
    private Button btnTelefoneCliente;
    private CircleImageView imageCliente;
    private Clientes cliente;
    private String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        Bundle dados = getIntent().getExtras();
        if(dados != null){
            cliente = (Clientes) dados.getSerializable("cliente");
        }

        tvNomeCliente = findViewById(R.id.tvNomeClienteEscolhido);
        tvInteresseCliente = findViewById(R.id.tvInteresseCliente);
        tvCasadoCliente = findViewById(R.id.tvClienteCasado);
        tvFilhosCliente = findViewById(R.id.tvFilhosCliente);
        tvCarteiraCliente = findViewById(R.id.tvCarteiraAssinadaCliente);
        btnTelefoneCliente = findViewById(R.id.btnTelefoneCliente);
        imageCliente = findViewById(R.id.circleImageCliente);

        //Seta as informações
        codigo = cliente.getCodigoCliente();

        if(cliente.getModeloCliente() == 0){
            imageCliente.setImageResource(R.color.contatoAzul);
        } else {
            imageCliente.setImageResource(R.color.contatoVermelho);
        }

        tvNomeCliente.setText(cliente.getNomeCliente());
        tvCasadoCliente.setText("Cliente é casado? " + cliente.getCasadoCliente());
        tvFilhosCliente.setText("Possui filhos menor de idade? " + cliente.getFilhoMenorIdade());
        tvCarteiraCliente.setText("3(+) anos de carteira assinada? " + cliente.getCarteiraAssinada());
        tvInteresseCliente.setText(cliente.getInteresseCliente());
        btnTelefoneCliente.setText("Telefone: " + cliente.getTelefoneCliente());

        btnTelefoneCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", cliente.getTelefoneCliente(), null));
                startActivity(callIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contatos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.ic_editar_contato:
                Intent i = new Intent(DetalheClienteActivity.this, EditarClienteActivity.class);
                i.putExtra("info", cliente);
                startActivity(i);
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
