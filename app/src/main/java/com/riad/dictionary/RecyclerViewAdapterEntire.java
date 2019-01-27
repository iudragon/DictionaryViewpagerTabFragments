package com.riad.dictionary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerViewAdapterEntire extends RecyclerView.Adapter<RecyclerViewAdapterEntire.EntireViewHolder> {

    private ArrayList<Entire> entires;
    private Context context;

    public RecyclerViewAdapterEntire(Context context, ArrayList<Entire> entires) {
        this.entires = entires;
        this.context = context;
    }

    public  class EntireViewHolder extends RecyclerView.ViewHolder {
        TextView enWord;
        TextView enDef;


        public EntireViewHolder(View v) {
            super(v);
            enWord = (TextView) v.findViewById(R.id.en_word);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    String text = entires.get(position).get_en_word();

                    Intent intent = new Intent(context, WordMeaningActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("en_word", text);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }


    @Override
    public EntireViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entire_item_layout, parent, false);
        return new EntireViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EntireViewHolder holder, final int position) {
        holder.enWord.setText(entires.get(position).get_en_word());

    }

    @Override
    public int getItemCount() {
        return entires.size();
    }
}
