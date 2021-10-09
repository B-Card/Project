package com.example.buscard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CardApply extends AppCompatActivity {

    EditText applicantName, applicantEmail, applicantDateOfBirth, applicantNIDNo, applicantAddress, applicantMobileNo;
    Button applyButton;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_apply);

        applicantName = findViewById(R.id.applicantNameId);
        applicantEmail = findViewById(R.id.applicantEmailId);
        applicantDateOfBirth = findViewById(R.id.applicantBirthDateId);
        applicantNIDNo = findViewById(R.id.applicantNIDId);
        applicantAddress = findViewById(R.id.applicantAddressId);
        applicantMobileNo = findViewById(R.id.applicantMoblieNoId);
        applyButton = findViewById(R.id.applyButtonId);
        progressBar = findViewById(R.id.progressBarId);

        databaseReference = FirebaseDatabase.getInstance().getReference("passengers");

        applyButton.setOnClickListener(view -> savedata());

    }

    public void savedata() {

        String name = applicantName.getText().toString().trim();
        String email = applicantEmail.getText().toString().trim();
        String birthDate = applicantDateOfBirth.getText().toString().trim();
        String nid = applicantNIDNo.getText().toString().trim();
        String address = applicantAddress.getText().toString().trim();
        String mobileNo = applicantMobileNo.getText().toString().trim();

        if(name.isEmpty())
        {
            applicantName.setError("Enter full name");
            applicantName.requestFocus();
        }

        if(email.isEmpty())
        {
            applicantEmail.setError("Enter your email");
            applicantEmail.requestFocus();
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            applicantEmail.setError("Enter a valid email address");
            applicantEmail.requestFocus();
        }

        if(birthDate.isEmpty())
        {
            applicantDateOfBirth.setError("Enter your date of birth");
            applicantDateOfBirth.requestFocus();
        }

        if(nid.isEmpty())
        {
            applicantNIDNo.setError("Enter your NID number");
            applicantNIDNo.requestFocus();
        }

        if(address.isEmpty())
        {
            applicantAddress.setError("Enter your present address");
            applicantAddress.requestFocus();
        }

        if(mobileNo.isEmpty())
        {
            applicantMobileNo.setError("Enter your mobile number");
            applicantMobileNo.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        String key = databaseReference.push().getKey();

        Passenger passenger = new Passenger(name, email, birthDate, nid, address, mobileNo);

        databaseReference.child(key).setValue(passenger);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "New card application information is added.",Toast.LENGTH_LONG ).show();

        applicantName.setText("");
        applicantEmail.setText("");
        applicantDateOfBirth.setText("");
        applicantNIDNo.setText("");
        applicantAddress.setText("");
        applicantMobileNo.setText("");

        Intent intent = new Intent(CardApply.this, PassengerDashboard.class);
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