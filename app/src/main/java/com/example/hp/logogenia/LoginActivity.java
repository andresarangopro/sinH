package com.example.hp.logogenia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.logogenia.Util.DbHelper;
import com.example.hp.logogenia.Util.PrepareData;

import static com.example.hp.logogenia.Util.DbHelper.tableImagenes;
import static com.example.hp.logogenia.Util.DbHelper.tableLetras;
import static com.example.hp.logogenia.Util.DbHelper.tablePalabras;
import static com.example.hp.logogenia.Util.DbHelper.tablePalabrasImagenes;
import static com.example.hp.logogenia.Util.DbHelper.tableVideos;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DbHelper db;
    private PrepareData prepareData;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        db = new DbHelper(this);
        prepareData = new PrepareData(db);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    private void prepareD(){
        if(db.isTableExists(tableImagenes)){
            if(db.getAllImgs().size() <= 0){
                prepareData.putImgsInDB();
            }
        }

       if(db.isTableExists(tablePalabras)){
           if(db.getListAllWord().size() <= 0){
               prepareData.putPalabrasInDB();
           }
       }

        if(db.isTableExists(tablePalabrasImagenes)){
            if(db.getListAllWordImg().size() <= 0){
                 prepareData.putPalabraImagenInDB();
            }
        }
    }


    @Override
    public void onClick(View view) {
        int v = view.getId();
        switch (v){
            case R.id.btnLogin:{
                prepareD();
                startActivity(new Intent(this, NavigationActivity.class));
                break;
            }
        }
    }
}
