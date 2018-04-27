package com.eurezzolve.eucorretor.activities.secundarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Terceiros;

public class DescricaoTerceirosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Terceiros terceiros;

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
                Toast.makeText(DescricaoTerceirosActivity.this, "Compartilhar ainda não aprimorado", Toast.LENGTH_SHORT).show();
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
}
