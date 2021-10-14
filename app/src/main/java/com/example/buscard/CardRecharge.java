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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CardRecharge extends AppCompatActivity {

    EditText cNo, rAmount;
    TextView cBalance;
    Button rechargeButton;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recharge);

        cNo = findViewById(R.id.cardNumberId);
        rAmount = findViewById(R.id.rechargeAmountId);
        rechargeButton = findViewById(R.id.rechargeButtonId);
        cBalance = findViewById(R.id.balanceID);
        progressBar = findViewById(R.id.progressBarId);

        databaseReference = FirebaseDatabase.getInstance().getReference("balance");

        rechargeButton.setOnClickListener(view -> rechargeBalance());

    }

    public void rechargeBalance() {

        String cardNumber = cNo.getText().toString().trim();
        String rechargeAmount = rAmount.getText().toString().trim();
        String currentBalance = cBalance.getText().toString().trim();

        if(cardNumber.isEmpty())
        {
            cNo.setError("Enter your card number");
            cNo.requestFocus();
        }

        if(rechargeAmount.isEmpty())
        {
            rAmount.setError("Enter your recharge amount");
            rAmount.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        String key = databaseReference.push().getKey();

        Recharge recharge = new Recharge(cardNumber, currentBalance);

        databaseReference.child(key).setValue(recharge);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Your card is recharged.",Toast.LENGTH_LONG ).show();

        cBalance.setText(rechargeAmount);

        cNo.setText("");
        rAmount.setText("");

        Intent intent = new Intent(CardRecharge.this, CardRecharge.class);
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
            startActivity ( new Intent ( getApplicationContext (), Login.class ) );
            finish ();

        }
        return super.onOptionsItemSelected(item);
    }
}