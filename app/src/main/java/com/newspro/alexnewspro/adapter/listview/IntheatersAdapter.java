package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.presenter.movie.MovieDetailsAct;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.refresh_adapters.XRefreshRvBaseAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class InTheatersAdapter extends XRefreshRvBaseAdapter<SubjectsBean> {

    private static final String TAG = "InTheatersAdapter";
    private ImageView item_intheaters_img;
    private TextView item_intheaters_name;
    private AppCompatRatingBar item_intheaters_rating;
    private CardView item_intheaters_cardview;

    public InTheatersAdapter(Context context, int layoutId, List<SubjectsBean> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    protected void findMyViews(XRvViewHolder holder) {
        item_intheaters_img = holder.getItemView(R.id.item_intheaters_img);
        item_intheaters_cardview = holder.getItemView(R.id.item_intheaters_cardview);
        item_intheaters_name = holder.getItemView(R.id.item_intheaters_name);
        item_intheaters_rating = holder.getItemView(R.id.item_intheaters_rating);
    }

    @Override
    protected void convert(XRvViewHolder viewHolder, final SubjectsBean item, int position) {
        Log.d(TAG, "convert: " + item.getTitle() + "  :  " + item.getAlt());
        //由于5.0以下不兼容ripple，所以判断版本来设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            item_intheaters_cardview.setForeground(getContext().getDrawable(R.drawable.ripple_cardview));
        }

        item_intheaters_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieId = item.getId();
                Intent intent = new Intent(getContext(), MovieDetailsAct.class);
                intent.putExtra("movieId",movieId);
                getContext().startActivity(intent);
            }
        });

        GlideLoader.getInstance().display(item_intheaters_img,item.getImages().getLarge());
        item_intheaters_name.setText(item.getTitle());
        item_intheaters_rating.setProgress((int) item.getRating().getAverage());
    }

}
