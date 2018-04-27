package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Terceiros;

public class DescricaoEmpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Empreendimentos empreendimentos;
    private ImageView imageView;

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
