package com.example.buscard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MyAdapter2 extends FirebaseRecyclerAdapter<Model2,MyAdapter2.myviewholder2>
{
    public MyAdapter2(@NonNull FirebaseRecyclerOptions<Model2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder2 holder, int position, @NonNull Model2 model2)
    {
        holder.routeName.setText(model2.getRouteName());
        holder.busName.setText(model2.getBusName());
        holder.busNO.setText(model2.getBusNO());
        holder.busTime.setText(model2.getBusTime());
        holder.driverName.setText(model2.getDriverName());
    }

    @NonNull
    @Override
    public myviewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        return new myviewholder2(view);
    }

    class myviewholder2 extends RecyclerView.ViewHolder
    {
        TextView routeName, busName, busNO, busTime, driverName;
        public myviewholder2(@NonNull View itemView) {
            super(itemView);
            routeName = itemView.findViewById(R.id.rNameId);
            busName = itemView.findViewById(R.id.bNameId);
            busNO = itemView.findViewById(R.id.bNoId);
            busTime = itemView.findViewById(R.id.bTimeId);
            driverName = itemView.findViewById(R.id.bDriverNameId);
        }
    }
}

