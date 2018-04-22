package com.eurezzolve.eucorretor.fragments;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.eurezzolve.eucorretor.activities.primarias.HomeActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by viana_2 on 20/04/2018.
 */

public class TerceirosFragment extends SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    //Definação das Variaveis
    private GoogleMap mMap;
    private LocationManager locationManager;
    public final float camerazoom = 15.0f; //Grau do Zoom

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

    }
    public void criarMarcadoresTerceiros(LatLng position, String tittle, String snippet){
        mMap.addMarker(new MarkerOptions().position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title(tittle).snippet(snippet));
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

}
