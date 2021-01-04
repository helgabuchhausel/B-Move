package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>  implements View.OnClickListener {

    private ArrayList<Card> cards;

    public CardAdapter(ArrayList<Card> Cards){
        cards = Cards;
    }

    @Override
    public void onClick(View view) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final View rootView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titelTextView);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            this.rootView = itemView;

        }

        public TextView getTitleTextView() {return titleTextView;}
        public TextView getDescriptionTextView() {return descriptionTextView;}
        public View getRootView(){return rootView;};

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Card currentCard = cards.get(position);
        holder.getTitleTextView().setText( currentCard.getName());
        holder.getDescriptionTextView().setText(currentCard.getDescription());

        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("card", "The card is clicked" + currentCard.getWebsite().toString());

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(currentCard.getWebsite()));
                // startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }


}

