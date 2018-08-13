package com.example.hp.logogenia.Clases;

import java.io.Serializable;

public class Letra implements Serializable{

    private String letra;
    private String imgLetra;
    private String imgSena;

    public Letra(String letra, String imgLetra, String imgSena) {
        this.letra = letra;
        this.imgLetra = imgLetra;
        this.imgSena = imgSena;
    }

    public Letra(){}

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getImgLetra() {
        return imgLetra;
    }

    public void setImgLetra(String imgLetra) {
        this.imgLetra = imgLetra;
    }

    public String getImgSena() {
        return imgSena;
    }

    public void setImgSena(String imgSena) {
        this.imgSena = imgSena;
    }
}
