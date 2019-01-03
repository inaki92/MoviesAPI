package com.example.user.moviesapi.DataAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;
import com.example.user.moviesapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MoviesObject> mMoviesModel;
    private String url;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,genre,year;
        private ImageView MoviePoster;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movie_title);
            genre = itemView.findViewById(R.id.movie_genre);
            year = itemView.findViewById(R.id.movie_year);
            MoviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }

    public MoviesAdapter (List<MoviesObject> MoviesList){mMoviesModel = MoviesList;}


    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_fragment_container,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int i) {

        holder.title.setText(mMoviesModel.get(i).getData().get(i).getTitle());
        holder.genre.setText(mMoviesModel.get(i).getData().get(i).getGenre());
        holder.year.setText(mMoviesModel.get(i).getData().get(i).getYear());

        url = mMoviesModel.get(i).getData().get(i).getPoster();
        Picasso.get().load(url)
                .resize(50, 110).centerCrop().into(holder.MoviePoster);
    }

    @Override
    public int getItemCount() {
        return mMoviesModel.size();
    }
}
