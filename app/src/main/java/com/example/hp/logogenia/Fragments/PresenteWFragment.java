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
import com.example.hp.logogenia.Util.DbHelper;
import com.example.hp.logogenia.Models.RALetters;
import com.example.hp.logogenia.R;

import java.util.ArrayList;
import java.util.List;


public class PresenteWFragment extends Fragment {

    private View view;
    private List<Letra> letraList;
    private RecyclerView recyclerView;
    private RALetters adapter;
    private DbHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_presente_w, container, false);
        init();
        prepare();
        return view;
    }

    private void init(){
        recyclerView = view.findViewById(R.id.rv_list_letter);
        letraList = new ArrayList<>();
        adapter = new RALetters(view.getContext(), letraList, getActivity(),getResources());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(10,getResources()), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        db = new DbHelper(view.getContext());
    }

    private void prepare(){
        List<Letra> allLetters = db.getAllLetters();

        for (Letra letra:allLetters) {
            Letra letr = letra;
            letraList.add(letr);
        }
        adapter.notifyDataSetChanged();
    }






}
