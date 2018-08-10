package com.example.hp.logogenia.Clases;

public class Letra {

    private String letra;
    private int img;

    public Letra(String letra, int img) {
        this.letra = letra;
        this.img = img;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
