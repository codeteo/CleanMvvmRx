package teo.com.mvvmsampleapp.features.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import teo.com.mvvmsampleapp.R;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.features.main.MainActivity;

/**
 * Adapter class for list of movies in {@link MainActivity}
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> dataset = new ArrayList<>();

    public MoviesAdapter(List<Movie> dataset) {
        this.dataset = dataset;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.setViewModel(new MovieViewModel(dataset.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
