package com.eurezzolve.eucorretor.adapter;

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


public class AdapterEmp extends RecyclerView.Adapter<AdapterEmp.MyViewHoler> {

    private static final int MODELO_UM = 0;

    private List<Empreendimentos> listaEmpreendimentos;
    private TabelasEmpOnClickListener tabelasEmpOnClickListener;
    private DescricaoEmpOnClickListener descricaoEmpOnClickListener;
    private int flagLista;

    public interface TabelasEmpOnClickListener {
        void tbEmpOnClick(MyViewHoler holer, int position, int flafLista);
    }

    public interface DescricaoEmpOnClickListener {
        void descEmpOnClick(MyViewHoler holer, int position, int flagLista);
    }


    public AdapterEmp(List<Empreendimentos> empreendimentosLista, TabelasEmpOnClickListener tabelasEmpOnClickListener, DescricaoEmpOnClickListener descricaoEmpOnClickListener,int flagLista){
        this.listaEmpreendimentos = empreendimentosLista;
        this.descricaoEmpOnClickListener = descricaoEmpOnClickListener;
        this.tabelasEmpOnClickListener = tabelasEmpOnClickListener;
        this.flagLista = flagLista;
    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemListaEmpreendimentos = null;
        itemListaEmpreendimentos = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_imoveis, parent, false);
        return new MyViewHoler(itemListaEmpreendimentos);
    }

    @Override
    public void onBindViewHolder(final MyViewHoler holder, final int position) {
        Empreendimentos empreendimentos = listaEmpreendimentos.get(position);
        holder.textNome.setText(empreendimentos.getNome());
        holder.textConstrutora.setText("Cons.: " + empreendimentos.getConstrutora());
        holder.textInfo.setText("Informações Adicionais:\n" + empreendimentos.getVenda() + "\n" + empreendimentos.getSimulacao());
        holder.imageEmp.setImageResource(empreendimentos.getImagem());

        if(tabelasEmpOnClickListener != null){
            holder.imageTabelas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tabelasEmpOnClickListener.tbEmpOnClick(holder, position, flagLista);
                }
            });
        }

        if(descricaoEmpOnClickListener != null){
            holder.imageDescricao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    descricaoEmpOnClickListener.descEmpOnClick(holder, position, flagLista);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaEmpreendimentos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return MODELO_UM;
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {
        private ImageView imageEmp;
        private ImageButton imageDescricao;
        private ImageButton imageTabelas;
        private TextView textNome, textConstrutora, textInfo;

        public MyViewHoler(View itemView) {
            super(itemView);
            imageEmp = itemView.findViewById(R.id.imageImovel);
            imageDescricao = itemView.findViewById(R.id.imageDescricaoImovel);
            imageTabelas = itemView.findViewById(R.id.imageTabelasImovel);
            textNome = itemView.findViewById(R.id.textNomeImovel);
            textConstrutora = itemView.findViewById(R.id.textConstrutoraImovel);
            textInfo = itemView.findViewById(R.id.textInfoImovel);
        }
    }
}

