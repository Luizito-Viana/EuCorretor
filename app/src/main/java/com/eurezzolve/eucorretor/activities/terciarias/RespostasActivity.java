package com.eurezzolve.eucorretor.activities.terciarias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;

public class RespostasActivity extends AppCompatActivity {

    private TextView textPergunta;
    private TextView textReposta;
    String pergunta, resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respostas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        textPergunta = findViewById(R.id.textViewActRespostaPergunta);
        textReposta = findViewById(R.id.textViewActivityRespostaResposta);

        Bundle dados = getIntent().getExtras();
        pergunta = dados.getString("pergunta");
        resposta = dados.getString("resposta");

        textPergunta.setText(pergunta);
        textReposta.setText(resposta);
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
