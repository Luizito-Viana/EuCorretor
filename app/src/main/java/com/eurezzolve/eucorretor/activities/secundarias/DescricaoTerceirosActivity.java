package com.eurezzolve.eucorretor.activities.secundarias;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.primarias.DuvidasActivity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Terceiros;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import livroandroid.lib.fragment.BaseFragment;
import livroandroid.lib.task.TaskListener;
import livroandroid.lib.utils.IOUtils;
import livroandroid.lib.utils.SDCardUtils;

public class DescricaoTerceirosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Terceiros terceiros;
    private ImageSwitcher imageSwitcher;
    private int idx = 0;
    private ImageButton btProxima, btAnterior;
    private TextView textInfo;
    private ImageView imageThumb;
    private DatabaseReference imoveisRef = ConfiguracaoFirebase.getFirebaseDatabase().child("terceiros").child("luizimovel");
    private List<String> strings = new ArrayList<>();
    private StorageReference storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_terceiros);

        /*Recuperação dos Dados enviados pela Activity anterior*/
        terceiros = (Terceiros) getIntent().getSerializableExtra("info");
        /*Fim da Recuperação dos dados*/

        String nome = terceiros.getNome();
        toolbar = findViewById(R.id.toolbarDescTerceiros);
        toolbar.setTitle(nome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        /*Verificação se há uma foto*/
        imageThumb = (ImageView) findViewById(R.id.imageDescTerceiro);
        if(terceiros.getImageThumb() == 0){
            imageThumb.setImageResource(R.drawable.avatar_terceiros);
        } else {
            imageThumb.setImageResource(terceiros.getImageThumb());
        }

        textInfo = (TextView) findViewById(R.id.textInfoEmp);
        textInfo.setText(terceiros.padronizarDescricaoTerceiros());

        /*Configurar o ImageSwitcher e as animações*/
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcherDescTerceiros);
        imageSwitcher.setFactory(new ImageSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView img = new ImageView(getBaseContext());
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT,ImageSwitcher.LayoutParams.MATCH_PARENT ));
                return img;
            }
        });
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        imageSwitcher.setImageResource(R.drawable.avatar_terceiros);

        btProxima = (ImageButton) findViewById(R.id.imageButtonProxima);
        btAnterior = (ImageButton) findViewById(R.id.imageButtonAnterior);

        /*Recupera os dados das imagens*/
        imoveisRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String date = ds.getValue(String.class);
                    //Log.d("DataSnapshot", date);
                    strings.add(date);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*Verificacao de Clique em proxima e Anterior*/
        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strings.isEmpty()){
                    Toast.makeText(DescricaoTerceirosActivity.this, "Efetuando carregamento", Toast.LENGTH_SHORT).show();
                } else {
                    if(idx == strings.size()){
                        idx = 0;
                    }  else if (idx < 0){
                        idx = 0;
                    }
                    String uso = strings.get(idx++);
                    storage = FirebaseStorage.getInstance().getReferenceFromUrl(uso);
                    Glide.with(DescricaoTerceirosActivity.this)
                            .using(new FirebaseImageLoader())
                            .load(storage)
                            .into((ImageView) imageSwitcher.getCurrentView());
                }

            }
        });

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strings.isEmpty()){
                    Toast.makeText(DescricaoTerceirosActivity.this, "Efetuando carregamento", Toast.LENGTH_SHORT).show();
                } else {
                    if(idx < 0 || idx > (strings.size() - 1)){
                        idx = (strings.size() - 1);
                    }
                    String uso = strings.get(idx--);
                    storage = FirebaseStorage.getInstance().getReferenceFromUrl(uso);
                    Glide.with(DescricaoTerceirosActivity.this)
                            .using(new FirebaseImageLoader())
                            .load(storage)
                            .into((ImageView) imageSwitcher.getCurrentView());
                }
            }
        });
        /*Fim da Verificação*/
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
                if(strings.isEmpty()){
                    Toast.makeText(DescricaoTerceirosActivity.this, "Aguarde carregamento das imagens", Toast.LENGTH_SHORT).show();
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
        builder.setMessage("Deseja compartilhar as imagenns desse imóvel?");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AsyncTasksImagens imagens = new AsyncTasksImagens(strings);
                imagens.execute();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DescricaoTerceirosActivity.this, "Evento cancelado", Toast.LENGTH_SHORT).show();
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
            dialog = new ProgressDialog(DescricaoTerceirosActivity.this);
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
                File file = SDCardUtils.getPrivateFile(DescricaoTerceirosActivity.this, "imagens.jpeg", filename);
                IOUtils.downloadToFile(s, file);
                /*Salva para comparilhar a foto*/
                imageUris.add(FileProvider.getUriForFile(DescricaoTerceirosActivity.this, getApplicationContext().getPackageName() + ".provider", file));
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
