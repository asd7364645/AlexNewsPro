package com.newspro.alexnewspro.view.movie;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.MovieVpAdapter;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.presenter.movie.FgCommingSoon;
import com.newspro.alexnewspro.presenter.movie.FgInTheaters;
import com.newspro.alexnewspro.presenter.movie.FgMovie;
import com.newspro.alexnewspro.presenter.movie.FgTop250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class FgMovieView extends MvpBaseFragView<FgMovie> {

    private TabLayout base_tablayout;
    private ViewPager fg_movie_vp;

    private List<Fragment> movieFgs;
    private FgInTheaters fgInTheaters;
    private FgTop250 fgTop250;
    private FgCommingSoon fgCommingSoon;
    private MovieVpAdapter movieVpAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_movie;
    }

    @Override
    public void findMvpViews() {
        base_tablayout = findViewById(R.id.base_tablayout);
        fg_movie_vp = findViewById(R.id.fg_movie_vp);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        movieFgs = new ArrayList<>();
        fgInTheaters = new FgInTheaters();
        fgTop250 = new FgTop250();
        fgCommingSoon = new FgCommingSoon();
        movieFgs.add(fgInTheaters);
        movieFgs.add(fgTop250);
        movieFgs.add(fgCommingSoon);
        base_tablayout.setupWithViewPager(fg_movie_vp);
        List<String> titles = Arrays.asList(Constant.MOVIES_TYPE);
        movieVpAdapter = new MovieVpAdapter(presenter.getChildFragmentManager(), movieFgs, titles);
        fg_movie_vp.setAdapter(movieVpAdapter);
    }
}
