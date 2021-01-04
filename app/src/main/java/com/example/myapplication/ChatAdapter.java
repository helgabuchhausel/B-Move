package com.example.myapplication;

import android.graphics.Color;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{

    private ArrayList<Msg> allMsgs = new ArrayList<>();

    public ChatAdapter (ArrayList<Msg> msgs){
        allMsgs = msgs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView senderTextView;
        TextView msgTextView;
        TextView timeStapTextView;

        public ViewHolder(View v) {
            super(v);
            senderTextView = (TextView) itemView.findViewById(R.id.senderTextView);
            msgTextView = (TextView) itemView.findViewById(R.id.msgTextView);
            timeStapTextView = (TextView) itemView.findViewById(R.id.timeStapTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("msg", "The msg is clicked");
                }
            });
        }


        public TextView getSenderTextView(){ return senderTextView;}
        public TextView getMsgTextView(){return msgTextView;}
        public TextView getTimeStapTextView(){return timeStapTextView;}


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg currentMsg = allMsgs.get(position);

        holder.getSenderTextView().setText(currentMsg.getText());
        holder.getMsgTextView().setText(currentMsg.getName());
        holder.getTimeStapTextView().setText(currentMsg.getMessageTime());
    }

    @Override
    public int getItemCount() {
        return allMsgs.size();
    }



}
