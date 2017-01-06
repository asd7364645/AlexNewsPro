package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.presenter.news.NewsDetailsAct;
import com.newspro.alexnewspro.utils.GlideUtil;

import java.util.List;

/**
 * Created by Alex on 2017/1/4.
 * Alex
 */

public class NewsDetailsRelevantAdapter extends RecyclerView.Adapter {

    private List<ContentlistBean> relevantBeenList;
    private LayoutInflater layoutInflater;
    private Context context;

    public NewsDetailsRelevantAdapter(Context context, List<ContentlistBean> relevantBeenList) {
        this.context = context;
        this.relevantBeenList = relevantBeenList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_news_relevant, parent, false);
        return new RelevantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RelevantViewHolder) {
            RelevantViewHolder newsViewHolder = (RelevantViewHolder) holder;
            //由于5.0以下不兼容ripple，所以判断版本来设置
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                newsViewHolder.item_news_relevant_fl.setForeground(context.getDrawable(R.drawable.ripple_cardview));
            }
            final ContentlistBean contentlistBean = relevantBeenList.get(position);
            newsViewHolder.item_news_relevant_fl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewsDetailsAct.class);
                    intent.putExtra("newsBean",contentlistBean);
                    context.startActivity(intent);
                }
            });
            if (!contentlistBean.getImageurls().isEmpty()){
                newsViewHolder.news_item_img.setVisibility(View.VISIBLE);
                GlideUtil.loadImg(context, contentlistBean.getImageurls().get(0), newsViewHolder.news_item_img);
            }
            else newsViewHolder.news_item_img.setVisibility(View.GONE);
            newsViewHolder.news_item_title.setText(contentlistBean.getTitle());
            newsViewHolder.news_item_author.setText(contentlistBean.getChannelName());
            newsViewHolder.news_item_date.setText(contentlistBean.getPubDate());
        }
    }

    @Override
    public int getItemCount() {
        return relevantBeenList.size();
    }

    class RelevantViewHolder extends RecyclerView.ViewHolder{
        private FrameLayout item_news_relevant_fl;
        private ImageView news_item_img;
        private TextView news_item_title;
        private TextView news_item_author;
        private TextView news_item_date;
        public RelevantViewHolder(View itemView) {
            super(itemView);
            item_news_relevant_fl = (FrameLayout) itemView.findViewById(R.id.item_news_relevant_fl);
            news_item_img = (ImageView) itemView.findViewById(R.id.news_item_img);
            news_item_title = (TextView) itemView.findViewById(R.id.news_item_title);
            news_item_author = (TextView) itemView.findViewById(R.id.news_item_author);
            news_item_date = (TextView) itemView.findViewById(R.id.news_item_date);
        }
    }

}
