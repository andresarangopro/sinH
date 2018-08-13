package com.example.hp.logogenia.Clases;

import android.widget.VideoView;

public class Palabra {

    private String letra;
    private String palabra;
    private String img;
    private String video;

    public Palabra(String letra, String palabra, String img, String video) {
        this.letra = letra;
        this.palabra = palabra;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
