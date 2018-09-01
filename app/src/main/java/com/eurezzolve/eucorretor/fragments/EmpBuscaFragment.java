/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:59
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.eurezzolve.eucorretor.activities.secundarias.DescricaoEmpActivity;
import com.eurezzolve.eucorretor.activities.secundarias.TabelasEmpActivity;
import com.eurezzolve.eucorretor.activities.secundarias.TabelasEmpM2Activity;
import com.eurezzolve.eucorretor.config.ConfiguracaoFirebase;
import com.eurezzolve.eucorretor.model.Empreendimentos;
import com.eurezzolve.eucorretor.model.Marcadores;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class EmpBuscaFragment extends SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    //Definação das Variaveis
    private String titulo, subtitulo;
    private Double latitude,longitude;

    private Empreendimentos emp;

    private List<Empreendimentos> empreendimentos = new ArrayList<>();
    private DatabaseReference reference = ConfiguracaoFirebase.getFirebaseDatabase().child("listaEmp");

    private GoogleMap mMap;
    private LocationManager locationManager;
    public final float camerazoom = 13.0f; //Grau do Zoom

    public static EmpBuscaFragment newInstance(String teste){
        EmpBuscaFragment f = new EmpBuscaFragment();
        Bundle args = new Bundle();
        args.putString("resgatar", teste);
        f.setArguments(args);
        Log.d("Recebido", teste);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            //emp = (Empreendimentos) args.getSerializable("info");
            titulo = args.getString("titulo");
            subtitulo = args.getString("subtitulo");
            latitude = args.getDouble("latitude");
            longitude = args.getDouble("longitude");

            if(latitude == 0.00000 || longitude == 0.00000){
                latitude = -18.921170;
                longitude = -48.275920;
                titulo = "UdiConfiança Imóveis";
                subtitulo = "Mais de 10 anos de mercado";
                Toast.makeText(getActivity().getApplicationContext(), "Informações de mapa não disponíveis", Toast.LENGTH_SHORT).show();
            }
        }
        getMapAsync(this);
    }


    public void onMapReady(GoogleMap googleMap) {
        try {

            //Usando o GPS (ou o bestprovider para melhor localização)
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            mMap = googleMap;
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);


        } catch (SecurityException ex) {
            Log.e("Catch", "Erro!");
        }

        LatLng escolha = new LatLng(latitude, longitude);

        MarkerOptions marker = new MarkerOptions(); //Instacia
        marker.position(escolha);//Marca a Posição
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)); //Determina a Cor
        marker.title(titulo); //Cria um titulo
        marker.snippet(subtitulo); //Cria uma janela de informações
        mMap.addMarker(marker);

        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(escolha);
        circleOptions.radius(1000);
        circleOptions.strokeWidth(1);
        circleOptions.fillColor(Color.argb(77,102, 255, 102));

        mMap.addCircle(circleOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(escolha));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(escolha, camerazoom));

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Empreendimentos emp = ds.getValue(Empreendimentos.class);
                    empreendimentos.add(emp);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String titulo = marker.getTitle();
                for(Empreendimentos emp : empreendimentos){
                    if(titulo.equals(emp.getNome())){
                        Intent j = new Intent(getActivity(), DescricaoEmpActivity.class);
                        j.putExtra("info", emp);
                        startActivity(j);
                    }
                }
            }
        });

        mMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
            @Override
            public void onInfoWindowLongClick(Marker marker) {
                String titulo = marker.getTitle();
                for(Empreendimentos emp : empreendimentos){
                    if(titulo.equals(emp.getNome())){
                        if(emp.getAct_flag() == 0){
                            Intent j = new Intent(getActivity(), TabelasEmpActivity.class);
                            j.putExtra("info", emp);
                            startActivity(j);
                        } else if(emp.getAct_flag() == 1) {
                            Intent j = new Intent(getActivity(), TabelasEmpM2Activity.class);
                            j.putExtra("info", emp);
                            startActivity(j);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}
