package com.newspro.alexnewspro.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.NewsBean;
import com.newspro.alexnewspro.utils.GlideUtil;

import java.util.List;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsAdapter extends RecyclerView.Adapter {

    private List<NewsBean.ResultBean.DataBean> resultBeenList;
    private LayoutInflater layoutInflater;
    private Context context;

    public NewsAdapter(Context context, List<NewsBean.ResultBean.DataBean> resultBeenList) {
        this.context = context;
        this.resultBeenList = resultBeenList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof NewsViewHolder) {
            NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
            NewsBean.ResultBean.DataBean dataBean = resultBeenList.get(position);
            newsViewHolder.item_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            GlideUtil.loadImg(context, dataBean.getThumbnail_pic_s(), newsViewHolder.news_item_img);
            newsViewHolder.news_item_title.setText(dataBean.getTitle());
            newsViewHolder.news_item_author.setText(dataBean.getAuthor_name());
            newsViewHolder.news_item_date.setText(dataBean.getDate());
        }

    }

    @Override
    public int getItemCount() {
        return resultBeenList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private CardView item_cardview;
        private ImageView news_item_img;
        private TextView news_item_title;
        private TextView news_item_author;
        private TextView news_item_date;

        public NewsViewHolder(View itemView) {
            super(itemView);
            item_cardview = (CardView) itemView.findViewById(R.id.item_cardview);
            news_item_img = (ImageView) itemView.findViewById(R.id.news_item_img);
            news_item_title = (TextView) itemView.findViewById(R.id.news_item_title);
            news_item_author = (TextView) itemView.findViewById(R.id.news_item_author);
            news_item_date = (TextView) itemView.findViewById(R.id.news_item_date);
        }
    }

}
