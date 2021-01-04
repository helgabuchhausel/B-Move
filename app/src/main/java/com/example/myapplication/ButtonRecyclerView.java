package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ButtonRecyclerView extends RecyclerView.Adapter<ButtonRecyclerView.ViewHolder> {


    private ArrayList<Buttons> allButtons;
    private Context ctx;


    public ButtonRecyclerView(Context context, ArrayList<Buttons> buttons){
        ctx = context;
        allButtons =  buttons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Buttons currentButton = allButtons.get(position);
        holder.getButton().setText(currentButton.getName());

        holder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nextFragment = currentButton.getFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)ctx).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFrameLayout , nextFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        });
    }



    @Override
    public int getItemCount() {
        return allButtons.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final Button button1;
        View rootView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button1 = (Button) itemView.findViewById(R.id.buttonButton);
            rootView = itemView;

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("button", "The button is clicked");


                }
            });
        }

        public Button getButton(){
            return button1;
        }


    }
}
