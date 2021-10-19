package com.example.buscard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class MyAdapter5 extends FirebaseRecyclerAdapter<Model5, MyAdapter5.myviewholder5> {

    public MyAdapter5(FirebaseRecyclerOptions<Model5> options) { super(options); }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder5 holder, int position, @NonNull Model5 model5) {

        holder.cardNo.setText(model5.getCardNo());
        holder.date.setText(model5.getDate());
        holder.distance.setText(model5.getDistance());
        holder.endingPoint.setText(model5.getEndingPoint());
        holder.fare.setText(model5.getFare());
        holder.startingPoint.setText(model5.getStartingPoint());

    }

    @NonNull
    @Override
    public myviewholder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow5, parent, false);
        return new myviewholder5(view);
    }

    static class myviewholder5 extends RecyclerView.ViewHolder {

        TextView cardNo, date, distance, endingPoint, fare, startingPoint;

        public myviewholder5(@NonNull View itemView) {
            super(itemView);
            cardNo = itemView.findViewById(R.id.passengerCardNoId);
            date = itemView.findViewById(R.id.travelDateId);
            distance = itemView.findViewById(R.id.travelDistanceId);
            endingPoint = itemView.findViewById(R.id.passengerEndingPointId);
            fare = itemView.findViewById(R.id.busFareId);
            startingPoint = itemView.findViewById(R.id.passengerStartingPointId);
        }
    }
}

