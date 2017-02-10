package com.newspro.xbaseadapter.recycler_baseadapter;

import android.content.Context;

import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public abstract class XRvBaseAdapter<T> extends XRvMultiItemTypeAdapter<T> {
    public XRvBaseAdapter(Context context, final int layoutId, List<T> mDatas) {
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
                XRvBaseAdapter.this.convert(holder,item,position);
            }

            @Override
            public void convertByPosi(XRvViewHolder holder, T item, int position) {
                XRvBaseAdapter.this.convertByPosi(holder,item,position);
            }

        });
    }

    protected void convertByPosi(XRvViewHolder holder, T item, int position){

    }

    protected abstract void convert(XRvViewHolder viewHolder, T item, int position);

}
