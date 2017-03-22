package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.utils.common_util.ZhengZeUtil;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;

import java.util.List;

/**
 * Created by Alex on 2016/12/29.
 * Alex
 */

public class NewsDetailsContentAdapter extends RecyclerView.Adapter {

    public static final int IS_IMG = 1;
    public static final int NO_IMG = 0;

    /**
     * 点击图片查看大图的点击事件
     */
    public interface NewsDetailsImgItemClickListener {
        void click(int posi);
    }

    private NewsDetailsImgItemClickListener newsDetailsImgItemClickListener;

    public NewsDetailsImgItemClickListener getNewsDetailsImgItemClickListener() {
        return newsDetailsImgItemClickListener;
    }

    public void setNewsDetailsImgItemClickListener(NewsDetailsImgItemClickListener newsDetailsImgItemClickListener) {
        this.newsDetailsImgItemClickListener = newsDetailsImgItemClickListener;
    }

    private List<String> contents;
    private LayoutInflater layoutInflater;
    private Context context;

    public NewsDetailsContentAdapter(List<String> contents, Context context) {
        this.contents = contents;
        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);
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
            GlideLoader.getInstance().display(((NewsDetailsImgHolder) holder).news_details_item_img,contents.get(position));
            ((NewsDetailsImgHolder) holder).news_details_item_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (newsDetailsImgItemClickListener !=null){
                        newsDetailsImgItemClickListener.click(position);
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

    private class NewsDetailsImgHolder extends RecyclerView.ViewHolder {

        private ImageView news_details_item_img;

        NewsDetailsImgHolder(View itemView) {
            super(itemView);
            news_details_item_img = (ImageView) itemView.findViewById(R.id.news_details_item_img);
        }
    }

    private class NewsDetailsTvHolder extends RecyclerView.ViewHolder {

        private TextView news_details_item_tv;

        NewsDetailsTvHolder(View itemView) {
            super(itemView);
            news_details_item_tv = (TextView) itemView.findViewById(R.id.news_details_item_tv);
        }
    }

}
