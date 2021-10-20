package com.example.buscard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class HistoryAdapter extends FirebaseRecyclerAdapter<History,HistoryAdapter.historyviewholder>
{
    public HistoryAdapter(@NonNull FirebaseRecyclerOptions<History> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull historyviewholder holder, int position, @NonNull History history)
    {
        holder.cardNo.setText(history.getCardNo());
        holder.date.setText(history.getDate());
        holder.distance.setText(history.getDistance());
        holder.endingPoint.setText(history.getEndingPoint());
        holder.fare.setText(history.getFare());
        holder.startingPoint.setText(history.getStartingPoint());
    }

    @NonNull
    @Override
    public historyviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.historyrow,parent,false);
        return new historyviewholder(view);
    }

    class historyviewholder extends RecyclerView.ViewHolder
    {
        TextView cardNo, date, distance, endingPoint, fare, startingPoint;
        public historyviewholder(@NonNull View itemView) {
            super(itemView);
            cardNo = itemView.findViewById(R.id.cardNoId);
            cardNo = itemView.findViewById(R.id.dateId);
            cardNo = itemView.findViewById(R.id.distanceId);
            cardNo = itemView.findViewById(R.id.endingPointId);
            cardNo = itemView.findViewById(R.id.fareId);
            cardNo = itemView.findViewById(R.id.startingPointId);
        }
    }
}