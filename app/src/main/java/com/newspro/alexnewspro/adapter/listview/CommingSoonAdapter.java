package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.presenter.movie.MovieDetailsAct;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.refresh_adapters.XRefreshRvBaseAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/2/17.
 * Alex
 */

public class CommingSoonAdapter extends XRefreshRvBaseAdapter<SubjectsBean> {

    private RelativeLayout item_comming_soon_rv;
    private ImageView item_comming_soon_img;
    private TextView item_comming_soon_name,
            item_comming_soon_genres,
            item_comming_soon_directors,
            item_comming_soon_casts;

    public CommingSoonAdapter(Context context, int layoutId, List<SubjectsBean> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    protected void findMyViews(XRvViewHolder holder) {
        item_comming_soon_img = holder.getItemView(R.id.item_comming_soon_img);
        item_comming_soon_rv = holder.getItemView(R.id.item_comming_soon_rv);
        item_comming_soon_name = holder.getItemView(R.id.item_comming_soon_name);
        item_comming_soon_genres = holder.getItemView(R.id.item_comming_soon_genres);
        item_comming_soon_directors = holder.getItemView(R.id.item_comming_soon_directors);
        item_comming_soon_casts = holder.getItemView(R.id.item_comming_soon_casts);
    }

    @Override
    protected void convert(XRvViewHolder viewHolder, final SubjectsBean item, int position) {
        item_comming_soon_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieId = item.getId();
                Intent intent = new Intent(getContext(), MovieDetailsAct.class);
                intent.putExtra("movieId",movieId);
                getContext().startActivity(intent);
            }
        });
        GlideLoader.getInstance().display(item_comming_soon_img, item.getImages().getLarge());
        item_comming_soon_name.setText(item.getTitle());
        String genres = "类型：" + (item.getGenres().isEmpty()?"无": item.getGenres().get(0));
        item_comming_soon_genres.setText(genres);
        String directors = "导演：" + (item.getDirectors().isEmpty()?"无":item.getDirectors().get(0).getName());
        item_comming_soon_directors.setText(directors);
        String casts = "演员：";
        for (int i = 0; i < item.getCasts().size(); i++) {
            if (i == item.getCasts().size() - 1)
                casts += item.getCasts().get(i).getName();
            else
                casts += item.getCasts().get(i).getName() + " \\ ";
        }
        item_comming_soon_casts.setText(casts);
    }
}
