/*
 * Desenvolvido por Luiz F. Viana em 08/08/18 21:59
 * Todos os direitos reservados.
 * Este aplicativo ou qualquer parte dele não pode ser reproduzido ou usado de forma alguma
 * sem autorização expressa, por escrito, do autor.
 * Copyright © 2018
 */

package com.eurezzolve.eucorretor.fragments;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by viana_2 on 22/04/2018.
 */

public class TerrenosFragment extends SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    //Definação das Variaveis
    private GoogleMap mMap;
    private LocationManager locationManager;
    public final float camerazoom = 13.0f; //Grau do Zoom

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            //Usando o GPS (ou o bestprovider para melhor localização)
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);
            //Toast.makeText(getActivity(),"Provider: " + provider, Toast.LENGTH_SHORT).show();
            mMap = googleMap;
            mMap.getUiSettings().setZoomControlsEnabled(true);
            //mMap.setMyLocationEnabled(true);

        } catch (SecurityException ex) {
            Log.e("Catch", "Erro!");
        }

        LatLng udiConfianca = new LatLng(-18.921170, -48.275920);
        MarkerOptions marker = new MarkerOptions(); //Instacia
        marker.position(udiConfianca);//Marca a Posição
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)); //Determina a Cor
        marker.title("UdiConfiança Imóveis"); //Cria um titulo
        marker.snippet("Mais de 10 anos de mercado"); //Cria uma janela de informações

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udiConfianca));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udiConfianca, camerazoom));

        LatLng barao177 = new LatLng(-18.923511,-48.277237);
        LatLng evidenceResidencial = new LatLng(-18.923221,-48.275812);
        LatLng lidicePremium = new LatLng(-18.926833,-48.278707);
        criarMarcadoresTerrenos(barao177, "Terreno Teste 1", "Venda: R$150.000,00");
        criarMarcadoresTerrenos(evidenceResidencial, "Terreno Teste 2", "Venda: R$160.000,00");
        criarMarcadoresTerrenos(lidicePremium, "Terreno Teste 3", "Venda: R$170.000,00");

    }

    public void criarMarcadoresTerrenos(LatLng position, String tittle, String snippet){
        mMap.addMarker(new MarkerOptions().position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                .title(tittle).snippet(snippet));
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}
