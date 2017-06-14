package com.newspro.xbaseadapter.recycler_baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegate;
import com.newspro.xbaseadapter.recycler_baseadapter.delegate.RvItemViewDelegateManager;

import java.util.List;

/**
 * Created by Alex on 2017/1/16.
 * Alex
 */

public class XRvMultiItemTypeAdapter<T> extends RecyclerView.Adapter<XRvViewHolder> {

    private Context context;
    private List<T> mDatas;

    private RvItemViewDelegateManager<T> rvItemViewDelegateManager;
    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickListener onItemLongClickListener;

    public XRvMultiItemTypeAdapter(Context context, List<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        rvItemViewDelegateManager = new RvItemViewDelegateManager<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (useItemViewDelegateManager())
            return rvItemViewDelegateManager.getItemViewType(mDatas.get(position), position);
        return super.getItemViewType(position);
    }

    @Override
    public XRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RvItemViewDelegate<T> rvItemViewDelegate = rvItemViewDelegateManager.getItemViewDelegate(viewType);
        int layoutId = rvItemViewDelegate.getLayoutId();
        XRvViewHolder xRvViewHolder = XRvViewHolder.createXRvViewHolder(context, parent, layoutId);
        onViewHolderCreated(xRvViewHolder, xRvViewHolder.getmConvertView());
        setListener(xRvViewHolder);
        return xRvViewHolder;
    }

    protected void setListener(final XRvViewHolder xRvViewHolder) {
        View convertView = xRvViewHolder.getmConvertView();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(v, xRvViewHolder, xRvViewHolder.getAdapterPosition());
                }
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return onItemLongClickListener != null && onItemLongClickListener.onLongClick(v, xRvViewHolder, xRvViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position) {
        this.onBindViewHolder(holder,position,null);
    }

    @Override
    public void onBindViewHolder(XRvViewHolder holder, int position, List<Object> payloads) {
        if (payloads == null || payloads.isEmpty()) {
            convert(holder, mDatas.get(position));
        } else {
            convertByPosi(holder, mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private boolean useItemViewDelegateManager() {
        return rvItemViewDelegateManager.getDelegateCount() > 0;
    }

    public RvItemViewDelegate<T> getItemViewDelegate(int posi) {
        return rvItemViewDelegateManager.getItemViewDelegate(rvItemViewDelegateManager.getItemViewType(mDatas.get(posi), posi));
    }

    private void convertByPosi(XRvViewHolder xRvViewHolder, T item) {
        rvItemViewDelegateManager.convertByPosi(xRvViewHolder, item, xRvViewHolder.getAdapterPosition());
    }

    public void notifyItemByPosi(int posi) {
        notifyItemChanged(posi, 1);
    }

    /**
     * 创建完ViewHolder的处理
     *
     * @param xRvViewHolder
     * @param view
     */
    private void onViewHolderCreated(XRvViewHolder xRvViewHolder, View view) {

    }

    private void convert(XRvViewHolder holder, T item) {
        rvItemViewDelegateManager.convert(holder, item, holder.getAdapterPosition());
    }

    public XRvMultiItemTypeAdapter<T> addDelegate(RvItemViewDelegate<T> rvItemViewDelegate) {
        rvItemViewDelegateManager.addDelegate(rvItemViewDelegate);
        return this;
    }

    public XRvMultiItemTypeAdapter<T> addDelegate(int type, RvItemViewDelegate<T> rvItemViewDelegate) {
        rvItemViewDelegateManager.addDelegate(type, rvItemViewDelegate);
        return this;
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    public Context getContext() {
        return context;
    }

    public interface OnItemClickListener {
        void onClick(View view, XRvViewHolder holder, int position);
    }

    public interface OnItemLongClickListener {
        boolean onLongClick(View view, XRvViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
