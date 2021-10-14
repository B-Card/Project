package com.example.buscard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;


public class MyAdapter3 extends FirebaseRecyclerAdapter<Model3,MyAdapter3.myviewholder3>
{

    public MyAdapter3(@NonNull FirebaseRecyclerOptions<Model3> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder3 holder, int position, @NonNull Model3 model3)
    {
        holder.date.setText(model3.getDate());
        holder.cardNo.setText(model3.getCardNo());
        holder.fare.setText(model3.getFare());
        holder.distance.setText(model3.getDistance());
        holder.startingPoint.setText(model3.getStartingPoint());
        holder.endingPoint.setText(model3.getEndingPoint());
    }

    @NonNull
    @Override
    public myviewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow3,parent,false);
        return new myviewholder3(view);
    }

    class myviewholder3 extends RecyclerView.ViewHolder
    {
        TextView date, cardNo, fare, distance, startingPoint, endingPoint;
        public myviewholder3(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateId);
            cardNo = itemView.findViewById(R.id.cardNoId);
            fare = itemView.findViewById(R.id.fareAmountId);
            distance = itemView.findViewById(R.id.distanceId);
            startingPoint = itemView.findViewById(R.id.startingPointId);
            endingPoint = itemView.findViewById(R.id.endingPointId);
        }
    }
}

