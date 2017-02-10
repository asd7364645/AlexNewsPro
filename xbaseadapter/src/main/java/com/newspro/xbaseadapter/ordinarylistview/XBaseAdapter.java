package com.newspro.xbaseadapter.ordinarylistview;

import android.content.Context;

import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * 单类型的adapter
 */

public abstract class XBaseAdapter<T> extends XMultiItemTypeAdapter<T> {
    public XBaseAdapter(Context context, final int layoutId, List<T> mDatas) {
        super(context, mDatas);
        addDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(XLvViewHolder holder, T item, int position) {
                XBaseAdapter.this.convert(holder,item,position);
            }

            @Override
            public void convertByPosi(XLvViewHolder holder, T item, int position) {
                convertByPosition(holder,item,position);
            }
        });
    }

    protected void convertByPosition(XLvViewHolder holder, T item, int position){

    }

    protected abstract void convert(XLvViewHolder viewHolder, T item, int position);
}
