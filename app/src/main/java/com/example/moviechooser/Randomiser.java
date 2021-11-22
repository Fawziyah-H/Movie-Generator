package com.example.moviechooser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

public class Randomiser extends Fragment {

    TmdbMovies allMovies = new TmdbApi("26abb9f605dab9f7c7729c4067aa8d9e").getMovies();

    TextView randomMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View randomMovieFragment = inflater.inflate(R.layout.random_movie_generator, container, false);
        randomMovie = randomMovieFragment.findViewById(R.id.chosenMovie);

        return randomMovieFragment;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getRandomMovie(v);
            }
        });
    }

    private void getRandomMovie(View view){
        //randomMovie.setText("hi");
        MovieDb movie = allMovies.getMovie(5353,"en");
        String text = movie.getOriginalTitle().toString();
        randomMovie.setText(text);

    }
}
