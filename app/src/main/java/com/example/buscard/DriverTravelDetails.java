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
import com.google.firebase.database.FirebaseDatabase;

public class DriverTravelDetails extends AppCompatActivity {

    RecyclerView recview3;
    MyAdapter3 adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_travel_details);

        recview3=findViewById(R.id.recViewDriverBusId);
        recview3.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Model2> options =
                new FirebaseRecyclerOptions.Builder<Model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("buses").orderByChild("driverName").equalTo("Yousuf Hossan"), Model2.class)
                        .build();

        adapter3 = new MyAdapter3(options);
        recview3.setAdapter(adapter3);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter3.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter3.stopListening();
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
            startActivity ( new Intent ( getApplicationContext (), Login.class ) );
            finish ();

        }
        return super.onOptionsItemSelected(item);
    }
}