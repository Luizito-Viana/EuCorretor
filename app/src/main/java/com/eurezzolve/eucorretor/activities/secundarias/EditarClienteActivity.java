/*
 * Desenvolvido por Luiz F. Viana em 03/09/18 11:30
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.GeradorChaveAleatoria;
import com.eurezzolve.eucorretor.model.Clientes;
import com.github.angads25.toggle.LabeledSwitch;
import com.github.angads25.toggle.interfaces.OnToggledListener;
import com.google.firebase.database.DatabaseReference;

public class EditarClienteActivity extends AppCompatActivity {

    private int escolha = 0;
    private LabeledSwitch switchModelo;
    private EditText editNomeCliente, editTelefoneCliente, editInteresseCliente;
    private FloatingActionButton fabConfirmar;
    private LabeledSwitch swCasado, swCarteira, swFilhos;
    private Clientes clientes;
    private String codigo;

    private DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase().child("clientes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Editar Contato");

        switchModelo = findViewById(R.id.swModeloContatoEditar);
        editInteresseCliente = findViewById(R.id.editInteresseClienteEditar);
        editNomeCliente = findViewById(R.id.editNomeClienteEditar);
        editTelefoneCliente = findViewById(R.id.editTelefoneClienteEditar);
        fabConfirmar = findViewById(R.id.fabConfirmarEdicao);
        swCasado = findViewById(R.id.swCasadoEditar);
        swCarteira = findViewById(R.id.swCarteiraEditar);
        swFilhos = findViewById(R.id.swFilhoEditar);

        /*Busca da activity anterior*/
        Bundle dados = getIntent().getExtras();
        clientes = (Clientes) dados.getSerializable("info");

        if(clientes != null){
            inicializaComponentes();
        }

        switchModelo.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {
                if(labeledSwitch.isEnabled()) {
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
                    Toast.makeText(EditarClienteActivity.this, "Sucesso ao cadastrar!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void inicializaComponentes() {
        codigo = clientes.getCodigoCliente();
        Log.d("EditarClientes", "inicializaComponentes: " + codigo);
        editNomeCliente.setText(clientes.getNomeCliente());
        editTelefoneCliente.setText(clientes.getTelefoneCliente());
        editInteresseCliente.setText(clientes.getInteresseCliente());

        if(clientes.getCasadoCliente().equals("SIM"))
            swCasado.setOn(true);
        else
            swCasado.setOn(false);

        if(clientes.getFilhoMenorIdade().equals("SIM"))
            swFilhos.setOn(true);
        else
            swFilhos.setOn(false);

        if(clientes.getCarteiraAssinada().equals("SIM"))
            swCarteira.setOn(true);
        else
            swCarteira.setOn(false);

        if(clientes.getModeloCliente() == 0){
            switchModelo.setOn(false);
        } else{
            switchModelo.setOn(true);
        }
    }

    private void cadastrarCliente(int escolhaModelo) {
        Clientes cliente = new Clientes();
        cliente.setNomeCliente(editNomeCliente.getText().toString());
        cliente.setInteresseCliente(editInteresseCliente.getText().toString());
        cliente.setTelefoneCliente(editTelefoneCliente.getText().toString());
        cliente.setModeloCliente(escolhaModelo);
        cliente.setCarteiraAssinada(swCarteira.isOn() ? "SIM" : "NÃO");
        cliente.setCasadoCliente(swCasado.isOn() ? "SIM" : "NÃO");
        cliente.setFilhoMenorIdade(swFilhos.isOn() ? "SIM" : "NÃO");

        cliente.setCodigoCliente(codigo);
        cliente.salvar();
    }

    private boolean testarEditTextVazio() {
        if (!editNomeCliente.getText().toString().isEmpty()){
            if(!editTelefoneCliente.getText().toString().isEmpty()){
                if(!editTelefoneCliente.getText().toString().isEmpty()){
                    return true;
                } else {
                    Toast.makeText(EditarClienteActivity.this, "Preencha o Interesse do Cliente!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(EditarClienteActivity.this, "Preencha o Telefone!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(EditarClienteActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
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
