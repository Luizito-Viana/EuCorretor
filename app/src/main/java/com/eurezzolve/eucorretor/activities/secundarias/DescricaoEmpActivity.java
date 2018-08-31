/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:57
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.activities.secundarias;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import livroandroid.lib.utils.IOUtils;
import livroandroid.lib.utils.SDCardUtils;

public class DescricaoEmpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Empreendimentos empreendimentos;
    private ImageView imageView;

    /*Elementos de descricao*/
    //private ImageSwitcher imageSwitcher;
    private CarouselView carouselView;
    private int idx = 0;
    private TextView textInfo, textLocalizacao, textDescricaoEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_empreendimentos);

        /*Recuperação dos Dados enviados pela Activity anterior*/
        empreendimentos = (Empreendimentos) getIntent().getSerializableExtra("info");
        /*Fim da Recuperação dos dados*/

        if(empreendimentos != null){
            String nome = empreendimentos.getNome();
            toolbar = findViewById(R.id.toolbarDescEmp);
            toolbar.setTitle(nome);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            imageView = findViewById(R.id.imageDescEmp);
            textInfo = findViewById(R.id.textInfoEmp);
            textLocalizacao = findViewById(R.id.textInfoLocalizacao);
            textDescricaoEmp = findViewById(R.id.textInfoDescEmp);
            carouselView = findViewById(R.id.carouselView);

            if(empreendimentos.getImagem() == 0){
                imageView.setImageResource(R.drawable.avatar_empreendimento);
            } else {
                imageView.setImageResource(empreendimentos.getImagem());
            }

            /*TextInfo padronizado*/
            textInfo.setText(empreendimentos.getDescricaoImovel());
            textDescricaoEmp.setText(empreendimentos.getDescricaoEmp());
            textLocalizacao.setText(empreendimentos.getLocalizacao());

            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    String urlString = empreendimentos.getListaImagens().get(position);
                    Picasso.get().load(urlString).into(imageView);
                }
            };

            carouselView.setPageCount(empreendimentos.getListaImagens().size());
            carouselView.setImageListener(imageListener);

            /*Setando eventos de clique nos buttons*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_desc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.menudesc_compartilhar:
                if(empreendimentos.getListaImagens().isEmpty()){
                    Toast.makeText(DescricaoEmpActivity.this, "Aguarde carregamento das imagens", Toast.LENGTH_SHORT).show();
                } else {
                    alertaDeConfirmacao();
                }
                break;
            default:
                break;
        }
        return true;
    }

    private void alertaDeConfirmacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Compartilhar as imagens");
        builder.setMessage("Deseja compartilhar as imagens desse imóvel?");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DescricaoEmpActivity.AsyncTasksImagens imagens = new DescricaoEmpActivity.AsyncTasksImagens(empreendimentos.getListaImagens());
                imagens.execute();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DescricaoEmpActivity.this, "Evento cancelado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /*Compartilhar Imagens*/
    private class AsyncTasksImagens extends AsyncTask<List<String>, Void, ArrayList<Uri>> {

        private ArrayList<Uri> imageUris = new ArrayList<Uri>();
        private final List<String> listaSelecionada;
        private ProgressDialog dialog;

        public AsyncTasksImagens(List<String> listaSelecionada){
            this.listaSelecionada = listaSelecionada;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(DescricaoEmpActivity.this);
            dialog.setMessage("Salvando imagens, aguarde...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(false);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Uri> doInBackground(List<String>... voids) {
            for (String s : listaSelecionada){
                String url = s;
                String filename = url.substring(url.lastIndexOf("/"));
                /*Cria o arquivo no SD Card*/
                File file = SDCardUtils.getPrivateFile(DescricaoEmpActivity.this, "imagens.jpeg", filename);
                IOUtils.downloadToFile(s, file);
                /*Salva para comparilhar a foto*/
                imageUris.add(FileProvider.getUriForFile(DescricaoEmpActivity.this, getApplicationContext().getPackageName() + ".provider", file));
            }
            return imageUris;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList<Uri> imagens) {
            dialog.setMessage("Imagens salvas!");
            dialog.dismiss();
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imagens);
            shareIntent.setType("image/*");
            startActivity(Intent.createChooser(shareIntent, "Enviar Imagens"));
            super.onPostExecute(imagens);
        }

    }
}
