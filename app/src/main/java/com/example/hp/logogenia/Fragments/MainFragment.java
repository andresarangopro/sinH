package com.example.hp.logogenia.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hp.logogenia.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout llShowSenas,llShowDacti,llSReadWrite;
    private Button btnSenas,btnDactilogo,btnLeerEsc,btnDiccionario,btnPresentW;
    private boolean senas = true, dacti = true, leerEsc = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment

        init();
        return view;
    }

    private void init(){
        btnSenas = view.findViewById(R.id.btnSenas);
        btnDactilogo = view.findViewById(R.id.btnDactilogo);
        btnLeerEsc = view.findViewById(R.id.btnLeerEsc);
        btnDiccionario = view.findViewById(R.id.btnDiccionario);
        btnPresentW = view.findViewById(R.id.btnPresentW);
        llSReadWrite = view.findViewById(R.id.llSReadWrite);
        llShowSenas = view.findViewById(R.id.llShowSenas);
        llShowDacti = view.findViewById(R.id.llShowDacti);
        btnSenas.setOnClickListener(this);
        btnDactilogo.setOnClickListener(this);
        btnLeerEsc.setOnClickListener(this);
        btnDiccionario.setOnClickListener(this);
        btnPresentW.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int vista = view.getId();
        switch (vista){
            case R.id.btnSenas:{
               senas= goneVisible(llShowSenas,senas);
                break;
            }
            case R.id.btnDactilogo:{
               dacti =  goneVisible(llShowDacti,dacti);
                break;
            }
            case R.id.btnLeerEsc:{
               leerEsc =  goneVisible(llSReadWrite,leerEsc);
                break;
            }case R.id.btnDiccionario:{

                break;
            }case R.id.btnPresentW:{
                PresenteWFragment nextFrag= new PresenteWFragment();
                getActivity().getFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FrFragment, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();
                break;
            }
        }
    }

    private boolean goneVisible(LinearLayout ll, boolean estado){
        if(estado){
            estado = false;
            ll.setVisibility(View.VISIBLE);
        }else{
            estado = true;
            ll.setVisibility(View.GONE);
        }
        return estado;
    }
}
