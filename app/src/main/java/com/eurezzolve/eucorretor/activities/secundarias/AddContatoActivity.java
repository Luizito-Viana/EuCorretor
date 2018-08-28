/*
 * Desenvolvido por Luiz F. Viana em 20/08/18 08:36
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.GeradorChaveAleatoria;
import com.eurezzolve.eucorretor.model.Clientes;
import com.google.firebase.database.DatabaseReference;

public class AddContatoActivity extends AppCompatActivity {

    private int escolha = 0;
    private Switch switchModelo;
    private EditText editNomeCliente, editTelefoneCliente, editInteresseCliente;
    private FloatingActionButton fabConfirmar;

    private DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase().child("clientes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Adicionar Contato");

        switchModelo = findViewById(R.id.swModeloContato);
        editInteresseCliente = findViewById(R.id.editInteresseCliente);
        editNomeCliente = findViewById(R.id.editNomeCliente);
        editTelefoneCliente = findViewById(R.id.editTelefoneCliente);
        fabConfirmar = findViewById(R.id.fabConfirmarCadastro);

        switchModelo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()) {
                    escolha = 1;
                }
                else {
                    escolha = 0;
                }
            }
        });

        /*Setando on Click Listener*/
        fabConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testarEditTextVazio()){
                    cadastrarCliente(escolha);
                    Toast.makeText(AddContatoActivity.this, "Sucesso ao cadastrar!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    private void cadastrarCliente(int escolhaModelo) {
        Clientes cliente = new Clientes();
        cliente.setNomeCliente(editNomeCliente.getText().toString());
        cliente.setInteresseCliente(editInteresseCliente.getText().toString());
        cliente.setTelefoneCliente(editTelefoneCliente.getText().toString());
        cliente.setModeloCliente(escolhaModelo);

        String codigo = editNomeCliente.getText().toString().toLowerCase();
        codigo = codigo.replace(" ", "_");
        codigo = GeradorChaveAleatoria.geraAleatoria(codigo);

        cliente.setCodigoCliente(codigo);
        cliente.salvar();
    }

    private boolean testarEditTextVazio() {
        if (!editNomeCliente.getText().toString().isEmpty()){
            if(!editTelefoneCliente.getText().toString().isEmpty()){
                if(!editTelefoneCliente.getText().toString().isEmpty()){
                    return true;
                } else {
                    Toast.makeText(AddContatoActivity.this, "Preencha o Interesse do Cliente!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(AddContatoActivity.this, "Preencha o Telefone!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(AddContatoActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
            return false;
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
