package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.bean.baisi.BaiSiBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.customviews.CircleImageView;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.refresh_adapters.XRefreshRvBaseAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/6/9.
 * Alex
 */

public class BaiSiImgsAdapter extends XRefreshRvBaseAdapter<ContentlistBean> {

    private CircleImageView item_baisi_imgs_user_img;
    private TextView item_baisi_imgs_name,
            item_baisi_imgs_title,
            item_baisi_imgs_time,
            item_baisi_imgs_zan_count,
            item_baisi_imgs_cai_count;
    private ImageView item_baisi_imgs_img;


    public BaiSiImgsAdapter(Context context, List<ContentlistBean> mDatas) {
        super(context, R.layout.item_baisi_imgs, mDatas);
    }

    @Override
    protected void findMyViews(XRvViewHolder holder) {
        item_baisi_imgs_user_img = holder.getItemView(R.id.item_baisi_imgs_user_img);
        item_baisi_imgs_name = holder.getItemView(R.id.item_baisi_imgs_name);
        item_baisi_imgs_title = holder.getItemView(R.id.item_baisi_imgs_title);
        item_baisi_imgs_time = holder.getItemView(R.id.item_baisi_imgs_time);
        item_baisi_imgs_zan_count = holder.getItemView(R.id.item_baisi_imgs_zan_count);
        item_baisi_imgs_cai_count = holder.getItemView(R.id.item_baisi_imgs_cai_count);
        item_baisi_imgs_img = holder.getItemView(R.id.item_baisi_imgs_img);
    }

    @Override
    protected void convert(XRvViewHolder viewHolder, ContentlistBean item, int position) {
        item_baisi_imgs_name.setText(item.getName());
//        GlideLoader.getInstance().display(item_baisi_imgs_img, item.getCdn_img());
        GlideLoader.getInstance().display(item_baisi_imgs_user_img,item.getProfile_image());
        GlideLoader.getInstance().display(item_baisi_imgs_img, item.getImage0(),R.mipmap.gl_icon,0);
        item_baisi_imgs_title.setText(item.getText());
        item_baisi_imgs_time.setText(item.getCt());
        item_baisi_imgs_zan_count.setText(item.getLove());
        item_baisi_imgs_cai_count.setText(item.getHate());
    }
}
