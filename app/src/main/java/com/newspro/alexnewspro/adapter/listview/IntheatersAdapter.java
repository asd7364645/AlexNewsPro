package com.newspro.alexnewspro.adapter.listview;

import android.content.Context;

import com.newspro.alexnewspro.model.bean.doubanmovie.InTheatersMoviesBean.SubjectsBean;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvBaseAdapter;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;

import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class IntheatersAdapter extends XRvBaseAdapter<SubjectsBean> {
    public IntheatersAdapter(Context context, int layoutId, List<SubjectsBean> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    protected void convert(XRvViewHolder viewHolder, SubjectsBean item, int position) {

    }
}
