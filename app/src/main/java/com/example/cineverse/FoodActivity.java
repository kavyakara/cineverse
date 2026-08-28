package com.example.cineverse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    Button btnMinusPopcorn, btnPlusPopcorn;
    Button btnMinusCoke, btnPlusCoke;
    Button btnFoodContinue;

    TextView txtPopcornQty, txtCokeQty, txtFoodTotal;

    int popcornQty = 0;
    int cokeQty = 0;

    final int popcornPrice = 150;
    final int cokePrice = 80;

    int seatTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        String movieName = getIntent().getStringExtra("movieName");
        int movieImage = getIntent().getIntExtra("movieImage", 0);

        seatTotal = getIntent().getIntExtra("totalPrice", 0);

        btnMinusPopcorn = findViewById(R.id.btnMinusPopcorn);
        btnPlusPopcorn = findViewById(R.id.btnPlusPopcorn);

        btnMinusCoke = findViewById(R.id.btnMinusCoke);
        btnPlusCoke = findViewById(R.id.btnPlusCoke);

        btnFoodContinue = findViewById(R.id.btnFoodContinue);

        txtPopcornQty = findViewById(R.id.txtPopcornQty);
        txtCokeQty = findViewById(R.id.txtCokeQty);
        txtFoodTotal = findViewById(R.id.txtFoodTotal);

        updateTotal();

        btnPlusPopcorn.setOnClickListener(v -> {
            popcornQty++;
            txtPopcornQty.setText(String.valueOf(popcornQty));
            updateTotal();
        });

        btnMinusPopcorn.setOnClickListener(v -> {
            if (popcornQty > 0) {
                popcornQty--;
                txtPopcornQty.setText(String.valueOf(popcornQty));
                updateTotal();
            }
        });

        btnPlusCoke.setOnClickListener(v -> {
            cokeQty++;
            txtCokeQty.setText(String.valueOf(cokeQty));
            updateTotal();
        });

        btnMinusCoke.setOnClickListener(v -> {
            if (cokeQty > 0) {
                cokeQty--;
                txtCokeQty.setText(String.valueOf(cokeQty));
                updateTotal();
            }
        });

        btnFoodContinue.setOnClickListener(v -> {

            int foodTotal = popcornQty * popcornPrice + cokeQty * cokePrice;
            int grandTotal = seatTotal + foodTotal;

            Intent intent = new Intent(FoodActivity.this, PaymentActivity.class);
            intent.putExtra("movieName", movieName);
            intent.putExtra("movieImage", movieImage);

            intent.putExtra("seatCount",
                    getIntent().getIntExtra("seatCount", 0));

            intent.putExtra("selectedSeats",
                    getIntent().getStringExtra("selectedSeats"));
            intent.putExtra("totalPrice", grandTotal);


            startActivity(intent);

        });

    }

    private void updateTotal() {

        int total = popcornQty * popcornPrice + cokeQty * cokePrice;

        txtFoodTotal.setText("Food Total : ₹" + total);

    }
}