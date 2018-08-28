/*
 * Desenvolvido por Luiz F. Viana em 21/08/18 21:45
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class DetalheClienteActivity extends AppCompatActivity {

    private TextView tvNomeCliente, tvInteresseCliente;
    private Button btnTelefoneCliente;
    private String nome, telefone, interesse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        Bundle dados = getIntent().getExtras();
        if(dados != null){
            nome = dados.getString("nomeCliente");
            telefone = dados.getString("telefoneCliente");
            interesse = dados.getString("interesseCliente");
        }

        tvNomeCliente = findViewById(R.id.tvNomeClienteEscolhido);
        tvInteresseCliente = findViewById(R.id.tvInteresseCliente);
        btnTelefoneCliente = findViewById(R.id.btnTelefoneCliente);

        //Seta as informações
        tvNomeCliente.setText(nome);
        tvInteresseCliente.setText(interesse);
        btnTelefoneCliente.setText("Telefone: " + telefone);

        btnTelefoneCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telefone, null));
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
            case R.id.ic_excluir_contato:
                Toast.makeText(DetalheClienteActivity.this, "Clicou no Excluir!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_editar_contato:
                Toast.makeText(DetalheClienteActivity.this, "Clicou no Editar!", Toast.LENGTH_SHORT).show();
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
