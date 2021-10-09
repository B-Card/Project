package com.example.buscard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class DriverDashboard extends AppCompatActivity {

    LinearLayout travelDetails,passengerDetails, passengerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_dashboard);

        travelDetails = findViewById(R.id.driverTravelDetailsId);
        passengerDetails= findViewById(R.id.driverPassengerDetailsId);
        passengerHistory= findViewById(R.id.driverPassengerTravelHistoryId);

        travelDetails.setOnClickListener(v -> {

            Intent intent = new Intent(DriverDashboard.this,DriverTravelDetails.class);
            startActivity(intent);

        });

        passengerDetails.setOnClickListener(v -> {

            Intent intent = new Intent(DriverDashboard.this,PassengerDetails.class);
            startActivity(intent);

        });

        passengerHistory.setOnClickListener(v -> {

            Intent intent = new Intent(DriverDashboard.this,DriverPassengerDetails.class);
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
            finish();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}