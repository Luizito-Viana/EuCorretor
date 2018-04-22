package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Financiamento;

import java.util.List;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class AdapterFinanciamento extends RecyclerView.Adapter<AdapterFinanciamento.MyViewHolder>{

    private List<Financiamento> financiamentoLista;

    public AdapterFinanciamento(List<Financiamento> listaFinanciamento) {
        this.financiamentoLista = listaFinanciamento;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemFinanciamento = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_question, parent, false);
        return new MyViewHolder(itemFinanciamento);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Financiamento financiamento = financiamentoLista.get(position);
        holder.pergunta.setText(financiamento.getPergunta());
        holder.resposta.setText(financiamento.getResposta());

    }

    @Override
    public int getItemCount() {
        return financiamentoLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pergunta;
        TextView resposta;

        public MyViewHolder(View itemView) {
            super(itemView);
            pergunta = itemView.findViewById(R.id.textPergunta);
            resposta = itemView.findViewById(R.id.textResposta);
        }
    }
}

