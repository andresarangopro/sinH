package com.example.hp.logogenia.Models;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.Clases.Palabra;
import com.example.hp.logogenia.Clases.PalabraImagen;
import com.example.hp.logogenia.Fragments.PalabrasFragment;
import com.example.hp.logogenia.R;

import java.util.List;
import java.util.Map;

public class RAPalabras  extends RecyclerView.Adapter<RAPalabras.ViewHolder>{


    /////////////////////////
    //Variables
    ///////////////////////

    private Context mContext;
    private List<Palabra> mData;
    private Map<String, PalabraImagen> imagenXWord;
    private FragmentActivity fragmentActivity;
    private Bundle args = new Bundle();
    private Resources resources;
    /////////////////////////
    //Constructores
    ///////////////////////

    public static class ViewHolder extends RecyclerView.ViewHolder{
        /**********************
         * Variables
         **********************/
        TextView tvWord;
        ImageView iVWord;
        View thisView;

        /**********************
         * Constructores
         **********************/
        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
            iVWord = itemView.findViewById(R.id.iVWord);
            thisView = itemView;
        }
    }

    public RAPalabras(Context context, List<Palabra> mData,Map<String, PalabraImagen> imagenXWord,FragmentActivity fragmentActivity,Resources resources){
        this.mContext = context;
        this.mData = mData;
        this.imagenXWord = imagenXWord;
        this.fragmentActivity = fragmentActivity;
        this.resources = resources;
    }

    /////////////////////////
    //Metodos
    ///////////////////////

    @NonNull
    @Override
    public RAPalabras.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.rv_list_words,parent,false);
        return new RAPalabras.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RAPalabras.ViewHolder holder, int position) {
        final  Palabra palabra = mData.get(position);
        holder.tvWord.setText(palabra.getPalabra());
        int imgPalabra = resources.getIdentifier(imagenXWord.get(palabra.getPalabra()).getImg(), "drawable", fragmentActivity.getPackageName());
        Glide.with(mContext).load(imgPalabra).into(holder.iVWord);
      //  Toast.makeText(mContext, palabra.getPalabra()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
