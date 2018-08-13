package com.example.hp.logogenia.Util;

import android.content.Context;

import com.example.hp.logogenia.Clases.Imagen;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Clases.Palabra;
import com.example.hp.logogenia.Clases.Video;

public class PrepareData {

    private DbHelper db;

    public PrepareData(DbHelper db) {
        this.db = db;

    }

    private Imagen[] createImages(){
        Imagen[] listImg = new Imagen[]{
                new Imagen("a"),
                new Imagen("b"),
                new Imagen("c"),
                new Imagen("d"),
                new Imagen("e"),
                new Imagen("f"),
                new Imagen("g"),
                new Imagen("h"),
                new Imagen("i"),
                new Imagen("j"),
                new Imagen("k"),
                new Imagen("l"),
                new Imagen("m"),
                new Imagen("n"),
                new Imagen("o"),
                new Imagen("p"),
                new Imagen("q"),
                new Imagen("r"),
                new Imagen("s"),
                new Imagen("t"),
                new Imagen("u"),
                new Imagen("v"),
                new Imagen("w"),
                new Imagen("x"),
                new Imagen("y"),
                new Imagen("z"),
                new Imagen("as"),
                new Imagen("bs"),
                new Imagen("cs"),
                new Imagen("ds"),
                new Imagen("es"),
                new Imagen("fs"),
                new Imagen("gs"),
                new Imagen("hs"),
                new Imagen("is"),
                new Imagen("js"),
                new Imagen("ks"),
                new Imagen("ls"),
                new Imagen("ms"),
                new Imagen("ns"),
                new Imagen("os"),
                new Imagen("ps"),
                new Imagen("qs"),
                new Imagen("rs"),
                new Imagen("ss"),
                new Imagen("ts"),
                new Imagen("us"),
                new Imagen("vs"),
                new Imagen("ws"),
                new Imagen("xs"),
                new Imagen("ys"),
                new Imagen("zs"),
                new Imagen("a_brazar"),
                new Imagen("a_brigo"),
                new Imagen("a_bril"),
                new Imagen("a_buelo"),
                new Imagen("a_ceite"),
                new Imagen("a_ceptar"),
                new Imagen("a_cne"),
                new Imagen("a_ctividad"),
                new Imagen("a_dentro"),
                new Imagen("a_dulto"),
                new Imagen("a_eropuerto"),
                new Imagen("a_frica"),
                new Imagen("a_fuera"),
                new Imagen("a_gosto"),
                new Imagen("a_gradecer"),
                new Imagen("a_gua"),
                new Imagen("a_guacate"),
                new Imagen("a_jedrez"),
                new Imagen("a_ji"),
                new Imagen("a_lcoba"),
                new Imagen("a_lfabeto_manual"),
                new Imagen("a_lmuerzo"),
                new Imagen("a_lto"),
                new Imagen("a_mable"),
                new Imagen("a_marillo"),
                new Imagen("a_merica"),
                new Imagen("a_migo"),
                new Imagen("a_mor"),
                new Imagen("a_naranjado"),
                new Imagen("a_nciano"),
                new Imagen("a_no"),
                new Imagen("a_ntes"),
                new Imagen("a_pagar_luz"),
                new Imagen("a_poyar"),
                new Imagen("a_prender"),
                new Imagen("a_rbol"),
                new Imagen("a_rcoiris"),
                new Imagen("a_repa"),
                new Imagen("a_rquitecto"),
                new Imagen("a_rroz"),
                new Imagen("a_rte"),
                new Imagen("a_rveja"),
                new Imagen("a_sia"),
                new Imagen("a_sistir"),
                new Imagen("a_udifono"),
                new Imagen("a_ustralia"),
                new Imagen("a_vion"),
                new Imagen("a_yer"),
                new Imagen("a_yer0"),
                new Imagen("a_zul"),
                new Imagen("b_achillerato"),
                new Imagen("c_cancer")
        };
        return listImg;
    }

    private Video[] createVideos(){
        Video[] listVideos = new Video[]{

                new Video("a_bogado"),
                new Video("a_brazar"),
                new Video("a_brigo"),
                new Video("a_bril"),
                new Video("a_buelo"),
                new Video("a_ceite"),
                new Video("a_ceptar"),
                new Video("a_cne"),
                new Video("a_ctividad"),
                new Video("a_dentro"),
                new Video("a_dulto"),
                new Video("a_eropuerto"),
                new Video("a_frica"),
                new Video("a_fuera"),
                new Video("a_gosto"),
                new Video("a_gradecer"),
                new Video("a_gua"),
                new Video("a_guacate"),
                new Video("a_jedrez"),
                new Video("a_ji"),
                new Video("a_lcoba"),
                new Video("a_lfabeto_manual"),
                new Video("a_lmuerzo"),
                new Video("a_lto"),
                new Video("a_mable"),
                new Video("a_marillo"),
                new Video("a_merica"),
                new Video("a_migo"),
                new Video("a_mor"),
                new Video("a_naranjado"),
                new Video("a_nciano"),
                new Video("a_no"),
                new Video("a_ntes"),
                new Video("a_pagar_luz"),
                new Video("a_poyar"),
                new Video("a_prender"),
                new Video("a_rbol"),
                new Video("a_rcoiris"),
                new Video("a_repa"),
                new Video("a_rquitecto"),
                new Video("a_rroz"),
                new Video("a_rte"),
                new Video("a_rveja"),
                new Video("a_sia"),
                new Video("a_sistir"),
                new Video("a_udifono"),
                new Video("a_ustralia"),
                new Video("a_vion"),
                new Video("a_yer"),
                new Video("a_yer0"),
                new Video("a_zul"),
                new Video("b_achillerato"),
                new Video("c_cancer")
        };

        return listVideos;
    }

    private Letra[] createLetras(){
        Letra[] listLetras = new Letra[]{
                new Letra("a","a","as"),
                new Letra("b","b","bs"),
                new Letra("c","c","cs"),
                new Letra("d","d","ds"),
                new Letra("e","e","es"),
                new Letra("f","f","fs"),
                new Letra("g","g","gs"),
                new Letra("h","h","hs"),
                new Letra("i","i","is"),
                new Letra("j","j","js"),
                new Letra("k","k","ks"),
                new Letra("l","l","ls"),
                new Letra("m","m","ms"),
                new Letra("n","n","ns"),
                new Letra("o","o","os"),
                new Letra("p","p","ps"),
                new Letra("q","q","qs"),
                new Letra("r","r","rs"),
                new Letra("s","s","ss"),
                new Letra("t","t","ts"),
                new Letra("u","u","us"),
                new Letra("v","v","vs"),
                new Letra("w","w","ws"),
                new Letra("x","x","xs"),
                new Letra("y","y","ys"),
                new Letra("z","z","zs")
        };

        return listLetras;
    }

    private Palabra[] createPalabras(){
        Palabra[] listPalabras = new Palabra[]{
                new Palabra("a","abogado","a_bogado","a_bogado"),
                new Palabra("a","abrazar","a_brazar","a_brazar"),
                new Palabra("a","abrigo","a_brigo","a_brigo"),
                new Palabra("a","abril","a_bril","a_bril"),
                new Palabra("a","abuelo","a_buelo","a_buelo"),
                new Palabra("a","aceite","a_ceite","a_ceite"),
                new Palabra("a","aceptar","a_ceptar","a_ceptar"),
                new Palabra("a","acne","a_cne","a_cne"),
                new Palabra("a","actividad","a_ctividad","a_ctividad"),
                new Palabra("a","adentro","a_dentro","a_dentro"),
                new Palabra("a","adulto","a_dulto","a_dulto"),
                new Palabra("a","aeropuerto","a_eropuerto","a_eropuerto"),
                new Palabra("a","africa","a_frica","a_frica"),
                new Palabra("a","afuera","a_fuera","a_fuera"),
                new Palabra("a","agosto","a_gosto","a_gosto"),
                new Palabra("a","agradecer","a_gradecer","a_gradecer"),
                new Palabra("a","agua","a_gua","a_gua"),
                new Palabra("a","aguacate","a_guacate","a_guacate"),
                new Palabra("a","ajedrez","a_jedrez","a_jedrez"),
                new Palabra("a","aji","a_ji","a_ji"),
                new Palabra("a","alcoba","a_lcoba","a_lcoba"),
                new Palabra("a","alfabeto manual","a_lfabeto_manual","a_lfabeto_manual"),
                new Palabra("a","almuerzo","a_lmuerzo","a_lmuerzo"),
                new Palabra("a","alto","a_lto","a_lto"),
                new Palabra("a","amable","a_mable","a_mable"),
                new Palabra("a","amarillo","a_marillo","a_marillo"),
                new Palabra("a","america","a_merica","a_merica"),
                new Palabra("a","amigo","a_migo","a_migo"),
                new Palabra("a","amor","a_mor","a_mor"),
                new Palabra("a","anaranjado","a_naranjado","a_naranjado"),
                new Palabra("a","anciano","a_nciano","a_nciano"),
                new Palabra("a","año","a_no","a_no"),
                new Palabra("a","antes","a_ntes","a_ntes"),
                new Palabra("a","apagar la luz","a_pagar_luz","a_pagar_luz"),
                new Palabra("a","apoyar","a_poyar","a_poyar"),
                new Palabra("a","aprender","a_prender","a_prender"),
                new Palabra("a","arbol","a_rbol","a_rbol"),
                new Palabra("a","arcoiris","a_rcoiris","a_rcoiris"),
                new Palabra("a","arepa","a_repa","a_repa"),
                new Palabra("a","arquitecto","a_rquitecto","a_rquitecto"),
                new Palabra("a","arroz","a_rroz","a_rroz"),
                new Palabra("a","arte","a_rte","a_rte"),
                new Palabra("a","arveja","a_rveja","a_rveja"),
                new Palabra("a","asia","a_sia","a_sia"),
                new Palabra("a","asistir","a_sistir","a_sistir"),
                new Palabra("a","audifono","a_udifono","a_udifono"),
                new Palabra("a","australia","a_ustralia","a_ustralia"),
                new Palabra("a","avion","a_vion","a_vion"),
                new Palabra("a","ayer","a_yer","a_yer"),
                new Palabra("a","otra forma de ayer","a_yer0","a_yer0"),
                new Palabra("a","azul","a_zul","a_zul"),
                new Palabra("b","bachillerato","b_achillerato","b_achillerato"),
                new Palabra("c","cancer","c_ancer","c_ancer")

        };
        return listPalabras;
    }

    public void putImgsInDB(){
        Imagen[] imagenes = createImages();
        for (Imagen img: imagenes) {
            long img1_id = db.createImg(img);
        }
    }

    public void putVideosInDB(){
        Video[] videos = createVideos();
        for (Video vid: videos) {
            long video51_id = db.createVideo(vid);
        }
    }

    public void putLetrasInDB(){
        Letra[] letras = createLetras();
        for (Letra letra:letras) {
            long letra_a = db.createLetra(letra);
        }
    }

    public void putPalabrasInDB(){
        Palabra[] palabras = createPalabras();
        for(Palabra word: palabras){
            long id_1 = db.createWord(word);
        }
    }
}
