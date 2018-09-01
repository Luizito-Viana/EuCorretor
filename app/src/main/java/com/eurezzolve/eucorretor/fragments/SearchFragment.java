/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:59
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.adapter.AdapterEmpBusca;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.config.RecyclerItemClickListener;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recyclerSearch;
    private List<Empreendimentos> listaEmp = new ArrayList<>();
    private DatabaseReference database;
    private AdapterEmpBusca adapter;
    private ValueEventListener valueEventListener;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        database = ConfiguracaoFirebase.getFirebaseDatabase().child("listaEmp");
        recyclerSearch = view.findViewById(R.id.recSearchFragment);
        progressBar = view.findViewById(R.id.progressBarSearch);

        recuperarEmp();

        //Configurar adapter
        adapter = new AdapterEmpBusca(listaEmp, getActivity());

        //Configurar Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerSearch.setLayoutManager(layoutManager);
        recyclerSearch.setHasFixedSize(true);
        recyclerSearch.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerSearch.setAdapter(adapter);

        recyclerSearch.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerSearch, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                List<Empreendimentos> listaAtt = adapter.getListaEmpreendimentos();
                Empreendimentos emp = listaAtt.get(position);
                getActivity().onBackPressed();

                EmpBuscaFragment fragment = EmpBuscaFragment.newInstance("teste");
                Bundle bundle = new Bundle();

                bundle.putDouble("longitude", emp.getLongitude());
                bundle.putDouble("latitude", emp.getLatitude());
                bundle.putString("titulo", emp.getNome());
                bundle.putString("subtitulo", emp.getVenda());

                //bundle.putSerializable("info", emp);
                fragment.setArguments(bundle);


                FragmentTransaction transactionTer = getActivity().getSupportFragmentManager().beginTransaction();
                transactionTer.replace(R.id.containerPrincipal, fragment);
                transactionTer.commit();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));

        progressBar.setVisibility(View.VISIBLE);
        return view;
    }

    public void recuperarEmp(){
        valueEventListener = database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dados : dataSnapshot.getChildren()){
                    Empreendimentos emp = dados.getValue(Empreendimentos.class);
                    listaEmp.add(emp);
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void pesquisarEmp(String texto){
        List<Empreendimentos> listaBusca = new ArrayList<>();

        for (Empreendimentos emp : listaEmp) {
            String nome = emp.getNome().toLowerCase();
            String constr = emp.getConstrutora().toLowerCase();
            if(nome.contains(texto) || constr.contains(texto)){
                listaBusca.add(emp);
            }

        }

        adapter = new AdapterEmpBusca(listaBusca, getActivity());
        recyclerSearch.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        //recuperarEmp();
    }

    @Override
    public void onStop() {
        super.onStop();
        database.removeEventListener(valueEventListener);
    }
}
