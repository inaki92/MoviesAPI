package com.example.user.moviesapi.Network;

import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;

import java.util.List;

import retrofit2.Call;
import rx.Observable;

public interface Movies_Interacter {

    Observable<MoviesObject> getMoviesList();
}
