package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.bean.BImgListBean;
import com.newspro.alexnewspro.utils.GlideUtil;

import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class BImgsAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<BImgListBean.TngouBean> tngouBeen;

    public BImgsAdapter(Context context, List<BImgListBean.TngouBean> tngouBeen) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.tngouBeen = tngouBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.item_bimg, parent, false);
        return new BImgsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BImgsViewHolder bImgsViewHolder = (BImgsViewHolder) holder;
        BImgListBean.TngouBean tngou = tngouBeen.get(position);
        bImgsViewHolder.item_bimg_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        GlideUtil.loadImg(context, Constant.BIMG_IMG_START_URL+tngou.getImg()+"_150x150",bImgsViewHolder.item_bimg_img);
        Log.d("美图图片url", Constant.BIMG_IMG_START_URL+tngou.getImg()+"    ,title：" + tngou.getTitle());
        bImgsViewHolder.item_bimg_title.setText(tngou.getTitle());
    }

    @Override
    public int getItemCount() {
        return tngouBeen.size();
    }

    class BImgsViewHolder extends RecyclerView.ViewHolder {

        CardView item_bimg_cardview;
        ImageView item_bimg_img;
        TextView item_bimg_title;

        public BImgsViewHolder(View itemView) {
            super(itemView);

            item_bimg_cardview = (CardView) itemView.findViewById(R.id.item_bimg_cardview);
            item_bimg_img = (ImageView) itemView.findViewById(R.id.item_bimg_img);
            item_bimg_title = (TextView) itemView.findViewById(R.id.item_bimg_title);

        }
    }

}
