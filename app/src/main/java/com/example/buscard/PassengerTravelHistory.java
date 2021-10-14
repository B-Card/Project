package com.example.buscard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PassengerTravelHistory extends AppCompatActivity {

    RecyclerView recViewPassengerTravelHistory;
    MyAdapter3 adapterPassengerTravelHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_travel_history);

        recViewPassengerTravelHistory=findViewById(R.id.recViewPassengerTravelHistoryId);
        recViewPassengerTravelHistory.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Model3> options =
                new FirebaseRecyclerOptions.Builder<Model3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("journey").orderByChild("cardNo").equalTo("1111117645"), Model3.class)
                        .build();

        adapterPassengerTravelHistory = new MyAdapter3(options);
        recViewPassengerTravelHistory.setAdapter(adapterPassengerTravelHistory);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterPassengerTravelHistory.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterPassengerTravelHistory.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.signoutmenu){

            FirebaseAuth.getInstance().signOut();
            startActivity ( new Intent( getApplicationContext (), Login.class ) );
            finish ();

        }
        return super.onOptionsItemSelected(item);
    }
}