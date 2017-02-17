package com.newspro.xbaseadapter.recycler_baseadapter.has_head_foot_adapter;

import android.content.Context;

import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public abstract class XHFRvBaseAdapter<T> extends XHFRvMultiItemTypeAdapter<T> {
    public XHFRvBaseAdapter(Context context, final int layoutId, List<T> mDatas) {
        super(context, mDatas);
        addDelegate(new RvItemViewDelegate<T>() {
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(XRvViewHolder holder, T item, int position) {
                XHFRvBaseAdapter.this.convert(holder,item,position);
            }

            @Override
            public void convertByPosi(XRvViewHolder holder, T item, int position) {
                XHFRvBaseAdapter.this.convertByPosi(holder,item,position);
            }

            @Override
            public void findViews(XRvViewHolder holder) {
                findMyViews(holder);
            }

        });
    }

    protected abstract void findMyViews(XRvViewHolder holder);

    protected void convertByPosi(XRvViewHolder holder, T item, int position){

    }

    protected void convert(XRvViewHolder viewHolder, T item, int position){

    }

}
