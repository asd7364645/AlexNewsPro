package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.presenter.news.NewsDetailsAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;

import java.util.List;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 * 新闻列表的适配器
 *
 */

public class NewsAdapter extends RecyclerView.Adapter {

    public interface IsEndListener{
        void isEnd();
    }
    private IsEndListener isEndListener;
    private List<ContentlistBean> resultBeenList;
    private LayoutInflater layoutInflater;
    private Context context;

    public NewsAdapter(Context context, List<ContentlistBean> resultBeenList) {
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

            if (isEndListener!=null&&position == getItemCount()-1){
                isEndListener.isEnd();
            }

            NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
            //由于5.0以下不兼容ripple，所以判断版本来设置
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                newsViewHolder.item_cardview.setForeground(context.getDrawable(R.drawable.ripple_cardview));
            }
            final ContentlistBean contentlistBean = resultBeenList.get(position);
            newsViewHolder.item_cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewsDetailsAct.class);
                    intent.putExtra("newsBean",contentlistBean);
                    context.startActivity(intent);
                }
            });
            if (!contentlistBean.getImageurls().isEmpty()){
                newsViewHolder.news_item_img.setVisibility(View.VISIBLE);
                GlideLoader.getInstance().display(newsViewHolder.news_item_img,contentlistBean.getImageurls().get(0),R.drawable.img_place_holder_color,R.mipmap.img_load_error);
            }
            else newsViewHolder.news_item_img.setVisibility(View.GONE);
            newsViewHolder.news_item_title.setText(contentlistBean.getTitle());
            newsViewHolder.news_item_author.setText(contentlistBean.getChannelName());
            newsViewHolder.news_item_date.setText(contentlistBean.getPubDate());
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
