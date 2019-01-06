package com.example.user.moviesapi.DataAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.moviesapi.ModelData.MoviesObject;
import com.example.user.moviesapi.R;
import com.squareup.picasso.Picasso;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private MoviesObject mMoviesModel;
    private String url,genre;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,year;
        private ImageView MoviePoster;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movie_title);
            year = itemView.findViewById(R.id.movie_year);
            MoviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }

    public MoviesAdapter (MoviesObject MoviesList){
        mMoviesModel = MoviesList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_fragment_container,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int i) {

        holder.title.setText(mMoviesModel.getData().get(i).getTitle());
        genre = mMoviesModel.getData().get(i).getGenre();
        holder.year.setText(mMoviesModel.getData().get(i).getYear());

        url = mMoviesModel.getData().get(i).getPoster();
        Picasso.get().load(url)
                .resize(250, 350).centerCrop().into(holder.MoviePoster);
    }

    @Override
    public int getItemCount() {
        return mMoviesModel.getData().size();
    }

}
