package com.example.user.moviesapi.Network;

import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class Connection_Service implements Movies_Interacter {

    private static Retrofit retrofit;

    public Connection_Service() {getConnection();}

    public static Request_Interface getConnection(){

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(API_Request.BASE_URL).build();

        return retrofit.create(Request_Interface.class);
    }

    @Override
    public Observable<List<MoviesObject>> getMoviesList() {
        return getConnection().getMoviesList();
    }
}
