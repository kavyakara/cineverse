package com.example.cineverse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TheatreSelectionActivity extends AppCompatActivity {

    Button btnPvr10, btnPvr1, btnPvr6;
    Button btnInox11, btnInox4, btnInox9;

    String movieName;
    int movieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_selection);

        movieName = getIntent().getStringExtra("movieName");
        movieImage = getIntent().getIntExtra("movieImage", 0);

        btnPvr10 = findViewById(R.id.btnPvr10);
        btnPvr1 = findViewById(R.id.btnPvr1);
        btnPvr6 = findViewById(R.id.btnPvr6);

        btnInox11 = findViewById(R.id.btnInox11);
        btnInox4 = findViewById(R.id.btnInox4);
        btnInox9 = findViewById(R.id.btnInox9);

        btnPvr10.setOnClickListener(v -> openSeatSelection());
        btnPvr1.setOnClickListener(v -> openSeatSelection());
        btnPvr6.setOnClickListener(v -> openSeatSelection());

        btnInox11.setOnClickListener(v -> openSeatSelection());
        btnInox4.setOnClickListener(v -> openSeatSelection());
        btnInox9.setOnClickListener(v -> openSeatSelection());
    }

    private void openSeatSelection() {

        Intent intent = new Intent(TheatreSelectionActivity.this,
                SeatSelectionActivity.class);

        intent.putExtra("movieName", movieName);
        intent.putExtra("movieImage", movieImage);

        startActivity(intent);
    }
}