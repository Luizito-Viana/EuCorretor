package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Empreendimentos;

import java.util.List;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class AdapterEmp extends RecyclerView.Adapter<AdapterEmp.MyViewHoler> {

    private static final int MODELO_UM = 0;
    private static final int MODELO_DOIS = 1;

    private List<Empreendimentos> listaEmpreendimentos;

    public AdapterEmp(List<Empreendimentos> empreendimentosLista){
        this.listaEmpreendimentos = empreendimentosLista;
    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemListaEmpreendimentos = null;
        if(viewType == MODELO_UM){
            itemListaEmpreendimentos = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_tabela, parent, false);
        } else if (viewType == MODELO_DOIS){
            itemListaEmpreendimentos = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_tabela_modelodois, parent, false);
        }
        return new MyViewHoler(itemListaEmpreendimentos);
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, int position) {
        Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
        if(empreendimentos.getModelo() == 0){
            holder.nome.setText(empreendimentos.getNome());
        } else {
            holder.nome.setText(empreendimentos.getNome());
            holder.venda.setText(empreendimentos.getVenda());
            holder.simulacao.setText(empreendimentos.getSimulacao());
            holder.imagem.setImageResource(empreendimentos.getImagem());
        }

    }

    @Override
    public int getItemCount() {
        return listaEmpreendimentos.size();
    }

    @Override
    public int getItemViewType(int position) {
        /*if(position == 0 ||position == 5 ||position == 8 ||position == 19
                ||position == 21 ||position == 28 ||position == 33
                ||position == 36 ||position == 38 ||position == 43
                ||position == 45 ||position == 47 ||position == 53
                ||position == 58 ||position == 60 ||position == 66
                ||position == 70 ||position == 74 ||position == 76
                ||position == 78){
            return MODELO_DOIS;
        }*/
        return MODELO_UM;
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {

        private TextView nome;
        private TextView venda;
        private TextView simulacao;
        private ImageView imagem;

        public MyViewHoler(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNome);
            venda = itemView.findViewById(R.id.textAvaliacao);
            simulacao = itemView.findViewById(R.id.textVenda);
            imagem = itemView.findViewById(R.id.imageCons);
        }
    }
}

