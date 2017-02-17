package com.newspro.xbaseadapter.recycler_baseadapter.delegate;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;

import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;


/**
 * Created by Alex on 2017/1/12.
 * Alex
 * <p>
 * 用于管理ItemViewDelegate的类
 */

public class RvItemViewDelegateManager<T> {

    /**
     * 用于保存所有类别的实现类的集合，可以在这里处理每个类别的item
     */
    private SparseArrayCompat<RvItemViewDelegate<T>> delegates;

    public RvItemViewDelegateManager() {
        delegates = new SparseArrayCompat<>();
    }

    /**
     * 得到类别的个数
     *
     * @return
     */
    public int getDelegateCount() {
        return delegates.size();
    }

    /**
     * 向集合中添加一种类别,自动设置类别
     *
     * @param rvItemViewDelegate
     * @return
     */
    public RvItemViewDelegateManager<T> addDelegate(@NonNull RvItemViewDelegate<T> rvItemViewDelegate) {
        int viewType = delegates.size();
        return addDelegate(viewType, rvItemViewDelegate);
    }

    /**
     * 向集合中添加一种类别，自己设置viewType
     *
     * @param viewType
     * @param rvItemViewDelegate
     * @return
     */
    public RvItemViewDelegateManager<T> addDelegate(int viewType, @NonNull RvItemViewDelegate<T> rvItemViewDelegate) {
        if (delegates.get(viewType) != null)
            throw new IllegalArgumentException("已经存在这个类别，类别：" + viewType + "类别对象为：" + delegates.get(viewType));

        if (viewType >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("类别过大，建议在Integer最大值之内");
        }

        if (rvItemViewDelegate != null)
            delegates.put(viewType, rvItemViewDelegate);

        return this;
    }

    /**
     * 得到item的类别
     *
     * @param item
     * @param posi
     * @return
     */
    public int getItemViewType(T item, int posi) {
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            RvItemViewDelegate<T> rvItemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (rvItemViewDelegate.isForViewType(item, posi)) {
                return delegates.keyAt(i);
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }

    public int getItemViewType(RvItemViewDelegate<T> rvItemViewDelegate) {
        return delegates.indexOfValue(rvItemViewDelegate);
    }

    /**
     * 通过实现类来删除delegates对应项
     *
     * @param rvItemViewDelegate
     * @return
     */
    public RvItemViewDelegateManager<T> removeDelegate(@NonNull RvItemViewDelegate<T> rvItemViewDelegate) {
        int removePosi = delegates.indexOfValue(rvItemViewDelegate);
        if (removePosi >= 0) {
            delegates.removeAt(removePosi);
        }
        return this;
    }

    /**
     * 通过类别来删除delegates对应项
     *
     * @param viewType
     * @return
     */
    public RvItemViewDelegateManager<T> removeDelegate(int viewType) {
        delegates.remove(viewType);
        return this;
    }

    public void convert(XRvViewHolder holder, T item, int posi) {
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            RvItemViewDelegate<T> rvItemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (rvItemViewDelegate.isForViewType(item, posi)) {

                rvItemViewDelegate.findViews(holder);

                rvItemViewDelegate.convert(holder, item, posi);
                return;
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }
    public void convertByPosi(XRvViewHolder holder, T item, int posi) {
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            RvItemViewDelegate<T> rvItemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (rvItemViewDelegate.isForViewType(item, posi)) {

                rvItemViewDelegate.findViews(holder);

                rvItemViewDelegate.convertByPosi(holder, item, posi);
                return;
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }


    /**
     * 通过type来得到ItemViewDelegate
     * @param type
     * @return
     */
    public RvItemViewDelegate<T> getItemViewDelegate(int type) {
        return delegates.get(type);
    }

    public int getItemLayoutId(int viewType) {
        return delegates.get(viewType).getLayoutId();
    }


}
