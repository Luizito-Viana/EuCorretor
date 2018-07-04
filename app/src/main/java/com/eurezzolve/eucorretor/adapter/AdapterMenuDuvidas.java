package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.MenuDuvida;

import java.util.List;

/**
 * Created by viana_2 on 04/07/2018.
 */

public class AdapterMenuDuvidas extends RecyclerView.Adapter<AdapterMenuDuvidas.MyViewHolder> {

    List<MenuDuvida> listaItens;

    public AdapterMenuDuvidas(List<MenuDuvida> listaItens) {
        this.listaItens = listaItens;
    }

    public List<MenuDuvida> getListaItens(){
        return listaItens;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_duvidas_menu,parent,false);
        return new AdapterMenuDuvidas.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuDuvida itemDuvida = listaItens.get(position);

        holder.item.setText(itemDuvida.getItemMenu());
    }

    @Override
    public int getItemCount() {
        return listaItens != null? listaItens.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView item;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textViewDuvidasMenuItem);
        }
    }
}
