package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;

import com.newspro.alexnewspro.adapter.listview.delegate.MovieDetailsCastsCasts;
import com.newspro.alexnewspro.adapter.listview.delegate.MovieDetailsCastsDirectors;
import com.newspro.alexnewspro.model.bean.doubanmovie.MovieDetailsCastsBean;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvMultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class MovieDetailsCastsAdapter extends XRvMultiItemTypeAdapter<MovieDetailsCastsBean> {
    public MovieDetailsCastsAdapter(Context context, List<MovieDetailsCastsBean> mDatas) {
        super(context, mDatas);
        addDelegate(new MovieDetailsCastsCasts()).addDelegate(new MovieDetailsCastsDirectors());
    }

}
