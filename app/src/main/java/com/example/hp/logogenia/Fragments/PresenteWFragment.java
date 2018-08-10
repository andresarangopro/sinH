package com.example.hp.logogenia.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.logogenia.Clases.GridSpacingItemDecoration;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Models.RALetters;
import com.example.hp.logogenia.R;

import java.util.ArrayList;
import java.util.List;


public class PresenteWFragment extends Fragment {

    private View view;
    private List<Letra> letraList;
    private RecyclerView recyclerView;
    private RALetters adapter;
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
        adapter = new RALetters(view.getContext(), letraList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(10,getResources()), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void prepare(){
       // int a = getResources().getIdentifier("@drawable/a", "drawable", getActivity().getPackageName());
        int[] imgLetter = new int []{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z

        };

        int[] imgSena = new int []{
            R.drawable.as,
            R.drawable.bs,
            R.drawable.cs,
            R.drawable.ds,
            R.drawable.es,
            R.drawable.fs,
            R.drawable.gs,
            R.drawable.hs,
            R.drawable.is,
            R.drawable.js,
            R.drawable.ks,
            R.drawable.ls,
            R.drawable.ms,
            R.drawable.ns,
            R.drawable.os,
            R.drawable.ps,
            R.drawable.qs,
            R.drawable.rs,
            R.drawable.ss,
            R.drawable.ts,
            R.drawable.us,
            R.drawable.vs,
            R.drawable.ws,
            R.drawable.xs,
            R.drawable.ys,
            R.drawable.zs

        };

        Letra a = new Letra(getResources().getString(R.string.str_a), imgLetter[0],imgSena[0]);
        Letra b = new Letra(getResources().getString(R.string.str_b), imgLetter[1],imgSena[1]);
        Letra c = new Letra(getResources().getString(R.string.str_c), imgLetter[2],imgSena[2]);
        Letra d = new Letra(getResources().getString(R.string.str_d), imgLetter[3],imgSena[3]);
        Letra e = new Letra(getResources().getString(R.string.str_e), imgLetter[4],imgSena[4]);
        Letra f = new Letra(getResources().getString(R.string.str_f), imgLetter[5],imgSena[5]);
        Letra g = new Letra(getResources().getString(R.string.str_g), imgLetter[6],imgSena[6]);
        Letra h = new Letra(getResources().getString(R.string.str_h), imgLetter[7],imgSena[7]);
        Letra i = new Letra(getResources().getString(R.string.str_i), imgLetter[8],imgSena[8]);
        Letra j = new Letra(getResources().getString(R.string.str_j), imgLetter[9],imgSena[9]);
        Letra k = new Letra(getResources().getString(R.string.str_k), imgLetter[10],imgSena[10]);
        Letra l = new Letra(getResources().getString(R.string.str_l), imgLetter[11],imgSena[11]);
        Letra m = new Letra(getResources().getString(R.string.str_m), imgLetter[12],imgSena[12]);
        Letra n = new Letra(getResources().getString(R.string.str_n), imgLetter[13],imgSena[13]);
        Letra o = new Letra(getResources().getString(R.string.str_o), imgLetter[14],imgSena[14]);
        Letra p = new Letra(getResources().getString(R.string.str_p), imgLetter[15],imgSena[15]);
        Letra q = new Letra(getResources().getString(R.string.str_q), imgLetter[16],imgSena[16]);
        Letra r = new Letra(getResources().getString(R.string.str_r), imgLetter[17],imgSena[17]);
        Letra s= new Letra(getResources().getString(R.string.str_s), imgLetter[18],imgSena[18]);
        Letra t = new Letra(getResources().getString(R.string.str_t), imgLetter[19],imgSena[19]);
        Letra u = new Letra(getResources().getString(R.string.str_u), imgLetter[20],imgSena[20]);
        Letra v = new Letra(getResources().getString(R.string.str_v), imgLetter[21],imgSena[21]);
        Letra w = new Letra(getResources().getString(R.string.str_w), imgLetter[22],imgSena[22]);
        Letra x = new Letra(getResources().getString(R.string.str_x), imgLetter[23],imgSena[23]);
        Letra y = new Letra(getResources().getString(R.string.str_y), imgLetter[24],imgSena[24]);
        Letra z = new Letra(getResources().getString(R.string.str_z), imgLetter[25],imgSena[25]);

        letraList.add(a);
        letraList.add(b);
        letraList.add(c);
        letraList.add(d);
        letraList.add(e);
        letraList.add(f);
        letraList.add(g);
        letraList.add(h);
        letraList.add(i);
        letraList.add(j);
        letraList.add(k);
        letraList.add(l);
        letraList.add(m);
        letraList.add(n);
        letraList.add(o);
        letraList.add(p);
        letraList.add(q);
        letraList.add(r);
        letraList.add(s);
        letraList.add(t);
        letraList.add(u);
        letraList.add(v);
        letraList.add(w);
        letraList.add(x);
        letraList.add(y);
        letraList.add(z);


        adapter.notifyDataSetChanged();
    }






}
