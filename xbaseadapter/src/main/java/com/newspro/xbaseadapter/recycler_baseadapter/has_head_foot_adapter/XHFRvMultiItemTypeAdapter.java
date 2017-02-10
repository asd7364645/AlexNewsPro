package com.newspro.xbaseadapter.recycler_baseadapter.has_head_foot_adapter;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.newspro.xbaseadapter.recycler_baseadapter.XRvMultiItemTypeAdapter;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public class XHFRvMultiItemTypeAdapter<T> extends XRvMultiItemTypeAdapter<T> {


    //头部类型
    private static final int HEADER_ITEM_TYPE = 100000;
    //脚部类型
    private static final int FOOTER_ITEM_TYPE = 200000;
    //头部集合
    private SparseArrayCompat<View> mHeaderViews;
    //脚部集合
    private SparseArrayCompat<View> mFooterViews;

    public XHFRvMultiItemTypeAdapter(Context context, List<T> mDatas) {
        super(context, mDatas);
        mHeaderViews = new SparseArrayCompat<>();
        mFooterViews = new SparseArrayCompat<>();
    }

    @Override
    public int getItemViewType(int position) {
        //header and footer
        getItemCount();
        if (isHeaderViewPosi(position)) {
            return mHeaderViews.keyAt(position);
        } else if (isFooterViewPosi(position)) {
            return mFooterViews.keyAt(footerViewPosition(position));
        } else {
            return super.getItemViewType(position-getHeaderViewSize());
        }
    }

    private int footerViewPosition(int position) {
        return position - getHeaderViewSize() - getmDatas().size();
    }

    @Override
    public XRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //header and footer
        if (mHeaderViews.get(viewType) != null) {
            return XRvViewHolder.createXRvViewHolder(getContext(), mHeaderViews.get(viewType));
        } else if (mFooterViews.get(viewType) != null) {
            return XRvViewHolder.createXRvViewHolder(getContext(), mFooterViews.get(viewType));
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    protected void setListener(final XRvViewHolder xRvViewHolder) {
        View convertView = xRvViewHolder.getmConvertView();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    int position = xRvViewHolder.getAdapterPosition()-getHeaderViewSize();
                    onItemClickListener.onClick(v, xRvViewHolder, position);
                }
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = xRvViewHolder.getAdapterPosition()-getHeaderViewSize();
                return onItemLongClickListener != null && onItemLongClickListener.onLongClick(v, xRvViewHolder, position);
            }
        });
//        super.setListener(xRvViewHolder);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    if (mHeaderViews.get(viewType) != null) {
                        return gridLayoutManager.getSpanCount();
                    } else if (mFooterViews.get(viewType) != null) {
                        return gridLayoutManager.getSpanCount();
                    }
                    if (spanSizeLookup != null)
                        return spanSizeLookup.getSpanSize(position);
                    return 1;
                }
            });
        }

    }

    @Override
    public void onViewAttachedToWindow(XRvViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position = holder.getLayoutPosition();
        if (isHeaderViewPosi(position) || isFooterViewPosi(position)) {
            setFullSpan(holder);
        }
    }

    private void setFullSpan(XRvViewHolder holder) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position, List<Object> payloads) {
        if (isHeaderViewPosi(position)) {
            return;
        } else if (isFooterViewPosi(position)) {
            return;
        }
        super.onBindViewHolder(holder, position-getHeaderViewSize(), payloads);
    }

    @Override
    public int getItemCount() {
        int dataSize = super.getItemCount();
        return dataSize + mHeaderViews.size() + mFooterViews.size();
    }

    @Override
    public void notifyItemByPosi(int posi) {
        super.notifyItemByPosi(posi+getHeaderViewSize());
    }

    /**
     * 判断当前position是否是在header中
     *
     * @param position
     * @return
     */
    private boolean isHeaderViewPosi(int position) {
        return position < getHeaderViewSize();
    }

    /**
     * 判断当前position是否是在footer中
     *
     * @param position
     * @return
     */
    private boolean isFooterViewPosi(int position) {
        return position >= getHeaderViewSize() + getmDatas().size();
    }

    private int getHeaderViewSize() {
        return mHeaderViews.size();
    }

    public void addHeaders(View view) {
        mHeaderViews.put(mHeaderViews.size() - HEADER_ITEM_TYPE, view);
    }

    public void addFooters(View view) {
        mFooterViews.put(mFooterViews.size() - FOOTER_ITEM_TYPE, view);
    }

}
