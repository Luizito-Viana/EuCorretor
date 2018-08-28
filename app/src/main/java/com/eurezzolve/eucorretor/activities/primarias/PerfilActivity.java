/*
 * Desenvolvido por Luiz F. Viana em 19/08/18 22:41
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.primarias;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.terciarias.AtualizarLoginActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.UsuarioFirebase;
import com.eurezzolve.eucorretor.helper.Base64Custom;
import com.eurezzolve.eucorretor.helper.Permissao;
import com.eurezzolve.eucorretor.model.DadosUsuario;
import com.eurezzolve.eucorretor.model.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity {

    private TextView alterarFoto;

    private CircleImageView imageViewPerfil;
    private TextView textNome, textEmail;
    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
    private String nome, email, telefone, empresa, creci;
    private TextView textAlterar;
    private TextView textTelefone, textCreci, textEmpresa;
    private StorageReference storageReference;

    private static final int SELECAO_GALERIA = 200;

    private String[] permissionRead = new String[]{
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private ProgressBar progressBarPerfil;

    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Meu Perfil");

        //Configurações Iniciais
        storageReference = ConfiguracaoFirebase.getFirebaseStorage();

        //Validar Permissões
        Permissao.validarPermissoes(permissionRead, this, 1);

        textEmail = findViewById(R.id.textEmail);
        textNome = findViewById(R.id.textAvaliacao);
        alterarFoto = findViewById(R.id.alterarFoto);
        imageViewPerfil = findViewById(R.id.circleImageViewFotoPerfil);
        textAlterar = findViewById(R.id.textAlterar);
        textEmpresa = findViewById(R.id.textEmpresa);
        textCreci = findViewById(R.id.textCreci);
        textTelefone = findViewById(R.id.textTelefone);
        progressBarPerfil = findViewById(R.id.progressBarPerfil);
        progressBarPerfil.setVisibility(View.VISIBLE);

        recuperarDados();

        //Recuperar do Firebase
        FirebaseUser usuarioFirebase = UsuarioFirebase.getUsuarioAtual();
        Uri url = usuarioFirebase.getPhotoUrl();

        if(url != null){
            Glide.with(PerfilActivity.this)
                   .load(url)
                    .into(imageViewPerfil);
        } else {
            imageViewPerfil.setImageResource(R.drawable.circulo_avatar);
        }

        textNome.setText("Bem vindo, " + usuarioFirebase.getDisplayName());
    }

    //OnResume
    @Override
    protected void onResume() {
        super.onResume();
        atualizarDados();

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

    //Atualiza os dados
    public void atualizarDados(){
        String emailUsusario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64(emailUsusario);
        final DatabaseReference reference = firebaseRef.child("dadosUsuarios").child(idUsuario);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DadosUsuario dadosUsuario = dataSnapshot.getValue(DadosUsuario.class);
                telefone = dadosUsuario.getTelefone();
                creci = dadosUsuario.getCreci();
                empresa = dadosUsuario.getEmpresa();
                textTelefone.setText("Telefone: " + telefone);
                textCreci.setText("Creci: " + creci);
                textEmpresa.setText("Empresa: " + empresa);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Recupera os dados
    public void recuperarDados(){
        final String emailUsusario = autenticacao.getCurrentUser().getEmail();
        //usuario.setEmail(emailUsusario);
        String idUsuario = Base64Custom.codificarBase64(emailUsusario);
        final DatabaseReference usuarioRef = firebaseRef.child("usuarios").child(idUsuario);
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Usuario usuario = dataSnapshot.getValue(Usuario.class);
                nome = usuario.getNome();
                email = usuario.getEmail();
                //textNome.setText("Bem Vindo, " + nome);
                textEmail.setText(email);
                progressBarPerfil.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Pede permissao para galeria
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int permissaoResultado : grantResults){
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    //AlertDialog
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

    //Troca a foto de perfil
    public void trocarFoto(View view){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i, SELECAO_GALERIA);
        }
    }

    //Abre a galeria
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bitmap imagem = null;
            try{
                switch (requestCode){
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(
                                getContentResolver(), localImagemSelecionada);
                        break;
                }

                if (imagem != null){
                    progressBarPerfil.setVisibility(View.VISIBLE);
                    imageViewPerfil.setImageBitmap(imagem);

                    FirebaseAuth usuario = ConfiguracaoFirebase.getFirebaseAutenticacao();
                    String email = usuario.getCurrentUser().getEmail();
                    String idUsuario = Base64Custom.codificarBase64(email);

                    //Recuperar os dados da imagem para o Firebase
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    imagem.compress(Bitmap.CompressFormat.JPEG, 80, baos);
                    byte[] dadosImagens = baos.toByteArray();

                    //Salvar Imagem no Firebase
                    StorageReference imagemRef = storageReference
                            .child("imagens")
                            .child("perfil")
                            //.child(idUsuario)
                            .child(idUsuario + ".jpeg");

                    UploadTask uploadTask = imagemRef.putBytes(dadosImagens);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(PerfilActivity.this,"Erro ao fazer o upload da imagem", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(PerfilActivity.this,"Sucesso ao fazer o upload da imagem", Toast.LENGTH_SHORT).show();
                            Uri url = taskSnapshot.getDownloadUrl();
                            atualizaFotoUsuario(url);
                            progressBarPerfil.setVisibility(View.GONE);
                        }
                    });
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //Atualiza a foto
    public void atualizaFotoUsuario(Uri url){
        UsuarioFirebase.atualizarFotoUsuario(url);
    }

    //Atualiza o perfil
    public void atualizarPerfil(View view){
        startActivity(new Intent(PerfilActivity.this, AtualizarLoginActivity.class));
    }
}
