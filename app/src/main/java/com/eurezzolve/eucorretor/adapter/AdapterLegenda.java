package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Legenda;

import java.util.List;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class AdapterLegenda extends RecyclerView.Adapter<AdapterLegenda.MyViewHolder>{

    private List<Legenda> itensLegenda;

    public AdapterLegenda(List<Legenda> itensLegenda) {
        this.itensLegenda = itensLegenda;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLegenda = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_legenda, parent, false);
        return new MyViewHolder(itemLegenda);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Legenda legenda = itensLegenda.get(position);
        holder.imageLegendaMapa.setImageResource(legenda.getImagemLegenda());
        holder.textLegendaMapa.setText(legenda.getTextLegenda());
    }

    @Override
    public int getItemCount() {
        return itensLegenda != null ? itensLegenda.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textLegendaMapa;
        private ImageView imageLegendaMapa;

        public MyViewHolder(View itemView) {
            super(itemView);
            textLegendaMapa = itemView.findViewById(R.id.textLegendaMapa);
            imageLegendaMapa = itemView.findViewById(R.id.imageLegendaMapa);
        }
    }
}

