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

public class PreviousTravelDetails extends AppCompatActivity
{
    RecyclerView recview4;
    MyAdapter4 adapter4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_travel_details);

        recview4=findViewById(R.id.recViewPreviousTravelDetailsId);
        recview4.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Model4> options =
                new FirebaseRecyclerOptions.Builder<Model4>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("journey"), Model4.class)
                        .build();

        adapter4 = new MyAdapter4(options);
        recview4.setAdapter(adapter4);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter4.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter4.stopListening();
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