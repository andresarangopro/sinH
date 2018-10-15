package com.example.hp.logogenia.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hp.logogenia.Clases.Imagen;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Clases.Palabra;
import com.example.hp.logogenia.Clases.PalabraImagen;
import com.example.hp.logogenia.Clases.Video;
import com.example.hp.logogenia.Fragments.PalabrasFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Logog.db";

    public static final String tablePalabras = "Palabras";
    public static final String tableLetras = "Letras";
    public static final String tableImagenes= "Imagenes";
    public static final String tableVideos = "Videos";
    public static final String tableTipoImagen = "TiposImagenes";
    public static final String tableCuentos= "Cuentos";
    public static final String tableTema= "Temas";
    public static final String tablePalabrasImagenes= "PalabrasImagenes";

    private static String idLetra = "idLetra";

    private static String idVideo = "idVideo";

    private static String idTipoImagen = "idTImagen";
    private static String nmTipo = "nmTipo";

    private static String idImagen = "idImagen";

    private static String idPalabra = "idPalabra";

    private static String idCuento = "idCuento";

    private static String idTema = "idTema";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE " + tableTipoImagen + " ("
                +idTipoImagen+ " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                +nmTipo+ " VARCHAR(25) NOT NULL"+
                ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tableImagenes + " ("
                +idImagen+ " VARCHAR(25) PRIMARY KEY NOT NULL"+
                ")");


        sqLiteDatabase.execSQL("CREATE TABLE " + tablePalabras + "("
                + idPalabra + " TEXT PRIMARY KEY NOT NULL,"
                + idVideo+ "  VARCHAR(25) NOT NULL,"
                + idLetra +" VARCHAR(5)  NOT NULL"+
                ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tableCuentos + " ("
                +idCuento+ " VARCHAR(25) PRIMARY KEY NOT NULL"+
                ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tableTema + " ("
                +idTema+ " VARCHAR(25) PRIMARY KEY NOT NULL"+
                ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tablePalabrasImagenes + "("
                + idPalabra + " TEXT NOT NULL,"
                + idImagen+ " VARCHAR(25) NOT NULL,"
                + "PRIMARY KEY ("+idPalabra+", "+idImagen+"),"
                +"FOREIGN KEY("+idPalabra+")REFERENCES "+tablePalabras+"("+idPalabra+"),"
                +"FOREIGN KEY("+idImagen+")REFERENCES "+tableImagenes+"("+idImagen+")"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + tableImagenes);
        sqLiteDatabase.execSQL("drop table if exists " + tablePalabras);
        sqLiteDatabase.execSQL("drop table if exists " + tablePalabrasImagenes);
        onCreate(sqLiteDatabase);
    }



    //=================================================
    //= Select Values from  database
    //=================================================

    public List<Imagen> getAllImgs() {
        List<Imagen> imagenesList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableImagenes;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Imagen img = new Imagen();
                img.setPath((c.getString(c.getColumnIndex(idImagen))));
                // adding to todo list
                imagenesList.add(img);
            } while (c.moveToNext());
        }

        return imagenesList;
    }

    public List<Letra> getAllWordsXImg() {
        List<Letra> letrasList = new ArrayList<>();
        String selectQuery = "SELECT "+idPalabra+", "+idImagen+" FROM " +tablePalabrasImagenes +" WHERE LENGTH("+idPalabra+") <= 1 GROUP BY "+idPalabra+", "+idImagen+"" ;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Letra letr = new Letra();
                letr.setLetra(c.getString(c.getColumnIndex(idPalabra)));
                letr.setImgLetra(c.getString(c.getColumnIndex(idImagen)));
                c.move(1);
                letr.setImgSena(c.getString(c.getColumnIndex(idImagen)));

                // adding to todo list
                letrasList.add(letr);

            } while (c.moveToNext());
        }
        return letrasList;
    }

    public List<Palabra> getListLetters(Letra letra) {
        List<Palabra> palabrasList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tablePalabras +" WHERE "+idLetra+" = '"+letra.getLetra()+"'" ;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Palabra word = new Palabra();
                word.setPalabra(c.getString(c.getColumnIndex(idPalabra)));
                word.setLetra(c.getString(c.getColumnIndex(idLetra)));
                word.setVideo(c.getString(c.getColumnIndex(idVideo)));
                Log.e("tab",c.getString(c.getColumnIndex(idPalabra))+"--");
                // adding to todo list
                palabrasList.add(word);
            } while (c.moveToNext());
        }
        return palabrasList;
    }


    public Map<String,PalabraImagen> getListWordsImgXLet(Letra letra) {
        Map<String,PalabraImagen> mapwordXimg = new HashMap<String,PalabraImagen>();
        String selectQuery = "SELECT "+tablePalabrasImagenes+"."+idPalabra+ ", "+tablePalabrasImagenes+"."+idImagen+" "+
                " FROM " + tablePalabrasImagenes
                +" INNER JOIN "+tablePalabras+" ON  "+tablePalabrasImagenes+"."+idPalabra+" = "+tablePalabras+"."+idPalabra+" " +
                "WHERE "+idLetra+" = '"+letra.getLetra()+"'";
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                PalabraImagen wordImg = new PalabraImagen();
                String word = c.getString(c.getColumnIndex(idPalabra));
                wordImg.setPalabra(word);
                wordImg.setImg(c.getString(c.getColumnIndex(idImagen)));


                Log.e("tab",c.getString(c.getColumnIndex(idPalabra))+"");
                // adding to todo list
               mapwordXimg.put(word, wordImg);
            } while (c.moveToNext());
        }
        return mapwordXimg;
    }

    public Map<String,PalabraImagen> getListAllWordsXImg () {
        Map<String,PalabraImagen> mapwordXimg = new HashMap<String,PalabraImagen>();
        String selectQuery = "SELECT "+tablePalabrasImagenes+"."+idPalabra+ ", "+tablePalabrasImagenes+"."+idImagen+" "+
                " FROM " + tablePalabrasImagenes
                +" INNER JOIN "+tablePalabras+" ON  "+tablePalabrasImagenes+"."+idPalabra+" = "+tablePalabras+"."+idPalabra+" " ;

        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                PalabraImagen wordImg = new PalabraImagen();
                String word = c.getString(c.getColumnIndex(idPalabra));
                wordImg.setPalabra(word);
                wordImg.setImg(c.getString(c.getColumnIndex(idImagen)));


                Log.e("tab",c.getString(c.getColumnIndex(idPalabra))+"");
                // adding to todo list
                mapwordXimg.put(word, wordImg);
            } while (c.moveToNext());
        }
        return mapwordXimg;
    }

    public List<Palabra> getListAllWord() {
        List<Palabra> palabrasList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tablePalabras;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Palabra word = new Palabra();
                word.setPalabra(c.getString(c.getColumnIndex(idPalabra)));
                word.setLetra(c.getString(c.getColumnIndex(idLetra)));
               // word.setImg(c.getString(c.getColumnIndex(fkimgColumnP)));
                word.setVideo(c.getString(c.getColumnIndex(idVideo)));

                // adding to todo list
                palabrasList.add(word);
            } while (c.moveToNext());
        }
        return palabrasList;
    }

    public List<PalabraImagen> getListAllWordImg() {
        List<PalabraImagen> palabrasImgList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tablePalabrasImagenes;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                PalabraImagen wordImg = new PalabraImagen();
                wordImg.setPalabra(c.getString(c.getColumnIndex(idPalabra)));
                wordImg.setImg(c.getString(c.getColumnIndex(idImagen)));
                // adding to todo list
                palabrasImgList.add(wordImg);
            } while (c.moveToNext());
        }
        return palabrasImgList;
    }

    //=================================================
    //= Insert Values to database
    //=================================================

    /*
     * Creating a imagen
     */
    public long createImg(Imagen img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(idImagen, img.getPath());
        long img_id = db.insert(tableImagenes, null, values);
        return img_id;
    }

    /*
     * Creating a letter
     */
    public long createPalabraImg(PalabraImagen wordImg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(idImagen, wordImg.getImg());
        values.put(idPalabra, wordImg.getPalabra());

        long wordImg_id = db.insert(tablePalabrasImagenes, null, values);
        return wordImg_id;
    }

    /*
     * Creating a word
     */
    public long createWord(Palabra palabra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(idPalabra, palabra.getPalabra());
        values.put(idLetra, palabra.getLetra());
        values.put(idVideo, palabra.getVideo());

        long palabra_id = db.insert(tablePalabras, null, values);
        return palabra_id;
    }

    //=================================================
    //= Meotodos database
    //=================================================

    public boolean isTableExists(String nombreTabla) {
        boolean isExist = false;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + nombreTabla + "'", null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                isExist = true;
            }
            cursor.close();
        }
        return isExist;
    }

    public void deleteTable(String table){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + table);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
