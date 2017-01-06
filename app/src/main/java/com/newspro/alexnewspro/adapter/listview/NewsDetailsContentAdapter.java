package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.utils.GlideUtil;
import com.newspro.alexnewspro.utils.common_util.ZhengZeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/29.
 * Alex
 */

public class NewsDetailsContentAdapter extends RecyclerView.Adapter {

    public static final int IS_IMG = 1;
    public static final int NO_IMG = 0;

    public interface NewsDetailsContentsItemClickListener{
        void click(int posi);
    }

    private NewsDetailsContentsItemClickListener newsDetailsContentsItemClickListener;

    public NewsDetailsContentsItemClickListener getNewsDetailsContentsItemClickListener() {
        return newsDetailsContentsItemClickListener;
    }

    public void setNewsDetailsContentsItemClickListener(NewsDetailsContentsItemClickListener newsDetailsContentsItemClickListener) {
        this.newsDetailsContentsItemClickListener = newsDetailsContentsItemClickListener;
    }

    private List<String> contents;
    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<String> imgs;

    public NewsDetailsContentAdapter(List<String> contents, Context context) {
        this.contents = contents;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        //把图片提出来
        imgs = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (ZhengZeUtil.isImgUrl(contents.get(position)))
            return IS_IMG;
        else
            return NO_IMG;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case IS_IMG:
                View imgView = layoutInflater.inflate(R.layout.item_news_details_img, parent, false);
                holder = new NewsDetailsImgHolder(imgView);
                break;
            case NO_IMG:
                View tvView = layoutInflater.inflate(R.layout.item_news_details_tv, parent, false);
                holder = new NewsDetailsTvHolder(tvView);
                break;
            default:
                View defView = layoutInflater.inflate(R.layout.item_news_details_tv, parent, false);
                holder = new NewsDetailsTvHolder(defView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof NewsDetailsImgHolder){
            GlideUtil.loadImg(context,contents.get(position),((NewsDetailsImgHolder) holder).news_details_item_img);
            ((NewsDetailsImgHolder) holder).news_details_item_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (newsDetailsContentsItemClickListener!=null){
                        newsDetailsContentsItemClickListener.click(position);
                    }
                }
            });
        }else if (holder instanceof NewsDetailsTvHolder){
            ((NewsDetailsTvHolder) holder).news_details_item_tv.setText(contents.get(position));
        }

    }



    @Override
    public int getItemCount() {
        return contents.size();
    }

    class NewsDetailsImgHolder extends RecyclerView.ViewHolder {

        private ImageView news_details_item_img;

        public NewsDetailsImgHolder(View itemView) {
            super(itemView);
            news_details_item_img = (ImageView) itemView.findViewById(R.id.news_details_item_img);
        }
    }

    class NewsDetailsTvHolder extends RecyclerView.ViewHolder {

        private TextView news_details_item_tv;

        public NewsDetailsTvHolder(View itemView) {
            super(itemView);
            news_details_item_tv = (TextView) itemView.findViewById(R.id.news_details_item_tv);
        }
    }

}
