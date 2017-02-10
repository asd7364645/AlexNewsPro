package com.newspro.xbaseadapter.ordinarylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegate;
import com.newspro.xbaseadapter.ordinarylistview.delegate.ItemViewDelegateManager;

import java.util.List;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * 多个ItemType的通用Adapter
 */

public class XMultiItemTypeAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> mDatas;

    private ItemViewDelegateManager<T> itemViewDelegateManager;

    public XMultiItemTypeAdapter(Context context, List<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        itemViewDelegateManager = new ItemViewDelegateManager<>();
    }

    public XMultiItemTypeAdapter<T> addDelegate(ItemViewDelegate<T> itemViewDelegate) {
        itemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (useItemViewDelegateManager()) {
            return itemViewDelegateManager.getItemViewType(mDatas.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        if (useItemViewDelegateManager()) {
            return itemViewDelegateManager.getDelegateCount();
        }
        return super.getViewTypeCount();
    }

    private boolean useItemViewDelegateManager() {
        return itemViewDelegateManager.getDelegateCount() > 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewDelegate itemViewDelegate = itemViewDelegateManager.getItemViewDelegate(mDatas.get(position), position);
        int layoutId = itemViewDelegate.getLayoutId();
        XLvViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            viewHolder = new XLvViewHolder(context, convertView, position);
            viewHolder.setLayoutId(layoutId);
            onViewHolderCreated(viewHolder, viewHolder.getmConvertView());
        } else {
            viewHolder = (XLvViewHolder) convertView.getTag();
            viewHolder.setPosition(position);
        }


        convert(viewHolder, getItem(position), position);
        return convertView;
    }

    protected void convert(XLvViewHolder viewHolder, T item, int position) {
        itemViewDelegateManager.convert(viewHolder, item, position);
    }

    public void onViewHolderCreated(XLvViewHolder viewHolder, View view) {
    }

    public ItemViewDelegate<T> getItemDelegate(T item, int posi) {
        return itemViewDelegateManager.getItemViewDelegate(item, posi);
    }

    public ItemViewDelegate<T> getItemDelegate(int posi) {
        return itemViewDelegateManager.getItemViewDelegate(mDatas.get(posi), posi);
    }

    /**
     * 局部刷新
     *
     * @param mListView
     * @param posi
     */
    public void updateSingleRow(ListView mListView, int posi) {
        if (mListView != null) {
            int visiblePos = mListView.getFirstVisiblePosition();
            int offset = posi - mListView.getHeaderViewsCount() - visiblePos;
            int lenth = mListView.getChildCount();
            // 只有在可见区域才更新,因为不在可见区域得不到Tag,会出现空指针,所以这是必须有的一个步骤
            if ((offset < 0) || (offset >= lenth)) return;
            View convertView = mListView.getChildAt(offset);
            XLvViewHolder xLvViewHolder = (XLvViewHolder) convertView.getTag();
            T item = mDatas.get(posi);
            convertByPosi(xLvViewHolder, item, posi);
        }
    }

    private void convertByPosi(XLvViewHolder xLvViewHolder, T item, int posi) {
        itemViewDelegateManager.convertByPosi(xLvViewHolder, item, posi);
    }


}
