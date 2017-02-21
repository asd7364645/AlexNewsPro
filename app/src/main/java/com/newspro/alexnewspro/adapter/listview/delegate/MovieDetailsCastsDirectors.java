package com.newspro.alexnewspro.adapter.listview.delegate;

import android.widget.ImageView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.doubanmovie.MovieDetailsCastsBean;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class MovieDetailsCastsDirectors implements RvItemViewDelegate<MovieDetailsCastsBean> {

    private ImageView item_details_casts_directors_img;

    @Override
    public int getLayoutId() {
        return R.layout.item_details_casts_directors;
    }

    @Override
    public boolean isForViewType(MovieDetailsCastsBean item, int position) {
        return !item.isCasts();
    }

    @Override
    public void convert(XRvViewHolder holder, MovieDetailsCastsBean item, int position) {
        GlideLoader.getInstance().display(item_details_casts_directors_img,item.getAvatars().getLarge());
    }

    @Override
    public void convertByPosi(XRvViewHolder holder, MovieDetailsCastsBean item, int position) {

    }

    @Override
    public void findViews(XRvViewHolder holder) {
        item_details_casts_directors_img = holder.getItemView(R.id.item_details_casts_directors_img);
    }
}
