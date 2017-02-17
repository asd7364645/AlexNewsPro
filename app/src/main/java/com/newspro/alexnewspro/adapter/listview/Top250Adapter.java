package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.refresh_adapters.XRefreshRvBaseAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/2/15.
 * Alex
 */

public class Top250Adapter extends XRefreshRvBaseAdapter<SubjectsBean> {
    private LinearLayout item_top250_layout;
    private TextView item_top250_number;
    private ImageView item_top250_img;
    private TextView item_top250_name,
            item_top250_genres,
            item_top250_year,
            item_top250_directors,
            item_top250_ratingTv;

    private AppCompatRatingBar item_top250_rating;

    public Top250Adapter(Context context, int layoutId, List<SubjectsBean> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    protected void findMyViews(XRvViewHolder holder) {
        item_top250_layout = holder.getItemView(R.id.item_top250_layout);
        item_top250_number = holder.getItemView(R.id.item_top250_number);
        item_top250_img = holder.getItemView(R.id.item_top250_img);
        item_top250_name = holder.getItemView(R.id.item_top250_name);
        item_top250_genres = holder.getItemView(R.id.item_top250_genres);
        item_top250_directors = holder.getItemView(R.id.item_top250_directors);
        item_top250_year = holder.getItemView(R.id.item_top250_year);
        item_top250_rating = holder.getItemView(R.id.item_top250_rating);
        item_top250_ratingTv = holder.getItemView(R.id.item_top250_ratingTv);
    }

    @Override
    protected void convert(XRvViewHolder viewHolder, SubjectsBean item, int position) {
        item_top250_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        String number = position + "";
        item_top250_number.setText(number);
        GlideLoader.getInstance().display(item_top250_img, item.getImages().getLarge());
        item_top250_name.setText(item.getTitle());
        String genres = "类型：" + item.getGenres().toString();
        item_top250_genres.setText(genres);
        String directors = "导演：" + item.getDirectors().get(0).getName();
        item_top250_directors.setText(directors);
        String year = "播放时间：" + item.getYear();
        item_top250_year.setText(year);
        item_top250_rating.setProgress((int) item.getRating().getAverage());
        item_top250_ratingTv.setText(String.valueOf(item.getRating().getAverage()));
    }

}
