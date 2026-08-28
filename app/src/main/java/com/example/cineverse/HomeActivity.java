package com.example.cineverse;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerMovies;
    ArrayList<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerMovies = findViewById(R.id.recyclerMovies);

        movieList = new ArrayList<>();

        movieList.add(new Movie("Kalki 2898 AD", "9.2", R.drawable.kalki));
        movieList.add(new Movie("Pushpa 2", "8.9", R.drawable.pushpa));
        movieList.add(new Movie("Leo", "8.7", R.drawable.leo));
        movieList.add(new Movie("KGF 2", "9.0", R.drawable.kgf_2));

        MovieAdapter adapter = new MovieAdapter(this, movieList);

        recyclerMovies.setLayoutManager(new LinearLayoutManager(this));
        recyclerMovies.setAdapter(adapter);
    }
}