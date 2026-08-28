package com.example.cineverse;

import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.txtMovieName.setText(movie.getName());
        holder.txtRating.setText("⭐ " + movie.getRating());
        holder.imgMovie.setImageResource(movie.getImage());

        holder.btnBook.setOnClickListener(v -> {

            Intent intent = new Intent(context, MovieDetailsActivity.class);

            intent.putExtra("movieName", movie.getName());
            intent.putExtra("movieRating", movie.getRating());
            intent.putExtra("movieImage", movie.getImage());

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMovie;
        TextView txtMovieName, txtRating;
        Button btnBook;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.imgMovie);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtRating = itemView.findViewById(R.id.txtRating);
            btnBook = itemView.findViewById(R.id.btnBook);
        }
    }
}