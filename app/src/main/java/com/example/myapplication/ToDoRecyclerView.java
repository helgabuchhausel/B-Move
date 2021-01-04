package com.example.myapplication;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.time.chrono.ChronoZonedDateTime;
import java.util.ArrayList;

class ToDoRecyclerView extends RecyclerView.Adapter<ToDoRecyclerView.ViewHolder> {

    ArrayList<Item> allItems;

    ToDoRecyclerView(ArrayList<Item> allItems){
        this.allItems = allItems ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item currentItem = allItems.get(position);
        holder.getcBox().setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       CheckBox cBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cBox  = (CheckBox) itemView.findViewById(R.id.toDoCheckBox);

            cBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                }
            });

            cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(cBox.isChecked()){
                        cBox.setTextColor(Color.GRAY);}
                    else{
                        cBox.setTextColor(Color.WHITE);}
                }
            });
        }

        public CheckBox getcBox(){
            return cBox;
        }
    }
}
