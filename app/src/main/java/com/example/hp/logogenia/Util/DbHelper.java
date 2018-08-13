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
import com.example.hp.logogenia.Clases.Video;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Logog.db";

    public static final String tablePalabras = "palabras";
    public static final String tableLetras = "letras";
    public static final String tableImagenes= "imagenes";
    public static final String tableVideos = "videos";


    private static String palabraColumnP = "palabra";
    private static String fkLetra = "id_letra";
    private static String fkimgColumnP = "id_imagenP";
    private static String fkvideoColumnP = "id_video";

    private static String letraC = "letra";
    private static String fkimgColumnLl = "id_imagenLetra";
    private static String fkimgColumnLS = "id_imagenSena";

    private static String pathImg = "pathImagen";

    private static String pathVid = "pathVideo";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE " + tableImagenes + " ("
                + pathImg+ " VARCHAR(25) PRIMARY KEY NOT NULL"+  ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tableVideos + " ("
                + pathVid+ " VARCHAR(25) PRIMARY KEY NOT NULL"+ ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tableLetras + " ("
                + letraC + " VARCHAR(25) PRIMARY KEY NOT NULL,"
                + fkimgColumnLl+ " VARCHAR(25) NOT NULL,"
                + fkimgColumnLS + " VARCHAR(25) NOT NULL,"
                +"FOREIGN KEY("+fkimgColumnLl+")REFERENCES "+tableImagenes+"("+pathImg+")"+

                ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + tablePalabras + " ("
                + palabraColumnP + " TEXT PRIMARY KEY NOT NULL,"
                + fkLetra + " VARCHAR(25)  NOT NULL,"
                + fkimgColumnP+ " INTEGER NOT NULL,"
                + fkvideoColumnP+ " INTEGER NOT NULL,"
                +"FOREIGN KEY("+fkLetra+")REFERENCES "+tableLetras+"("+letraC+"),"
                +"FOREIGN KEY("+fkimgColumnP+")REFERENCES "+tableImagenes+"("+pathImg+"),"+
                "FOREIGN KEY("+fkvideoColumnP+")REFERENCES "+tableVideos+"("+pathVid+")"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + tableImagenes);
        sqLiteDatabase.execSQL("drop table if exists " + tableVideos);
        sqLiteDatabase.execSQL("drop table if exists " + tableLetras);
        sqLiteDatabase.execSQL("drop table if exists " + tablePalabras);
        onCreate(sqLiteDatabase);
    }

    public List<Palabra> findAll(){
        try {
            List<Palabra> listW = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ tablePalabras, null);
            if(cursor.moveToFirst()){
                Palabra palabra = new Palabra();
                palabra.setPalabra(cursor.getString(0));
                palabra.setLetra(cursor.getString(1));
                palabra.setImg(cursor.getString(2));
                palabra.setVideo(cursor.getString(3));
            }
            sqLiteDatabase.close();
            return listW;
        }catch (Exception e){
            return null;
        }

    }

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
                img.setPath((c.getString(c.getColumnIndex(pathImg))));

                // adding to todo list
                imagenesList.add(img);
            } while (c.moveToNext());
        }

        return imagenesList;
    }

    public List<Video> getAllVideos() {
        List<Video> videosList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableVideos;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Video vid = new Video();
                vid.setPath((c.getString(c.getColumnIndex(pathVid))));
                // adding to todo list
                videosList.add(vid);
            } while (c.moveToNext());
        }
        return videosList;
    }

    public List<Letra> getAllLetters() {
        List<Letra> letrasList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableLetras;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Letra letr = new Letra();
                letr.setLetra(c.getString(c.getColumnIndex(letraC)));
                letr.setImgLetra(c.getString(c.getColumnIndex(fkimgColumnLl)));
                letr.setImgSena(c.getString(c.getColumnIndex(fkimgColumnLS)));

                // adding to todo list
                letrasList.add(letr);
            } while (c.moveToNext());
        }
        return letrasList;
    }

    public List<Palabra> getListWords(Letra letra) {
        List<Palabra> palabrasList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tablePalabras +" WHERE "+fkLetra+" = '"+letra.getLetra()+"'" ;
        Log.e("LOG", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Palabra word = new Palabra();
                word.setPalabra(c.getString(c.getColumnIndex(palabraColumnP)));
                word.setLetra(c.getString(c.getColumnIndex(fkLetra)));
                word.setImg(c.getString(c.getColumnIndex(fkimgColumnP)));
                word.setVideo(c.getString(c.getColumnIndex(fkvideoColumnP)));

                // adding to todo list
                palabrasList.add(word);
            } while (c.moveToNext());
        }
        return palabrasList;
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
                word.setPalabra(c.getString(c.getColumnIndex(palabraColumnP)));
                word.setLetra(c.getString(c.getColumnIndex(fkLetra)));
                word.setImg(c.getString(c.getColumnIndex(fkimgColumnP)));
                word.setVideo(c.getString(c.getColumnIndex(fkvideoColumnP)));

                // adding to todo list
                palabrasList.add(word);
            } while (c.moveToNext());
        }
        return palabrasList;
    }

    /*
     * Creating a imagen
     */
    public long createImg(Imagen img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(pathImg, img.getPath());
        // insert row
        long img_id = db.insert(tableImagenes, null, values);
        return img_id;
    }
    /*
     * Creating a video
     */
    public long createVideo(Video video) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(pathVid, video.getPath());
        // insert row
        long video_id = db.insert(tableVideos, null, values);
        return video_id;
    }

    /*
     * Creating a letter
     */
    public long createLetra(Letra letra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(letraC, letra.getLetra());
        values.put(fkimgColumnLl, letra.getImgLetra());
        values.put(fkimgColumnLS, letra.getImgSena());
        // insert row
        long letra_id = db.insert(tableLetras, null, values);
        return letra_id;
    }

    /*
     * Creating a word
     */
    public long createWord(Palabra palabra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(palabraColumnP, palabra.getPalabra());
        values.put(fkLetra, palabra.getLetra());
        values.put(fkimgColumnP, palabra.getImg());
        values.put(fkvideoColumnP, palabra.getVideo());
        // insert row
        long palabra_id = db.insert(tablePalabras, null, values);
        return palabra_id;
    }

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
