package com.example.user.moviesapi.PRESENTER;

import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;
import com.example.user.moviesapi.Network.Movies_Interacter;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Movies_Presenter implements Movies_contract.Presenter_Movies {

    private Movies_contract.View_Movies iView_MoviesList;
    private Movies_Interacter iMovies_interacter;

    public Movies_Presenter(Movies_Interacter iMovies_interacter){
        this.iMovies_interacter = iMovies_interacter;
    }


    @Override
    public void onBind(Movies_contract.View_Movies view_movies) {
        this.iView_MoviesList = view_movies;
    }

    @Override
    public void getMoviesFromAPI() {
        iMovies_interacter.getMoviesList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MoviesObject>>() {
                    @Override
                    public void onCompleted() {
                        iView_MoviesList.displayProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_MoviesList.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(List<MoviesObject> moviesObjects) {
                        iView_MoviesList.moviesList(moviesObjects);
                    }
                });

    }

    @Override
    public void unBind() {
        this.iView_MoviesList = null;
    }
}
