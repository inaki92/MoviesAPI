package com.example.user.moviesapi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.moviesapi.DataAdapter.MoviesAdapter;
import com.example.user.moviesapi.ModelData.MoviesItems;
import com.example.user.moviesapi.ModelData.MoviesObject;
import com.example.user.moviesapi.Network.Connection_Service;
import com.example.user.moviesapi.Network.Movies_Interacter;
import com.example.user.moviesapi.PRESENTER.Movies_Presenter;
import com.example.user.moviesapi.PRESENTER.Movies_contract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Movies_contract.View_Movies,SwipeRefreshLayout.OnRefreshListener {

    private Movies_Presenter moviesListPresenter;
    private Movies_Interacter moviesInteracter;
    private MoviesAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public SwipeRefreshLayout mySwipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwipeRefresh = findViewById(R.id.swipe_refresh);
        mySwipeRefresh.setColorSchemeResources(R.color.colorPrimaryDark);
        mySwipeRefresh.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        mySwipeRefresh.setOnRefreshListener(this);

        initializePresenterandCallAPI();
    }

    @Override
    public void displayProgressDialog() {

    }

    @Override
    public void moviesList(List<MoviesObject> moviesModel) {

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MoviesAdapter(moviesModel);
        mRecyclerView.setAdapter(mAdapter);
        mySwipeRefresh.setRefreshing(false);
    }

    @Override
    public void dismissProgressDialog() {

    }

    public void initializePresenterandCallAPI(){
        moviesInteracter = new Connection_Service();
        moviesListPresenter = new Movies_Presenter(moviesInteracter);
        moviesListPresenter.onBind(this);
        moviesListPresenter.getMoviesFromAPI();
        mySwipeRefresh.setRefreshing(false);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        moviesListPresenter.unBind();
    }

    @Override
    public void onRefresh() {
        initializePresenterandCallAPI();
    }
}
