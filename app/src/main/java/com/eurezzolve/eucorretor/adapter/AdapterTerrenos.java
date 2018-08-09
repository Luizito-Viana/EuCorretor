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
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Terrenos;

import java.util.List;


public class AdapterTerrenos extends RecyclerView.Adapter<AdapterTerrenos.ViewHolderTerrenos> {

    private List<Terrenos> listaTerrenos;
    private AdapterTerrenos.TabelasTerrenosOnClickListener tabelasTerrenosOnClickListener;
    private AdapterTerrenos.DescricaoTerrenosOnClickListener descricaoTerrenosOnClickListener;
    private int flagLista;

    public AdapterTerrenos(List<Terrenos> listaTerrenos, TabelasTerrenosOnClickListener tabelasTerceirosOnClickListener, DescricaoTerrenosOnClickListener descricaoTerceirosOnClickListener, int flagLista) {
        this.listaTerrenos = listaTerrenos;
        this.tabelasTerrenosOnClickListener = tabelasTerceirosOnClickListener;
        this.descricaoTerrenosOnClickListener = descricaoTerceirosOnClickListener;
        this.flagLista = flagLista;
    }

    public interface TabelasTerrenosOnClickListener {
        void tbTerrenosOnClick(AdapterTerrenos.ViewHolderTerrenos holder, int position, int flagLista);
    }

    public interface DescricaoTerrenosOnClickListener {
        void descTerrenosOnClick(AdapterTerrenos.ViewHolderTerrenos holder, int position, int flagLista);
    }

    @Override
    public ViewHolderTerrenos onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_imoveis, parent, false);
        return new ViewHolderTerrenos(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolderTerrenos holder,final int position) {
        Terrenos terrenos = listaTerrenos.get(position);
        holder.textNome.setText(terrenos.getNomeTerrenos());
        holder.textConstrutora.setText("Cons.: " + terrenos.getDonoTerreno());
        holder.textInfo.setText("Informações adicionais: \n" + terrenos.getInfoAdapter());
        holder.imageTerreno.setImageResource(terrenos.getImageTerreno());

        /*Atribuindo os metodos*/
        if(descricaoTerrenosOnClickListener != null){
            holder.imageDescricao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                descricaoTerrenosOnClickListener.descTerrenosOnClick(holder, position, flagLista);
                }
            });
        }

        if(tabelasTerrenosOnClickListener != null){
            holder.imageTabelas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                tabelasTerrenosOnClickListener.tbTerrenosOnClick(holder, position, flagLista);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaTerrenos != null? listaTerrenos.size() : 0;
    }

    public class ViewHolderTerrenos extends RecyclerView.ViewHolder{

        private ImageView imageTerreno;
        private ImageButton imageDescricao;
        private ImageButton imageTabelas;
        private TextView textNome, textConstrutora, textInfo;

        public ViewHolderTerrenos(View itemView) {
            super(itemView);
            imageTerreno = itemView.findViewById(R.id.imageImovel);
            imageDescricao = itemView.findViewById(R.id.imageDescricaoImovel);
            imageTabelas = itemView.findViewById(R.id.imageTabelasImovel);
            textNome = itemView.findViewById(R.id.textNomeImovel);
            textConstrutora = itemView.findViewById(R.id.textConstrutoraImovel);
            textInfo = itemView.findViewById(R.id.textInfoImovel);
        }
    }
}
