package com.example.buscard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBuses extends AppCompatActivity {

    EditText bName, bNo, rName, dName, bTime;
    Button addButton;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buses);

        bName = findViewById(R.id.busNameId);
        bNo = findViewById(R.id.busNoId);
        rName = findViewById(R.id.routeNameId);
        dName = findViewById(R.id.driverNameId);
        bTime = findViewById(R.id.busTimeId);
        addButton = findViewById(R.id.addBusButtonId);
        progressBar = findViewById(R.id.progressBarId);

        databaseReference = FirebaseDatabase.getInstance().getReference("buses");

        addButton.setOnClickListener(view -> addData());
    }

    public void addData() {

        String busName = bName.getText().toString().trim();
        String busNo = bNo.getText().toString().trim();
        String routeName = rName.getText().toString().trim();
        String driverName = dName.getText().toString().trim();
        String busTime = bTime.getText().toString().trim();

        if(busName.isEmpty())
        {
            bName.setError("Enter bus name");
            bName.requestFocus();
        }

        if(busNo.isEmpty())
        {
            bNo.setError("Enter bus number");
            bNo.requestFocus();
        }

        if(routeName.isEmpty())
        {
            rName.setError("Enter route name");
            rName.requestFocus();
        }

        if(driverName.isEmpty())
        {
            dName.setError("Enter driver name");
            dName.requestFocus();
        }

        if(busTime.isEmpty())
        {
            bTime.setError("Enter bus time");
            bTime.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        String key = databaseReference.push().getKey();

        Bus bus = new Bus(busName, busNo, routeName, driverName, busTime);

        databaseReference.child(key).setValue(bus);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Bus, route & driver information is added.",Toast.LENGTH_LONG ).show();

        bName.setText("");
        bNo.setText("");
        rName.setText("");
        dName.setText("");
        bTime.setText("");

        Intent intent = new Intent(AddBuses.this, AddBuses.class);
        startActivity(intent);

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