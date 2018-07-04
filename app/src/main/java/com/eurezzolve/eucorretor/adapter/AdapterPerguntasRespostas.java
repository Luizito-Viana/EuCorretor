package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.PerguntasRespostas;

import java.util.List;

public class AdapterPerguntasRespostas extends RecyclerView.Adapter<AdapterPerguntasRespostas.MyViewHolder> {

    List<PerguntasRespostas> perguntasLista;

    public AdapterPerguntasRespostas(List<PerguntasRespostas> listaPerguntas){
        this.perguntasLista = listaPerguntas;
    }

    public List<PerguntasRespostas> getPerguntasLista() {
        return perguntasLista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemPergunta = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_duvidas_menu,parent,false);
        return new MyViewHolder(itemPergunta);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PerguntasRespostas perguntasRespostas = perguntasLista.get(position);

        holder.pergunta.setText(perguntasRespostas.getPergunta());
    }

    @Override
    public int getItemCount() {
        return perguntasLista != null? perguntasLista.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pergunta;
        //TextView resposta;

        public MyViewHolder(View itemView) {
            super(itemView);
            pergunta = itemView.findViewById(R.id.textViewDuvidasMenuItem);
            //resposta = itemView.findViewById(R.id.textResposta);
        }
    }
}
