package com.newspro.xbaseadapter.recycler_baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 * 通用的RecyclerView的ViewHolder
 */

public class XRvViewHolder extends RecyclerView.ViewHolder{

    private Context context;
    private View mConvertView;

    /**
     * 保存控件的集合
     */
    private SparseArray<View> mViews;

    public XRvViewHolder(Context context,View itemView) {
        super(itemView);
        this.context = context;
        this.mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static XRvViewHolder createXRvViewHolder(Context context,View convertView){
        return new XRvViewHolder(context,convertView);
    }

    public static XRvViewHolder createXRvViewHolder(Context context,ViewGroup parent,int layoutId){
        View convertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        return new XRvViewHolder(context,convertView);
    }

    public <V extends View> V getItemView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (V) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }
}
