package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.FragmentTransitionSupport;

import java.util.ArrayList;

class PhotoWithDescAdapter extends RecyclerView.Adapter<PhotoWithDescAdapter.ViewHolder> implements View.OnClickListener  {

    private ArrayList<City> cities;

    public PhotoWithDescAdapter(ArrayList<City> Cities){
        cities = Cities;
    }

    @Override
    public void onClick(View view) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView nameTextView;
        private final TextView populationTextView;
        private final ImageView cityImageView;
        private final View rootView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            this.populationTextView = (TextView) itemView.findViewById(R.id.populationTextView);
            this.cityImageView = (ImageView) itemView.findViewById(R.id.cityImageView);
            this.rootView = itemView;

        }

        public TextView getNameTextView() {
            return nameTextView;
        }
        public TextView getPopulationTextView() {
            return populationTextView;
        }
        public ImageView getCityImageView() {
            return cityImageView;
        }
        public View getRootView(){return rootView;};
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_and_desc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final City currentCity = cities.get(position);
        holder.getNameTextView().setText(currentCity.getName());
        holder.getPopulationTextView().setText(currentCity.getPopulation()+"");
        holder.getCityImageView().setImageURI(currentCity.getImage());
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("card", "The card is clicked" + currentCity.getWebsite().toString());

            }
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

}
