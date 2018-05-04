package com.eurezzolve.eucorretor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.DefaultHyphenator;
import com.bluejamesbond.text.hyphen.IHyphenator;
import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.model.Documentacao;

import java.util.List;

import static com.bluejamesbond.text.hyphen.DefaultHyphenator.*;


public class AdapterDocumentacao extends RecyclerView.Adapter<AdapterDocumentacao.MyViewHolder>{

    private List<Documentacao> documentacaoLista;

    public AdapterDocumentacao(List<Documentacao> listaDocumentacao) {
        this.documentacaoLista = listaDocumentacao;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemDocumentacao = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_auxiliar,parent,false);

        return new MyViewHolder(itemDocumentacao);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Documentacao documentacao = documentacaoLista.get(position);
        holder.pergunta.setText(documentacao.getPergunta());
        holder.resposta.setText(documentacao.getResposta());
    }

    @Override
    public int getItemCount() {
        return documentacaoLista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pergunta;
        TextView resposta;

        public MyViewHolder(View itemView) {
            super(itemView);
            pergunta = itemView.findViewById(R.id.textPergunta);
            resposta = itemView.findViewById(R.id.textResposta);
        }
    }

}
