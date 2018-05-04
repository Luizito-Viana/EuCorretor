package com.eurezzolve.eucorretor.fragments;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eurezzolve.eucorretor.model.Marcadores;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by viana_2 on 30/04/2018.
 */

public class EmpBuscaFragment extends SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    //Definação das Variaveis
    private String titulo, subtitulo;
    private Double latitude,longitude;

    private Context context;
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
            titulo = args.getString("titulo");
            subtitulo = args.getString("subtitulo");
            latitude = args.getDouble("latitude");
            longitude = args.getDouble("longitude");
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
        LatLng udi = new LatLng(-18.921170, -48.275920);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udi));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udi, camerazoom));


        LatLng escolha = new LatLng(latitude, longitude);

        MarkerOptions marker = new MarkerOptions(); //Instacia
        marker.position(escolha);//Marca a Posição
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)); //Determina a Cor
        marker.title(titulo); //Cria um titulo
        marker.snippet(subtitulo); //Cria uma janela de informações
        mMap.addMarker(marker);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(escolha));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(escolha, camerazoom));
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}
