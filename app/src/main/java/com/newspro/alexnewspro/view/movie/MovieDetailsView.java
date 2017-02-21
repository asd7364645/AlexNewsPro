package com.newspro.alexnewspro.view.movie;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.MovieDetailsCastsAdapter;
import com.newspro.alexnewspro.customviews.ExpandableTextView;
import com.newspro.alexnewspro.model.bean.doubanmovie.DetailsSubjectBean;
import com.newspro.alexnewspro.model.bean.doubanmovie.MovieDetailsCastsBean;
import com.newspro.alexnewspro.presenter.movie.MovieDetailsAct;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;

import java.util.ArrayList;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class MovieDetailsView extends MvpBaseView<MovieDetailsAct> {
    private AppBarLayout movie_details_appbar;
    private CollapsingToolbarLayout movie_details_collbar;
    private ImageView movie_details_top_img;
    private Toolbar movie_details_toolbar;
    private TextView movie_details_rating_tv,
            movie_details_rating_human_count,
            movie_details_aka_title,
            movie_details_genres,
            movie_details_year,
            movie_details_directors;
    private ExpandableTextView expandable_text_view;
    private RecyclerView movie_details_casts_rv;

    private ArrayList<MovieDetailsCastsBean> castsBeens;

    private MovieDetailsCastsAdapter castsAdapter;


    @Override
    public int setLayoutId() {
        return R.layout.activity_movie_details;
    }

    @Override
    public void findMvpViews() {
        movie_details_appbar = findViewById(R.id.movie_details_appbar);
        movie_details_collbar = findViewById(R.id.movie_details_collbar);
        movie_details_top_img = findViewById(R.id.movie_details_top_img);
        movie_details_toolbar = findViewById(R.id.movie_details_toolbar);
        movie_details_rating_tv = findViewById(R.id.movie_details_rating_tv);
        movie_details_rating_human_count = findViewById(R.id.movie_details_rating_human_count);
        movie_details_aka_title = findViewById(R.id.movie_details_aka_title);
        movie_details_genres = findViewById(R.id.movie_details_genres);
        movie_details_year = findViewById(R.id.movie_details_year);
        movie_details_directors = findViewById(R.id.movie_details_directors);
        expandable_text_view = findViewById(R.id.expandable_text_view);
        movie_details_casts_rv = findViewById(R.id.movie_details_casts_rv);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        castsBeens = new ArrayList<>();
        castsAdapter = new MovieDetailsCastsAdapter(this.getContext(),castsBeens);
    }

    @Override
    protected void setView() {
        super.setView();

        movie_details_casts_rv.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false));
        movie_details_casts_rv.setAdapter(castsAdapter);

    }

    @Override
    public Toolbar getToolBar() {
        return movie_details_toolbar;
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        movie_details_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.finish();
            }
        });
    }

    public void setMovieDetails(DetailsSubjectBean details) {
        movie_details_collbar.setTitle(details.getTitle());
        GlideLoader.getInstance().display(movie_details_top_img, details.getImages().getLarge());
        movie_details_aka_title.setText("又名：" + details.getAka().toString());
        movie_details_genres.setText("影片类型：" + details.getGenres().toString());
        movie_details_year.setText("年份：" + details.getYear());
        movie_details_rating_tv.setText(details.getRating().getAverage() + "");
        movie_details_rating_human_count.setText(details.getRatings_count()+"");
        String directors = "导演：";
        for (int i = 0; i < details.getDirectors().size(); i++) {
            directors += i == details.getDirectors().size() - 1 ? details.getDirectors().get(i).getName() : details.getDirectors().get(i).getName() + ",";
        }
        movie_details_directors.setText(directors);
        expandable_text_view.setText(details.getSummary());
        for (DetailsSubjectBean.DirectorsBean directorsBean : details.getDirectors()) {
            MovieDetailsCastsBean castsBean = new MovieDetailsCastsBean(false,directorsBean.getAlt(),directorsBean.getAvatars(),directorsBean.getName(),directorsBean.getId());
            castsBeens.add(castsBean);
        }
        for (DetailsSubjectBean.CastsBean castsBean : details.getCasts()) {
            MovieDetailsCastsBean casts = new MovieDetailsCastsBean(true,castsBean.getAlt(),castsBean.getAvatars(),castsBean.getName(),castsBean.getId());
            castsBeens.add(casts);
        }
        castsAdapter.notifyDataSetChanged();
    }

}
