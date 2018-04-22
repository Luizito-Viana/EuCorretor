package com.eurezzolve.eucorretor.activities.introducao;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.helper.Permissao;
import com.eurezzolve.eucorretor.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class LoginActivity extends AppCompatActivity {

    private String[] permissionLocalizacao = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    public static final String TAG = "LOG";
    public static final int REQUEST_PERMISSIONS_CODE = 128;

    private TextInputEditText campoEmail;
    private TextInputEditText campoSenha;

    private TextInputLayout textEmailLayout;
    private TextInputLayout textSenhaLayout;

    //private EditText campoEmail, campoSenha;
    private Button buttonEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    private ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editEmailLogin);
        campoSenha = findViewById(R.id.editSenhaLogin);

        textEmailLayout = findViewById(R.id.textInputEmailLogin);
        textSenhaLayout = findViewById(R.id.textInputSenhaLogin);

        progressBarLogin = findViewById(R.id.progressBarLogin);
        buttonEntrar = findViewById(R.id.buttonEntrar);

        progressBarLogin.setVisibility(View.GONE);

        Permissao.validarPermissoes(permissionLocalizacao, this, 1);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if(!textoEmail.isEmpty()){
                    textSenhaLayout.setErrorEnabled(false);
                    if(!textoSenha.isEmpty()){
                        textSenhaLayout.setErrorEnabled(false);
                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        progressBarLogin.setVisibility(View.VISIBLE); // ativa a progressBAR
                        validarLogin();
                    }else{
                        textSenhaLayout.setErrorEnabled(true);
                        textSenhaLayout.setError("Digite a Senha");
                        //Toast.makeText(LoginActivity.this,"Preencha a Senha!",Toast.LENGTH_SHORT).show();
                    }
                } else{
                    textEmailLayout.setErrorEnabled(true);
                    textEmailLayout.setError("Digite o Email");
                    //Toast.makeText(LoginActivity.this,"Preencha o Email!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*private boolean validateForm(){
        boolean validadorEmail = false;
        boolean validadorSenha = false;
        if(campoEmail.getText().toString().isEmpty()){
            textEmailLayout.setErrorEnabled(true);
            textEmailLayout.setError("Digite o Email");
            validadorEmail = true;
        } else {
            textEmailLayout.setErrorEnabled(false);
            validadorEmail = false;
        }
        //Verifica se a senha esta vazia
        if(campoSenha.getText().toString().isEmpty()){
            textSenhaLayout.setErrorEnabled(true);
            textSenhaLayout.setError("Digite a Senha");
            validadorSenha = true;
        } else {
            textSenhaLayout.setErrorEnabled(false);
            validadorSenha = false;
        }
        if(validadorEmail == true && validadorSenha == true){
            return true;
        }
        return false;
    }*/

    //Validar Login do Usuario
    public void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBarLogin.setVisibility(View.GONE);
                    abrirTelaPrincipal();
                }else{
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuário não cadastrado!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Um dos campos está incorreto!";
                    } catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this,excecao,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Pede permissão para o usuario para acessar Localizacao
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        for (int permissaoResultado : grantResults){
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //Cria o AlertDialog
    private void alertaValidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar o aplicativo, é necessário aceitar as permissões");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //Abre a activity de recuperar a senha
    public void abrirEsqueceuSenha(View view){
        startActivity(new Intent(this, ResetActivity.class));
    }

    //Abre a activity principal
    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
