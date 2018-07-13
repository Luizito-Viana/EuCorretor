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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Terceiros;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

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
    private ImageSwitcher imageSwitcher;
    private int idx = 0;
    private ImageButton btAnterior, btProxima;
    private TextView textInfo, textLocalizacao;
    private DatabaseReference imoveisRef = ConfiguracaoFirebase.getFirebaseDatabase().child("emp");
    private StorageReference storage;

    /*Lista Imagens*/
    private List<String> listaStrings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_empreendimentos);
        /*Recuperação dos Dados enviados pela Activity anterior*/
         empreendimentos = (Empreendimentos) getIntent().getSerializableExtra("info");
        /*Fim da Recuperação dos dados*/

        String nome = empreendimentos.getNome();
        toolbar = findViewById(R.id.toolbarDescEmp);
        toolbar.setTitle(nome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        imageView = findViewById(R.id.imageDescEmp);

        if(empreendimentos.getImagem() == 0){
            imageView.setImageResource(R.drawable.avatar_empreendimento);
        } else {
            imageView.setImageResource(empreendimentos.getImagem());
        }

        /*TextInfo padronizado*/
        textInfo = findViewById(R.id.textInfoEmp);
        if(empreendimentos.getDescricao().equals("")){
            textInfo.setText("Descrição do Imovel nula");
        } else if (empreendimentos.getDescricao().isEmpty()){
            textInfo.setText("Descrição do Imovel nula");
        }
        else {
            textInfo.setText(empreendimentos.getDescricao());
        }
        textLocalizacao = findViewById(R.id.textInfoLocalizacao);
        textLocalizacao.setText(empreendimentos.getLocalizacao());

        /*ImageSwuitcher*/
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcherDescEmp);
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
        imageSwitcher.setImageResource(R.drawable.avatar_empreendimento);

        btAnterior = (ImageButton) findViewById(R.id.imageButtonAnteriorEmp);
        btProxima = (ImageButton) findViewById(R.id.imageButtonProximaEmp);

        /*Recupera a lista de Urls com os endereços das imagens na WEB*/
        recuperarUrls();

        /*Setando eventos de clique nos buttons*/
        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listaStrings.isEmpty()){
                    Toast.makeText(DescricaoEmpActivity.this, "Efetuando carregamento, tente novamente", Toast.LENGTH_SHORT).show();
                    recuperarUrls();
                } else {
                    if(idx == listaStrings.size()){
                        idx = 0;
                    }  else if (idx < 0){
                        idx = 0;
                    }
                    String uso = listaStrings.get(idx++);
                    storage = FirebaseStorage.getInstance().getReferenceFromUrl(uso);
                    Glide.with(DescricaoEmpActivity.this)
                            .using(new FirebaseImageLoader())
                            .load(storage)
                            .into((ImageView) imageSwitcher.getCurrentView());
                }
            }
        });

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listaStrings.isEmpty()){
                    Toast.makeText(DescricaoEmpActivity.this, "Efetuando carregamento, tente novamente", Toast.LENGTH_SHORT).show();
                    recuperarUrls();
                } else {
                    if(idx < 0 || idx > (listaStrings.size() - 1)){
                        idx = (listaStrings.size() - 1);
                    }
                    Log.d("Numeros", "Antes: " + String.valueOf(idx));
                    String uso = listaStrings.get(idx--);
                    storage = FirebaseStorage.getInstance().getReferenceFromUrl(uso);
                    Glide.with(DescricaoEmpActivity.this)
                            .using(new FirebaseImageLoader())
                            .load(storage)
                            .into((ImageView) imageSwitcher.getCurrentView());
                    Log.d("Numeros", "Depois: " + String.valueOf(idx));
                }
            }
        });

    }

    public void recuperarUrls(){
        /*Recupera as imagens*/
        String construtoraCodigo = empreendimentos.getCodigoConst();
        String codigo = empreendimentos.getCodigo();
        imoveisRef.child(construtoraCodigo).child(codigo).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String date = ds.getValue(String.class);
                    listaStrings.add(date);
                }
                Log.d("Booleanos", "Retorno: " + listaStrings);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
                if(listaStrings.isEmpty()){
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
                DescricaoEmpActivity.AsyncTasksImagens imagens = new DescricaoEmpActivity.AsyncTasksImagens(listaStrings);
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
