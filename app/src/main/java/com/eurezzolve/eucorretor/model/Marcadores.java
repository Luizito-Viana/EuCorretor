package com.eurezzolve.eucorretor.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by viana_2 on 30/04/2018.
 */

public class Marcadores implements Serializable{
    String nome;
    String pesquisaM1;
    String pesquisaM2;
    String pesquisaM3;
    String pesquisaM4;
    LatLng latLng;
    String subtitulo;
    Double latitude, longitude;

    public Marcadores() {
    }

    public Marcadores(String nome, String pesquisaM1, String pesquisaM2, String pesquisaM3, String pesquisaM4, Double latitude, Double longitude, String subtitulo) {
        this.nome = nome;
        this.pesquisaM1 = pesquisaM1;
        this.pesquisaM2 = pesquisaM2;
        this.pesquisaM3 = pesquisaM3;
        this.pesquisaM4 = pesquisaM4;
        //this.latLng = latLng;
        this.latitude = latitude;
        this.longitude = longitude;
        this.subtitulo = subtitulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPesquisaM1() {
        return pesquisaM1;
    }

    public void setPesquisaM1(String pesquisaM1) {
        this.pesquisaM1 = pesquisaM1;
    }

    public String getPesquisaM2() {
        return pesquisaM2;
    }

    public void setPesquisaM2(String pesquisaM2) {
        this.pesquisaM2 = pesquisaM2;
    }

    public String getPesquisaM3() {
        return pesquisaM3;
    }

    public void setPesquisaM3(String pesquisaM3) {
        this.pesquisaM3 = pesquisaM3;
    }

    public String getPesquisaM4() {
        return pesquisaM4;
    }

    public void setPesquisaM4(String pesquisaM4) {
        this.pesquisaM4 = pesquisaM4;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
