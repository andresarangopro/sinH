package com.example.hp.logogenia.Clases;

public class PalabraImagen extends Palabra {

    private String img;

    public PalabraImagen(String palabra, String img) {
        this.palabra = palabra;
        this.img = img;
    }

    public PalabraImagen(){}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
