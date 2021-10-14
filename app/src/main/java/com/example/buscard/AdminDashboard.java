package com.example.buscard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity {

    LinearLayout addBusRouteDriver, passengerDetails, passengerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        addBusRouteDriver = findViewById(R.id.addBusDriverRouteId);
        passengerDetails = findViewById(R.id.adminPassengerDetailsId);
        passengerHistory = findViewById(R.id.adminPassengerHistoryId);

        addBusRouteDriver.setOnClickListener(v -> {

            Intent intent = new Intent(AdminDashboard.this,AddBuses.class);
            startActivity(intent);

        });

        passengerDetails.setOnClickListener(v -> {

            Intent intent = new Intent(AdminDashboard.this,PassengerDetails.class);
            startActivity(intent);

        });
        passengerHistory.setOnClickListener(v -> {

            Intent intent = new Intent(AdminDashboard.this,TravelHistory.class);
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