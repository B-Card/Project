package com.example.buscard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MyAdapter4 extends FirebaseRecyclerAdapter<Model4,MyAdapter4.myviewholder4>
{
    public MyAdapter4(@NonNull FirebaseRecyclerOptions<Model4> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder4 holder, int position, @NonNull Model4 model4)
    {
        holder.date.setText(model4.getDate());
        holder.cardNo.setText(model4.getCardNo());
        holder.distance.setText(model4.getDistance());
        holder.fare.setText(model4.getFare());
        holder.startingPoint.setText(model4.getStartingPoint());
        holder.endingPoint.setText(model4.getEndingPoint());
    }

    @NonNull
    @Override
    public myviewholder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow4,parent,false);
        return new myviewholder4(view);
    }

    class myviewholder4 extends RecyclerView.ViewHolder
    {
        TextView date, cardNo, distance, fare, startingPoint, endingPoint;
        public myviewholder4(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.travelDateId);
            cardNo = itemView.findViewById(R.id.passengerCardNoId);
            distance = itemView.findViewById(R.id.travelDistanceId);
            fare = itemView.findViewById(R.id.busFareId);
            startingPoint = itemView.findViewById(R.id.passengerStartingPointId);
            endingPoint = itemView.findViewById(R.id.passengerEndingPointId);
        }
    }
}

