package com.example.buscard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PassengerDashboard extends AppCompatActivity {

    LinearLayout applyForCard, cardRecharge, busDetails, travelHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_dashboard);

        applyForCard = findViewById(R.id.applyForCardId);
        cardRecharge= findViewById(R.id.cardRechargeId);
        busDetails = findViewById(R.id.busDetailsId);
        travelHistory = findViewById(R.id.travelHistoryId);

        applyForCard.setOnClickListener(v -> {

            Intent intent = new Intent(PassengerDashboard.this,CardApply.class);
            startActivity(intent);

        });

        cardRecharge.setOnClickListener(v -> {

            Intent intent = new Intent(PassengerDashboard.this,CardRecharge.class);
            startActivity(intent);

        });

        busDetails.setOnClickListener(v -> {

            Intent intent = new Intent(PassengerDashboard.this,BusDetails.class);
            startActivity(intent);

        });

        travelHistory.setOnClickListener(v -> {

            Intent intent = new Intent(PassengerDashboard.this,PreviousTravelDetails.class);
            startActivity(intent);

        });

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