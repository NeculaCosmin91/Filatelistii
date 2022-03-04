package com.example.filatelistii;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventRVAdapter extends RecyclerView.Adapter<EventRVAdapter.ViewHolder> {


    private ArrayList<EventModalClass> eventModalArrayList;
    private Context context;


    public EventRVAdapter(ArrayList<EventModalClass> eventModalArrayList, Context context) {
        this.eventModalArrayList = eventModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_rv_modal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EventModalClass modal = eventModalArrayList.get(position);
        holder.nameTV.setText(modal.getName());
        holder.adresaTV.setText(modal.getAdresa());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(context, UpdateEvenimente.class);


                i.putExtra("name", modal.getName());
                i.putExtra("adresa", modal.getAdresa());



                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return eventModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView nameTV, adresaTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.idTVCourseName);
            adresaTV = itemView.findViewById(R.id.idTVCourseTracks);
        }
    }
}