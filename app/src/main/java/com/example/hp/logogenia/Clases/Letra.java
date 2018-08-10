package com.example.hp.logogenia.Clases;

public class Letra {

    private String letra;
    private int imgLetra;
    private int imgSena;

    public Letra(String letra, int imgLetra, int imgSena) {
        this.letra = letra;
        this.imgLetra = imgLetra;
        this.imgSena = imgSena;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getImgLetra() {
        return imgLetra;
    }

    public void setImgLetra(int imgLetra) {
        this.imgLetra = imgLetra;
    }

    public int getImgSena() {
        return imgSena;
    }

    public void setImgSena(int imgSena) {
        this.imgSena = imgSena;
    }
}
