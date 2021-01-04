package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>  implements View.OnClickListener {

    private ArrayList<String> localDataSet;


    public ListAdapter(ArrayList<String> dataSet){
        localDataSet = dataSet;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.randomText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//
                }
            });
        }


        public TextView getTextView() {
            return textView;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(localDataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



    @Override
    public void onClick(View view) {


    }
}
