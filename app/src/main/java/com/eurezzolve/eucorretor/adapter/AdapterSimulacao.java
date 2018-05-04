package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Simulacao;

import java.util.List;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class AdapterSimulacao extends RecyclerView.Adapter<AdapterSimulacao.MyViewHolder>{

    private List<Simulacao> simulacaoLista;

    public AdapterSimulacao(List<Simulacao> listaSimulacao) {
        this.simulacaoLista = listaSimulacao;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemSimulacao = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_auxiliar,parent,false);
        return new MyViewHolder(itemSimulacao);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Simulacao simulacao = simulacaoLista.get(position);

        holder.pergunta.setText(simulacao.getPergunta());
        holder.resposta.setText(simulacao.getResposta());

    }

    @Override
    public int getItemCount() {
        return simulacaoLista != null? simulacaoLista.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pergunta;
        TextView resposta;

        public MyViewHolder(View itemView) {
            super(itemView);
            pergunta = itemView.findViewById(R.id.textPergunta);
            resposta = itemView.findViewById(R.id.textResposta);
        }
    }
}
