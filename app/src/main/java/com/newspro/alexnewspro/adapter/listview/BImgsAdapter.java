package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.bean.BImgListBean;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;

import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class BImgsAdapter extends RecyclerView.Adapter {

    public interface BImgsAdapterClickListener{
        void click(int position);
    }

    private BImgsAdapterClickListener clickListener;

    private Context context;
    private LayoutInflater layoutInflater;
    private List<BImgListBean.ResultsBean> results;

    public BImgsAdapter(Context context, List<BImgListBean.ResultsBean> resultsBeen) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.results = resultsBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.item_bimg, parent, false);
        return new BImgsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final BImgsViewHolder bImgsViewHolder = (BImgsViewHolder) holder;
        BImgListBean.ResultsBean resultsBean = results.get(position);

        bImgsViewHolder.item_bimg_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener!=null)
                    clickListener.click(position);
            }
        });

        bImgsViewHolder.item_bimg_img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideLoader.getInstance()
                .display(bImgsViewHolder.item_bimg_img, resultsBean.getUrl(), R.drawable.ic_place_holder_150dp, R.mipmap.img_load_error, new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        bImgsViewHolder.item_bimg_img.setScaleType(ImageView.ScaleType.FIT_XY);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        bImgsViewHolder.item_bimg_img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        return false;
                    }
                });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class BImgsViewHolder extends RecyclerView.ViewHolder {

        CardView item_bimg_cardview;
        ImageView item_bimg_img;

        public BImgsViewHolder(View itemView) {
            super(itemView);
            item_bimg_cardview = (CardView) itemView.findViewById(R.id.item_bimg_cardview);
            item_bimg_img = (ImageView) itemView.findViewById(R.id.item_bimg_img);
        }
    }

    public BImgsAdapterClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(BImgsAdapterClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
