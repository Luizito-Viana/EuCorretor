/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:58
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Terceiros;

import java.util.List;



public class AdapterTerceiros extends RecyclerView.Adapter<AdapterTerceiros.TerceirosHolder>{

    private List<Terceiros> listaTerceiros;
    private TabelasTerceirosOnClickListener tabelasTerceirosOnClickListener;
    private DescricaoTerceirosOnClickListener descricaoTerceirosOnClickListener;
    private int flagLista;

    public interface TabelasTerceirosOnClickListener {
        void tbTerceirosOnClick(TerceirosHolder holder, int position, int flagLista);
    }

    public interface DescricaoTerceirosOnClickListener {
        void descTerceirosOnClick(TerceirosHolder holder, int position, int flagLista);
    }

    public AdapterTerceiros(List<Terceiros> listaTerceiros, TabelasTerceirosOnClickListener tabelasTerceirosOnClickListener, DescricaoTerceirosOnClickListener descricaoTerceirosOnClickListener, int flagLista) {
        this.listaTerceiros = listaTerceiros;
        this.tabelasTerceirosOnClickListener = tabelasTerceirosOnClickListener;
        this.descricaoTerceirosOnClickListener = descricaoTerceirosOnClickListener;
        this.flagLista = flagLista;
    }

    @Override
    public TerceirosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_imoveis, parent, false);
        return new TerceirosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TerceirosHolder holder, final int position) {
        Terceiros terceiros = listaTerceiros.get(position);
        holder.textNome.setText(terceiros.getNome());
        holder.textConstrutora.setText("Cons.: " + terceiros.getDono());
        holder.textInfo.setText("Informações adicionais: \n" + terceiros.getInfoAdapter());
        holder.imageTerceiro.setImageResource(terceiros.getImageThumb());

        /*Atribuindo os metodos*/
        if(descricaoTerceirosOnClickListener != null){
            holder.imageDescricao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    descricaoTerceirosOnClickListener.descTerceirosOnClick(holder, position,flagLista);
                }
            });
        }

        if(tabelasTerceirosOnClickListener != null){
            holder.imageTabelas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tabelasTerceirosOnClickListener.tbTerceirosOnClick(holder, position, flagLista);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaTerceiros.size();
    }

    public class TerceirosHolder extends RecyclerView.ViewHolder{

        private ImageView imageTerceiro;
        private ImageButton imageDescricao;
        private ImageButton imageTabelas;
        private TextView textNome, textConstrutora, textInfo;

        public TerceirosHolder(View itemView) {
            super(itemView);
            imageTerceiro = itemView.findViewById(R.id.imageImovel);
            imageDescricao = itemView.findViewById(R.id.imageDescricaoImovel);
            imageTabelas = itemView.findViewById(R.id.imageTabelasImovel);
            textNome = itemView.findViewById(R.id.textNomeImovel);
            textConstrutora = itemView.findViewById(R.id.textConstrutoraImovel);
            textInfo = itemView.findViewById(R.id.textInfoImovel);

        }
    }
}
