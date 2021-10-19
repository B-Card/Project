package com.example.buscard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MyAdapter extends FirebaseRecyclerAdapter<Model,MyAdapter.myviewholder>
{
    public MyAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Model model)
    {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.birthDate.setText(model.getBirthDate());
        holder.nid.setText(model.getNid());
        holder.address.setText(model.getAddress());
        holder.mobileNo.setText(model.getMobileNo());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name, email, birthDate, nid, address, mobileNo;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameId);
            email = itemView.findViewById(R.id.emailId);
            birthDate = itemView.findViewById(R.id.dateOfBirthId);
            nid = itemView.findViewById(R.id.nidId);
            address = itemView.findViewById(R.id.addressId);
            mobileNo = itemView.findViewById(R.id.mobileNoId);
        }
    }
}

