/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:58
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Valores;

import java.util.List;

/**
 * Created by viana_2 on 29/04/2018.
 */

public class AdapterValores extends RecyclerView.Adapter<AdapterValores.MyViewHolder> {

    List<Valores> valoresLista;
    Context context;
    private static final int TIPO_PAR = 0;
    private static final int TIPO_IMPAR = 1;

    public AdapterValores(List<Valores> listaValores, Context context) {
        this.valoresLista = listaValores;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == TIPO_PAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_informacoes_modelodois, parent, false);
        } else if (viewType == TIPO_IMPAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_informacoes, parent, false);
        }
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Valores valores = valoresLista.get(position);
        holder.andar.setText(valores.getAndar());
        holder.avaliacao.setText(valores.getAvaliacao());
        holder.venda.setText(valores.getVenda());
    }

    @Override
    public int getItemCount() {
        return valoresLista.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TIPO_PAR;
        } else if(position%2 == 0){
            return TIPO_PAR;
        }
        return TIPO_IMPAR;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView andar;
        TextView avaliacao;
        TextView venda;

        public MyViewHolder(View itemView) {
            super(itemView);
            andar = itemView.findViewById(R.id.textAndarAdapter);
            avaliacao = itemView.findViewById(R.id.textAvaliacaoAdapter);
            venda = itemView.findViewById(R.id.textVendaAdapter);
        }
    }
}
