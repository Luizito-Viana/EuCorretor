package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Terceiros;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DescricaoEmpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Empreendimentos empreendimentos;
    private ImageView imageView;

    /*Elementos de descricao*/
    private ImageSwitcher imageSwitcher;
    private int idx = 0;
    private ImageButton btAnterior, btProxima;
    private TextView textInfo;
    private DatabaseReference imoveisRef = ConfiguracaoFirebase.getFirebaseDatabase().child("empreendimentos");

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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*Setando eventos de clique nos buttons*/
        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DescricaoEmpActivity.this, "Ainda não adicionado as Imagens no BD", Toast.LENGTH_SHORT).show();
            }
        });

        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DescricaoEmpActivity.this, "Ainda não adicionado as Imagens no BD", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(DescricaoEmpActivity.this, "Compartilhar ainda não aprimorado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menudesc_favoritar:
                Toast.makeText(DescricaoEmpActivity.this, "Favoritar ainda não aprimorado", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
        // return super.onOptionsItemSelected(item);
    }
}
