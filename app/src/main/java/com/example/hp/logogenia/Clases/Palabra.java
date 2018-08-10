package com.example.hp.logogenia.Clases;

import android.widget.VideoView;

public class Palabra {

    private Letra letra;
    private String palabra;
    private int img;
    private VideoView video;

    public Palabra(Letra letra, String palabra, int img, VideoView video) {
        this.letra = letra;
        this.palabra = palabra;
        this.img = img;
        this.video = video;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public VideoView getVideo() {
        return video;
    }

    public void setVideo(VideoView video) {
        this.video = video;
    }
}
