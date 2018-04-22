package com.eurezzolve.eucorretor.activities.introducao;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.UsuarioFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.eurezzolve.eucorretor.model.DadosUsuario;
import com.eurezzolve.eucorretor.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button buttonCadastar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;
    private CheckBox checkBox;
    private DadosUsuario dadosUsuario;
    private ProgressBar progressBarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Encontrando as estruturas acima definidas
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmailLogin);
        campoSenha = findViewById(R.id.editSenhaLogin);
        buttonCadastar = findViewById(R.id.btAceitarCadastro);
        checkBox = findViewById(R.id.checkTermos);
        progressBarCadastro = findViewById(R.id.progressBarCadastro);
        progressBarCadastro.setVisibility(View.GONE);

        //Efetuando uma ação ao clicar no Botão Cadastrar
        buttonCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se o CheckBox (Aceito os termos de Uso) estiver marcado executa o cadastro
                if (checkBox.isChecked()) {
                    String textoNome = campoNome.getText().toString();
                    String textoEmail = campoEmail.getText().toString();
                    String textoSenha = campoSenha.getText().toString();
                    //Validar se os campos foram ou não preenchidos
                    if (!textoNome.isEmpty()) {
                        if (!textoEmail.isEmpty()) {
                            if (!textoSenha.isEmpty()) {
                                usuario = new Usuario();
                                usuario.setNome(textoNome);
                                usuario.setEmail(textoEmail);
                                usuario.setSenha(textoSenha);
                                progressBarCadastro.setVisibility(View.VISIBLE);
                                cadastrarUsuario();
                            } else {
                                Toast.makeText(CadastroActivity.this, "Preencha a Senha!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CadastroActivity.this, "Preencha o Email!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CadastroActivity.this, "Preencha o Nome!", Toast.LENGTH_SHORT).show();
                    }
                } else { //Caso contrario ele não aceita
                    Toast.makeText(CadastroActivity.this, "Termos de Uso não foram aceitos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Funcao que cadastra o usuario
    public void cadastrarUsuario(){
        //final FirebaseUser user = ConfiguracaoFirebase.getFirebaseAutenticacao().getCurrentUser();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String idUsuario = Base64Custom.codificarBase64(usuario.getEmail());
                    usuario.setIdUsuario(idUsuario);
                    usuario.salvar();
                    dadosUsuario = new DadosUsuario();
                    dadosUsuario.setCreci("");
                    dadosUsuario.setEmpresa("");
                    dadosUsuario.setTelefone("");
                    dadosUsuario.salvar();
                    //enviarEmailVerificacao();
                    UsuarioFirebase.atualizarNomeUsuario(usuario.getNome());
                    progressBarCadastro.setVisibility(View.GONE);
                    startActivity(new Intent(CadastroActivity.this, HomeActivity.class));
                } else {
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Por favor, digite um e-mail válido";
                    }catch (FirebaseAuthUserCollisionException e){
                        excecao = "Esta conta já foi cadastrada";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this,excecao,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
