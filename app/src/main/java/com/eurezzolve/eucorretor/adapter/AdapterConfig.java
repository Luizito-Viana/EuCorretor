package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Config;

import java.util.List;

/**
 * Created by viana_2 on 17/04/2018.
 */

public class AdapterConfig extends RecyclerView.Adapter<AdapterConfig.MyViewHolder> {

    private List<Config> listaConfig;
    private static final int TIPO_PAR = 0;
    private static final int TIPO_IMPAR = 1;

    public AdapterConfig(List<Config> listaConfig) {
        this.listaConfig = listaConfig;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == TIPO_PAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_configuracoes,parent,false);
        } else if(viewType == TIPO_IMPAR){
            item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_configuracoes_cordois, parent, false);
        }
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Config config = listaConfig.get(position);
        holder.item.setText(config.getItem());
        holder.vetor.setImageResource(config.getVector());
    }

    @Override
    public int getItemCount() {
        return listaConfig.size();
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
        private TextView item;
        private ImageView vetor;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textConfiguracoes);
            vetor = itemView.findViewById(R.id.imageConfig);
        }
    }
}