package com.newspro.alexnewspro.adapter.listview.delegate;

import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.customviews.CircleImageView;
import com.newspro.alexnewspro.model.bean.doubanmovie.MovieDetailsCastsBean;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class MovieDetailsCastsCasts implements RvItemViewDelegate<MovieDetailsCastsBean> {

    private CircleImageView item_details_casts_casts_img;
    private TextView item_details_casts_casts_name;

    @Override
    public int getLayoutId() {
        return R.layout.item_details_casts_casts;
    }

    @Override
    public boolean isForViewType(MovieDetailsCastsBean item, int position) {
        return item.isCasts();
    }

    @Override
    public void convert(XRvViewHolder holder, MovieDetailsCastsBean item, int position) {
        GlideLoader.getInstance().display(item_details_casts_casts_img, item.getAvatars().getLarge());
        item_details_casts_casts_name.setText(item.getName());
    }

    @Override
    public void convertByPosi(XRvViewHolder holder, MovieDetailsCastsBean item, int position) {

    }

    @Override
    public void findViews(XRvViewHolder holder) {
        item_details_casts_casts_img = holder.getItemView(R.id.item_details_casts_casts_img);
        item_details_casts_casts_name = holder.getItemView(R.id.item_details_casts_casts_name);
    }
}
