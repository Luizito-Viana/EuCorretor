package com.eurezzolve.eucorretor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Empreendimentos;

import java.util.List;



public class AdapterEmpBusca extends RecyclerView.Adapter<AdapterEmpBusca.MyViewHoler> {

    private List<Empreendimentos> listaEmpreendimentos;
    private Context context;

    public AdapterEmpBusca(List<Empreendimentos> empreendimentosLista, Context c){
        this.listaEmpreendimentos = empreendimentosLista;
        this.context = c;
    }

    public List<Empreendimentos> getListaEmpreendimentos() {
        return listaEmpreendimentos;
    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemListaEmpreendimentos = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_emp_busca, parent, false);
        return new AdapterEmpBusca.MyViewHoler(itemListaEmpreendimentos);
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, int position) {
        Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
        holder.textNome.setText(empreendimentos.getNome());
        holder.textConstrutora.setText("Cons.: " + empreendimentos.getConstrutora());
    }

    @Override
    public int getItemCount() {
        return listaEmpreendimentos != null ? listaEmpreendimentos.size() : 0;
    }


    public class MyViewHoler extends RecyclerView.ViewHolder {
        private ImageView imageEmp;
        private TextView textNome, textConstrutora;

        public MyViewHoler(View itemView) {
            super(itemView);
            imageEmp = itemView.findViewById(R.id.imageViewEmpBusca);
            textNome = itemView.findViewById(R.id.textViewEmp);
            textConstrutora = itemView.findViewById(R.id.textViewConst);

        }
    }
}
