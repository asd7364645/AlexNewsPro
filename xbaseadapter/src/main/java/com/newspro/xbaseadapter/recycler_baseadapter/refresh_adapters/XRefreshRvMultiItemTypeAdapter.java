package com.newspro.xbaseadapter.recycler_baseadapter.refresh_adapters;

import android.content.Context;

import com.newspro.xbaseadapter.recycler_baseadapter.XRvMultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/2/15.
 * 下拉刷新的多类型类型通用适配器
 * 说明：适用于重写RecyclerView的下拉刷新控件
 *      不能继承XHFRv系列适配器，由于里面有onViewAttachedToWindow，
 *      并且一般在重写RecyclerView的下拉控件中也有这个方法，会造成冲突，
 *      如果修改RecyclerView里onViewAttachedToWindow参数会造成耦合度增大，并且不利于扩展
 *      所以如果想加入header或者footer可以自己重构RecyclerView,或者使用XRecyclerView
 *      在AlexNewsPro这个Demo中使用的是XRecyclerView
 * 提示：如果在下拉刷新控件中有调用onBindViewHolder(holder, position)这个方法的话
 *      要修改为onBindViewHolder(holder, position,payloads)，否则不会加载convert
 * Alex
 */

public class XRefreshRvMultiItemTypeAdapter<T> extends XRvMultiItemTypeAdapter<T> {

    public XRefreshRvMultiItemTypeAdapter(Context context, List<T> mDatas) {
        super(context, mDatas);
    }

    @Override
    public int getItemViewType(int position) {
        //由于一般的重写RecyclerView的下拉刷新控件会增加一个header，所以在这里要把position+1
        position += 1;
        if (!getmDatas().isEmpty()&&position<getmDatas().size())
            return super.getItemViewType(position);
        return 0;
    }

}
