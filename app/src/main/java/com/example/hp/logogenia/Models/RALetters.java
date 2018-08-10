package com.example.hp.logogenia.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hp.logogenia.Clases.Letra;
import com.example.hp.logogenia.R;

import java.util.List;

public class RALetters extends RecyclerView.Adapter<RALetters.ViewHolder> {

    /////////////////////////
    //Variables
    ///////////////////////

    private Context mContext;
    private List<Letra> mData;
    /////////////////////////
    //Constructores
    ///////////////////////

    public static class ViewHolder extends RecyclerView.ViewHolder{
        /**********************
         * Variables
         **********************/
        TextView tvLetter;
        ImageView iVLetter,iVSena;
        View thisView;

        /**********************
         * Constructores
         **********************/
        public ViewHolder(View itemView) {
            super(itemView);
            tvLetter = itemView.findViewById(R.id.tvLetter);
            iVLetter = itemView.findViewById(R.id.iVLetter);
            iVSena = itemView.findViewById(R.id.iVSena);
            thisView = itemView;
        }
    }

    public RALetters(Context context, List<Letra> mData){
        this.mContext = context;
        this.mData = mData;
    }

    /////////////////////////
    //Metodos
    ///////////////////////

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.rv_list_letters,parent,false);
        return new RALetters.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Letra letra = mData.get(position);
        holder.tvLetter.setText(letra.getLetra());
        Glide.with(mContext).load(letra.getImgLetra()).into(holder.iVLetter);
        Glide.with(mContext).load(letra.getImgSena()).into(holder.iVSena);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, letra.getLetra(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
