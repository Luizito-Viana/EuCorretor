/*
 * Desenvolvido por Luiz F. Viana em 20/08/18 07:53
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Clientes;

import java.util.List;


public class AdapterContatos extends RecyclerView.Adapter<AdapterContatos.MyViewHolder> {

    private List<Clientes> listaContatos;
    private static final int TIPO_PAR = 0;
    private static final int TIPO_IMPAR = 1;

    public AdapterContatos(List<Clientes> listaContatos) {
        this.listaContatos = listaContatos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == TIPO_PAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_contatos,parent,false);
        } else if(viewType == TIPO_IMPAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_contatos_m2, parent, false);
        }
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Clientes cliente = listaContatos.get(position);

        holder.nomeCliente.setText(cliente.getNomeCliente());
    }

    @Override
    public int getItemCount() {
        return listaContatos != null ? listaContatos.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        Clientes cliente = listaContatos.get(position);
        if(cliente.getModeloCliente() == 0)
            return TIPO_PAR;
        else
            return TIPO_IMPAR;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeCliente;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeCliente = itemView.findViewById(R.id.textViewContatosClientes);
        }
    }
}
