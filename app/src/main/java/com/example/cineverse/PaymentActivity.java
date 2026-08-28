package com.example.cineverse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    TextView txtSeatCount, txtAmount;
    Button btnPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        txtSeatCount = findViewById(R.id.txtSeatCount);
        txtAmount = findViewById(R.id.txtAmount);
        btnPayNow = findViewById(R.id.btnPayNow);

        // Receive data
        int seats = getIntent().getIntExtra("seatCount", 0);
        int amount = getIntent().getIntExtra("totalPrice", 0);

        String movieName = getIntent().getStringExtra("movieName");
        int movieImage = getIntent().getIntExtra("movieImage", 0);

        txtSeatCount.setText("Seats : " + seats);
        txtAmount.setText("Amount : ₹" + amount);

        btnPayNow.setOnClickListener(v -> {

            Intent intent = new Intent(PaymentActivity.this,
                    TicketActivity.class);

            // Pass everything to Ticket
            intent.putExtra("seatCount", seats);
            intent.putExtra("selectedSeats",
                    getIntent().getStringExtra("selectedSeats"));
            intent.putExtra("totalPrice", amount);
            intent.putExtra("movieName", movieName);
            intent.putExtra("movieImage", movieImage);
            intent.putExtra("selectedSeats",
                    getIntent().getStringExtra("selectedSeats"));

            startActivity(intent);

        });

    }
}