package com.eurezzolve.eucorretor.activities.secundarias;

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
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Terceiros;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

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
                    Log.d("DataSnapshot", date);
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
                if(strings == null){
                    Toast.makeText(DescricaoTerceirosActivity.this, "Efetuando carregamento", Toast.LENGTH_SHORT);
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
                if(strings == null){
                    Toast.makeText(DescricaoTerceirosActivity.this, "Efetuando carregamento", Toast.LENGTH_SHORT);
                } else {
                    if(idx < 0 || idx > (strings.size() - 1)){
                        idx = (strings.size() - 1);
                    }
                    Log.d("Numeros", "Antes: " + String.valueOf(idx));
                    String uso = strings.get(idx--);
                    storage = FirebaseStorage.getInstance().getReferenceFromUrl(uso);
                    Glide.with(DescricaoTerceirosActivity.this)
                            .using(new FirebaseImageLoader())
                            .load(storage)
                            .into((ImageView) imageSwitcher.getCurrentView());
                    Log.d("Numeros", "Depois: " + String.valueOf(idx));
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

                break;
            case R.id.menudesc_favoritar:
                Toast.makeText(DescricaoTerceirosActivity.this, "Favoritar ainda não aprimorado", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
        // return super.onOptionsItemSelected(item);
    }

    /*Compartilhar Imagens
    private class CompartilharTask implements TaskListener {
        private final List<String> stringsSelecionadas;

        //Lista para compartilhar
        ArrayList<Uri> imageUris = new ArrayList<Uri>();

        public CompartilharTask(List<String> stringsSelecionadas){
            this.stringsSelecionadas = stringsSelecionadas;
        }


        @Override
        public Object execute() throws Exception {
            if(stringsSelecionadas != null){
                for(String c : stringsSelecionadas){
                    String fileName = c.substring(c.lastIndexOf("/"));
                    //CRIA O ARQUIVO NO SD Card
                    File file = SDCardUtils.getPrivateFile(getApplicationContext(),"Fotos Imoveis", fileName);
                    IOUtils.downloadToFile(c, file);
                    //Salva Uri para compartilhar
                    imageUris.add(Uri.fromFile(file));
                }
            }
            return null;
        }

        @Override
        public void updateView(Object response) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
            shareIntent.setType("image/*");
            startActivity(Intent.createChooser(shareIntent, "Enviar Fotos dos imóveis"));
        }

        @Override
        public void onError(Exception exception) {
            Toast.makeText(DescricaoTerceirosActivity.this, "Ocorreu algum erro ao compartilhar.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancelled(String cod) {

        }
    }*/
}
