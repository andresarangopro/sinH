package com.example.hp.logogenia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.logogenia.Clases.GridSpacingItemDecoration;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Clases.Palabra;
import com.example.hp.logogenia.Clases.PalabraImagen;
import com.example.hp.logogenia.Models.RALetters;
import com.example.hp.logogenia.Models.RAPalabras;
import com.example.hp.logogenia.R;
import com.example.hp.logogenia.Util.DbHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiccionarioFragment extends Fragment {

    private View view;
    private List<Palabra> wordsList;
    private RecyclerView recyclerView;
    private RAPalabras adapter;
    private DbHelper db;
    private Map<String,PalabraImagen> imagenXWord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_diccionario, container, false);
        init();
        prepare();
        return view;
    }

    private void init(){
        db = new DbHelper(view.getContext());
        imagenXWord = mapLetters();
        recyclerView = view.findViewById(R.id.rv_list_words);
        wordsList = new ArrayList<>();
        adapter = new RAPalabras(view.getContext(), wordsList, imagenXWord,getActivity(),getResources());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(10,getResources()), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void prepare(){
        List<Palabra> allWords = db.getListAllWord();

        for (Palabra palabra:allWords) {
            Palabra word = palabra;
            wordsList.add(word);
        }
        adapter.notifyDataSetChanged();
    }

    private Map<String,PalabraImagen> mapLetters(){
        Map<String,PalabraImagen> imagenXWord = db.getListAllWordsXImg();
        return imagenXWord;
    }

}
