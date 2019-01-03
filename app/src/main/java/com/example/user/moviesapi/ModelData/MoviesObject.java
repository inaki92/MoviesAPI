package com.example.user.moviesapi.ModelData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesObject {

    @SerializedName("data")
    @Expose
    private List<MoviesItems> data = null;

    public List<MoviesItems> getData() {
        return data;
    }

    public void setData(List<MoviesItems> data) {
        this.data = data;
    }

}