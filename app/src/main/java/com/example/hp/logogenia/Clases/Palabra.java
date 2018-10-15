package com.example.hp.logogenia.Clases;

import android.widget.VideoView;

public class Palabra {

    protected String letra;
    protected String palabra;
    private String video;

    public Palabra(String letra, String palabra, String video) {
        this.letra = letra;
        this.palabra = palabra;
        this.video = video;
    }

    public Palabra(){}

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
