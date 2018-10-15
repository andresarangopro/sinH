package com.example.hp.logogenia.Fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Clases.Palabra;
import com.example.hp.logogenia.Clases.PalabraImagen;
import com.example.hp.logogenia.Util.DbHelper;
import com.example.hp.logogenia.R;

import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PalabrasFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Button btnPlay,btnPause, btnStop, btnRepeat, btnNext, btnPrevious;
    private VideoView video;
    private TextView tVPalabra;
    private ImageView iVPalabra;
    private Bundle args;
    private Letra letr;
    private List<Palabra> listPalabras;
    private Map<String,PalabraImagen> imagenXWord;
    private int count = 0;
    private DbHelper db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_palabras, container, false);
        init();
        return view;
    }

    private void init(){
        db = new DbHelper(view.getContext());

        //Obtenemos los botones de la interfaz
        btnPlay= view.findViewById(R.id.btnPlay);
        btnStop= view.findViewById(R.id.btnStop);
        btnPause= view.findViewById(R.id.btnPause);
        btnRepeat= view.findViewById(R.id.btnRepeat);
        btnNext= view.findViewById(R.id.btnNext);
        btnPrevious= view.findViewById(R.id.btnPrevious);
        video= view.findViewById(R.id.vVSena);
        tVPalabra = view.findViewById(R.id.tvPalabra);
        iVPalabra = view.findViewById(R.id.iVPalabra);

        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnRepeat.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnPrevious.setEnabled(false);
        args = getArguments();
        letr = (Letra) args.getSerializable("letr");
        listPalabras = prube();
        imagenXWord = mapLetters();
        if(listPalabras.size() > 0) {
            nextWord(count);
        }
    }

    @Override
    public void onClick(View view) {
        int vista = view.getId();
        switch (vista){
            case R.id.btnPlay:{
                video.start();
                break;
            }case R.id.btnPause:{
                video.pause();
                break;
            }case R.id.btnStop:{
                video.stopPlayback();
                video.seekTo(0);
                putStRe();
                break;
            }case R.id.btnRepeat:{
                video.stopPlayback();
                video.seekTo(0);
                putStRe();
                video.start();
                break;
            }case R.id.btnNext:{
                if(count < listPalabras.size()-1){
                    count++;
                    btnPrevious.setEnabled(true);
                    nextWord(count);
                }else{
                    btnNext.setEnabled(false);
                    Toast.makeText(view.getContext(), "No tenemos más palabras con la letra "+letr.getLetra()+" ayudanos creando las tuyas!", Toast.LENGTH_SHORT).show();
                }

                break;
            }case R.id.btnPrevious:{
                if(count > 0){
                    count--;
                    nextWord(count);
                    btnNext.setEnabled(true);
                }else{
                    btnPrevious.setEnabled(false);
                    Toast.makeText(view.getContext(), "No puede regresar más"+" !", Toast.LENGTH_SHORT).show();
                }

                break;
            }
        }
    }

    private List<Palabra> prube(){
        List<Palabra> llWords = db.getListLetters(letr);
        return llWords;
    }
    private Map<String,PalabraImagen> mapLetters(){
        Map<String,PalabraImagen> imagenXWord = db.getListWordsImgXLet(letr);
        return imagenXWord;
    }

    private void nextWord(int count){
        Log.e("w",listPalabras.get(count).getPalabra());
        int imglet = getResources().getIdentifier(imagenXWord.get(listPalabras.get(count).getPalabra()).getImg() , "drawable", getActivity().getPackageName());
        int videoDraw = getResources().getIdentifier(listPalabras.get(count).getVideo(), "raw", getActivity().getPackageName());
        String pathVideo = "android.resource://" + getActivity().getPackageName() + "/" + videoDraw;

        video.setVideoURI(Uri.parse(pathVideo));
        Glide.with(view.getContext()).load(imglet).into(iVPalabra);
        tVPalabra.setText(listPalabras.get(count).getPalabra());
        video.start();
    }

    private void putStRe(){
        int videoDraw = getResources().getIdentifier(listPalabras.get(count).getVideo(), "raw", getActivity().getPackageName());
        String pathVideo = "android.resource://" + getActivity().getPackageName() + "/" + videoDraw;
        video.setVideoPath(pathVideo);
    }
}
