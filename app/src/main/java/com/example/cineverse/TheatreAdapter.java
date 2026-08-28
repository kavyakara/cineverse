package com.example.cineverse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheatreAdapter extends RecyclerView.Adapter<TheatreAdapter.ViewHolder> {

    private List<Theatre> theatreList;

    public TheatreAdapter(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.theatre_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Theatre theatre = theatreList.get(position);

        holder.txtTheatreName.setText(theatre.getName());
        holder.txtInfo.setText(theatre.getInfo());

        holder.btnTime1.setText(theatre.getTime1());
        holder.btnTime2.setText(theatre.getTime2());
        holder.btnTime3.setText(theatre.getTime3());
    }

    @Override
    public int getItemCount() {
        return theatreList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTheatreName;
        TextView txtInfo;

        Button btnTime1;
        Button btnTime2;
        Button btnTime3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTheatreName = itemView.findViewById(R.id.txtTheatreName);
            txtInfo = itemView.findViewById(R.id.txtInfo);

            btnTime1 = itemView.findViewById(R.id.btnTime1);
            btnTime2 = itemView.findViewById(R.id.btnTime2);
            btnTime3 = itemView.findViewById(R.id.btnTime3);
        }
    }
}