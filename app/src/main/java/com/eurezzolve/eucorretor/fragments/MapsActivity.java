package com.eurezzolve.eucorretor.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.eurezzolve.eucorretor.R;
import com.eurezzolve.eucorretor.activities.introducao.MainActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends SupportMapFragment
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    //Definação das Variaveis
    private Boolean aBoolean = false;
    private Location locationAtual;
    private Context context;
    private GoogleApiClient googleApiClient;
    private GoogleMap mMap;
    private LocationManager locationManager;
    public final float camerazoom = 15.0f; //Grau do Zoom

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        googleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();
        getMapAsync(this);
    }

    @Override
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
        Log.d("onConnected", aBoolean.toString() );
        if(aBoolean == true){
            LatLng atual = new LatLng(locationAtual.getLatitude(), locationAtual.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(atual));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(atual, camerazoom));
        } else {
            LatLng udiConfiancaElse = new LatLng(-18.921170, -48.275920);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(udiConfiancaElse));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udiConfiancaElse, camerazoom));
        }

        LatLng udiConfianca = new LatLng(-18.921170, -48.275920);
        MarkerOptions marker = new MarkerOptions(); //Instacia
        marker.position(udiConfianca);//Marca a Posição
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)); //Determina a Cor
        marker.title("UdiConfiança Imóveis"); //Cria um titulo
        marker.snippet("Mais de 10 anos de mercado"); //Cria uma janela de informações
        mMap.addMarker(marker);

        //Adcionando os Empreendimentos

        //AZM
        LatLng vertentesiii = new LatLng(-18.941298, -48.348096);
        criarMarcadoresEmpreendimentos(vertentesiii, "Residencial Vertentes III", "Venda: R$129.900,00 a partir");
        LatLng tavares = new LatLng(-18.945764, -48.350587);
        criarMarcadoresEmpreendimentos(tavares, "Residencial Tavares", "Venda: R$119.900,00 a partir");
        LatLng floresDoCerrado = new LatLng(-18.965741, -48.339644);
        criarMarcadoresEmpreendimentos(floresDoCerrado, "Residencial Flores do Cerrado", "Venda: R$109.900,00 a partir");
        LatLng vidaBoa = new LatLng(-18.948985, -48.318978);
        criarMarcadoresEmpreendimentos(vidaBoa, "Residencial Vida Boa", "Venda: R$134.900,00 a partir");

        //BARI
        LatLng evoraResidence = new LatLng(-18.923276, -48.233178);
        criarMarcadoresEmpreendimentos(evoraResidence, "Évora Residence", "Venda: R$310.000,00 a partir");
        LatLng caioFerreira = new LatLng(-18.920513, -48.235372);
        criarMarcadoresEmpreendimentos(caioFerreira, "Caio Ferreira Residence", "Venda: R$330.000,00");

        //C&A
        LatLng plazanorte = new LatLng(-18.8974186, -48.2784520);
        criarMarcadoresEmpreendimentos(plazanorte, "Plaza Norte Residence", "Venda: R$189.990,00 a partir");
        LatLng solaris = new LatLng(-18.935183, -48.320994);
        criarMarcadoresEmpreendimentos(solaris, "Residencial Solaris", "Venda: R$149.990,00");

        /*
        LatLng zenith = new LatLng();
        mMap.addMarker(new MarkerOptions().position(zenith)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("Zenith Residence").snippet("Venda: R$142.990"));*/

        LatLng villaReal = new LatLng(-18.936320, -48.377321);
        criarMarcadoresEmpreendimentos(villaReal, "Residencial Villa Real", "Venda: R$184.990,00");
        LatLng estoril = new LatLng(-18.965689, -48.247368);
        criarMarcadoresEmpreendimentos(estoril, "Estoril Residence", "Venda: R$142.990,00");
        LatLng queens = new LatLng(-18.882544, -48.255123);
        criarMarcadoresEmpreendimentos(queens, "Queens Residence", "Venda: R$198.990,00");
        LatLng monsenhor = new LatLng(-18.936320, -48.377321);
        criarMarcadoresEmpreendimentos(monsenhor, "Residencial Monsenhor", "Venda: R$195.990,00");
        LatLng lexusOffice = new LatLng(-18.936320, -48.377321);
        criarMarcadoresEmpreendimentos(lexusOffice, "Lexus Office", "Venda: R$132.582,00 a partir");
        LatLng jardinsResidence = new LatLng(-18.936320, -48.377321);
        criarMarcadoresEmpreendimentos(jardinsResidence, "Jardins Residence", "Venda: R$127.990,00");
        LatLng jardimBrasiliaResidencial = new LatLng(-18.936320, -48.377321);
        criarMarcadoresEmpreendimentos(jardimBrasiliaResidencial, "Jardim Brasília Residencial", "Venda: R$142.990,00");

        //CIMA
        LatLng versatto = new LatLng(-18.908935, -48.250678);
        criarMarcadoresEmpreendimentos(versatto, "Versatto Residence", "Venda: R$307.382,00 a partir");

        //CONEL
        LatLng lidicePremium = new LatLng(-18.926833, -48.278707);
        criarMarcadoresEmpreendimentos(lidicePremium, "Lidíce Premium", "Venda: R$1.016.863,88 a partir");
        LatLng tapuirama = new LatLng(-18.921502, -48.289379);
        criarMarcadoresEmpreendimentos(tapuirama, "Residencial Varandas Tapuirama", "Venda: R$1.022.625,81 a partir");
        LatLng acquaTorre = new LatLng(-18.928847, -48.292604);
        criarMarcadoresEmpreendimentos(acquaTorre, "Acqua Torre Centro Sul", "Venda: R$271.265,92 a partir");
        LatLng barao177 = new LatLng(-18.923511, -48.277237);
        criarMarcadoresEmpreendimentos(barao177, "Barão 177", "Venda: R$299.627,38 a partir");
        LatLng california = new LatLng(-18.941665, -48.285403);
        criarMarcadoresEmpreendimentos(california, "Edifício Califórnia", "Venda: R$328.629,35 a partir");
        LatLng granPlaza = new LatLng(-18.923641, -48.278165);
        criarMarcadoresEmpreendimentos(granPlaza, "Gran Plaza Residence", "Venda: R$284.628,00 a partir");

        //HLTS
        LatLng primeclub = new LatLng(-18.9287291, -48.24139154);
        criarMarcadoresEmpreendimentos(primeclub, "Prime Club Residence", "Venda: R$314.300,00 a partir");
        LatLng newQuality = new LatLng(-18.937093, -48.251524);
        criarMarcadoresEmpreendimentos(newQuality, "New Quality Residence", "R$138.000,00 a partir");
        LatLng placeAltoUmuarama = new LatLng(-18.937093, -48.215574);
        criarMarcadoresEmpreendimentos(placeAltoUmuarama, "Place Alto Umuarama", "R$115.000,00 a partir");
        LatLng jardimHolanda = new LatLng(-18.956365, -48.317597);
        criarMarcadoresEmpreendimentos(jardimHolanda, "Residencial Jardim Holanda", "R$113.000,00 a partir");
        //LatLng qualityResidence = new LatLng(-18.937093,-48.251520);

        //HPR
        LatLng araucarias = new LatLng(-18.899538, -48.286909);
        criarMarcadoresEmpreendimentos(araucarias, "Residencial Araucárias", "R$179.900,00 a partir");
        LatLng acacias = new LatLng(-18.872044, -48.233464);
        criarMarcadoresEmpreendimentos(acacias, "Residencial Acácias", "R$174.000,00 a partir");

        //L Silva
        LatLng rubiResidence = new LatLng(-18.933670, -48.239460);
        criarMarcadoresEmpreendimentos(rubiResidence, "Edifício Rubi Residence", "R$220.000,00 a partir");

        //Marca Registrada
        LatLng granToro = new LatLng(-18.9653999, -48.2482812);
        criarMarcadoresEmpreendimentos(granToro, "Gran Toro", "R$131.000,00 a partir");

        //Maxi
        LatLng provenceResidenceClub = new LatLng(-18.925502, -48.248975);
        criarMarcadoresEmpreendimentos(provenceResidenceClub, "Provence Residence Club", "R$334.700,00 a partir");

        //MRV
        LatLng unitedstates = new LatLng(-18.9661300, -48.27963224);
        criarMarcadoresEmpreendimentos(unitedstates, "Parque United States", "Venda: R$128.000,00 a partir");

        //Opção
        LatLng villagesul = new LatLng(-18.9688751, -48.22366152);
        criarMarcadoresEmpreendimentos(villagesul, "Residencial Village Sul", "Venda: R$136.900,00 a partir");
        LatLng royaleResidence = new LatLng(-18.947939, -48.350186);
        criarMarcadoresEmpreendimentos(royaleResidence, "Residencial Royale", "R$140.900,00 a partir");

        //Pacheco
        LatLng evidenceResidencial = new LatLng(-18.923221, -48.275812);
        criarMarcadoresEmpreendimentos(evidenceResidencial, "Residencial Evidence", "Venda: R$1.397.000,00 a partir");
        LatLng lidiceBoulevard = new LatLng(-18.923962, -48.273261);
        criarMarcadoresEmpreendimentos(lidiceBoulevard, "Residencial Lídice Boulevard", "Venda: R$671.000,00 a partir");
        LatLng venezaResidencial = new LatLng(-18.912732, -48.252659);
        criarMarcadoresEmpreendimentos(venezaResidencial, "Residencial Veneza", "Venda: R$290.000,00 a partir");
        LatLng uniqueResidencial = new LatLng(-18.923696, -48.260475);
        criarMarcadoresEmpreendimentos(uniqueResidencial, "Residencial Unique", "Venda: R$355.000,00 a partir");

        //PDCA
        LatLng jardinsdoCerrado = new LatLng(-18.970602, -48.367926);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Jardins do Cerrado", "Venda: R$128.000,00");

        //Portento
        LatLng milao = new LatLng(-18.937114, -48.283756);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Residencial Milão", "Venda: R$330.000,00 a partir");
        LatLng sevilha = new LatLng(-18.9960109, -48.316545);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Residencial Sevilha", "Venda: R$144.000,00 a partir");
        LatLng valencia = new LatLng(-18.912071, -48.299931);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Residencial Valência", "Venda: R$145.000,00 a partir");
        LatLng ravena = new LatLng(-18.933384, -48.299948);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Residencial Ravena", "Venda: R$140.000,00 a partir");
        LatLng laBelle = new LatLng(-18.939161, -48.299913);
        criarMarcadoresEmpreendimentos(jardinsdoCerrado, "Residencial La Belle", "Venda: R$135.000,00 a partir");

        //Quartzo


        //R Freitas
        LatLng uzTower = new LatLng(-18.924512, -48.289580);
        criarMarcadoresEmpreendimentos(uzTower, "UZ Tower", "Venda: R$384.544,03 a partir");
        LatLng Aristides = new LatLng(-18.916850, -48.283689);
        criarMarcadoresEmpreendimentos(Aristides, "Edifício Aristides de Freitas", "Venda: R$180.000,00 a partir");
        LatLng BosquedasGameleiras = new LatLng(-18.880146, -48.297098);
        criarMarcadoresEmpreendimentos(BosquedasGameleiras, "Condomínio Bosque das Gameleiras", "Venda: R$359.000,00 a partir");

        //Realiza
        LatLng anita = new LatLng(-18.918045, -48.270920);
        criarMarcadoresEmpreendimentos(anita, "Anita Residence", "Venda: R$310.500,00 a partir");
        LatLng villageParadisoii = new LatLng(-18.874486, -48.246085);
        criarMarcadoresEmpreendimentos(villageParadisoii, "Village Paradiso II", "Venda: R$619.368,10 a partir");
        LatLng tropicalSul = new LatLng(-18.957483, -48.249472);
        criarMarcadoresEmpreendimentos(tropicalSul, "Tropical Sul", "Venda: R$180.000,00");

        //Troia
        LatLng splendiaResidence = new LatLng(-18.936585, -48.294116);
        criarMarcadoresEmpreendimentos(splendiaResidence, "Splendia Residence", "Venda: R$540.000,00 a partir");

        //Urbani
        LatLng residencialNapoli = new LatLng(-18.963645, -48.248534);
        criarMarcadoresEmpreendimentos(residencialNapoli, "Residencial Napoli", "Venda: R$129.900,00 a partir");


        //Vivamus
        LatLng smartower = new LatLng(-18.957149, -48.322014);
        criarMarcadoresEmpreendimentos(smartower, "Smart Tower Vivamus", "Venda: R$151.990,00 a partir");
        LatLng starttower = new LatLng(-18.9572098, -48.322110);
        criarMarcadoresEmpreendimentos(starttower, "Start Tower Vivamus", "Venda: R$128.000,00");

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                /*LinearLayout linear = new LinearLayout(getContext());
                linear.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                linear.setBackgroundResource(R.drawable.janela_marker);*/

                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }
        });


    }

    //Cria os devidos marcadores
    public void criarMarcadoresEmpreendimentos(LatLng position, String tittle, String snippet) {
        mMap.addMarker(new MarkerOptions().position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title(tittle).snippet(snippet));
    }

    public void criarMarcadoresImobiliarias(LatLng position, String tittle, String snippet) {
        mMap.addMarker(new MarkerOptions().position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .title(tittle).snippet(snippet));
    }


    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("onConnected", "Entrou aqui");
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            aBoolean = false;
            Log.d("onConnected", "false");
        } else {
            //locationAtual = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            aBoolean = true;
            Log.d("onConnected", "true");
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void pararConexaoComGoogleApi() {
        if(googleApiClient.isConnected()){
            googleApiClient.disconnect();
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        pararConexaoComGoogleApi();
    }


}