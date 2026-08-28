package com.example.cineverse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imgPoster;
    TextView txtTitle;
    Button btnBookTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imgPoster = findViewById(R.id.imgPoster);
        txtTitle = findViewById(R.id.txtTitle);
        btnBookTickets = findViewById(R.id.btnBookTickets);

        String movieName = getIntent().getStringExtra("movieName");
        int movieImage = getIntent().getIntExtra("movieImage", 0);

        txtTitle.setText(movieName);
        imgPoster.setImageResource(movieImage);

        btnBookTickets.setOnClickListener(v -> {

            Intent intent = new Intent(MovieDetailsActivity.this,
                    TheatreSelectionActivity.class);

            intent.putExtra("movieName", movieName);
            intent.putExtra("movieImage", movieImage);

            startActivity(intent);

        });
    }
}