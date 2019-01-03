package com.example.user.moviesapi.Network;

import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;

import java.util.List;

import rx.Observable;

public interface Movies_Interacter {

    Observable<List<MoviesObject>> getMoviesList();
}
