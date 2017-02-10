package com.newspro.xbaseadapter.ordinarylistview.delegate;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;

import com.newspro.xbaseadapter.ordinarylistview.XLvViewHolder;

/**
 * Created by Alex on 2017/1/12.
 * Alex
 * <p>
 * 用于管理ItemViewDelegate的类
 */

public class ItemViewDelegateManager<T> {

    /**
     * 用于保存所有类别的实现类的集合，可以在这里处理每个类别的item
     */
    private SparseArrayCompat<ItemViewDelegate<T>> delegates;

    public ItemViewDelegateManager() {
        delegates = new SparseArrayCompat<>();
    }

    /**
     * 得到类别的个数
     * @return
     */
    public int getDelegateCount() {
        return delegates.size();
    }

    /**
     * 向集合中添加一种类别,自动设置类别
     *
     * @param itemViewDelegate
     * @return
     */
    public ItemViewDelegateManager<T> addDelegate(@NonNull ItemViewDelegate<T> itemViewDelegate) {
        int viewType = delegates.size();
        return addDelegate(viewType,itemViewDelegate);
    }

    /**
     * 向集合中添加一种类别，自己设置viewType
     *
     * @param viewType
     * @param itemViewDelegate
     * @return
     */
    public ItemViewDelegateManager<T> addDelegate(int viewType, @NonNull ItemViewDelegate<T> itemViewDelegate) {
        if (delegates.get(viewType) != null)
            throw new IllegalArgumentException("已经存在这个类别，类别：" + viewType + "类别对象为：" + delegates.get(viewType));

        if (viewType>=Integer.MAX_VALUE){
            throw new IllegalArgumentException("类别过大，建议在Integer最大值之内");
        }

        if (itemViewDelegate != null)
            delegates.put(viewType, itemViewDelegate);

        return this;
    }

    /**
     * 得到item的类别
     * @param item
     * @param posi
     * @return
     */
    public int getItemViewType(T item,int posi){
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            ItemViewDelegate<T> itemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (itemViewDelegate.isForViewType(item,posi)){
                return delegates.keyAt(i);
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }

    public int getItemViewType(ItemViewDelegate<T> itemViewDelegate){
        return delegates.indexOfValue(itemViewDelegate);
    }

    /**
     * 通过实现类来删除delegates对应项
     * @param itemViewDelegate
     * @return
     */
    public ItemViewDelegateManager<T> removeDelegate(@NonNull ItemViewDelegate<T> itemViewDelegate){
        int removePosi = delegates.indexOfValue(itemViewDelegate);
        if (removePosi>=0){
            delegates.removeAt(removePosi);
        }
        return this;
    }

    /**
     * 通过类别来删除delegates对应项
     * @param viewType
     * @return
     */
    public ItemViewDelegateManager<T> removeDelegate(int viewType){
        delegates.remove(viewType);
        return this;
    }

    public void convert(XLvViewHolder holder, T item, int posi){
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            ItemViewDelegate<T> itemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (itemViewDelegate.isForViewType(item,posi)){
                itemViewDelegate.convert(holder,item,posi);
                return;
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }

    /**
     * 局部刷新需要设置的
     * @param holder
     * @param item
     * @param posi
     */
    public void convertByPosi(XLvViewHolder holder, T item, int posi){
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            ItemViewDelegate<T> itemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (itemViewDelegate.isForViewType(item,posi)){
                itemViewDelegate.convertByPosi(holder,item,posi);
                return;
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }

    public ItemViewDelegate<T> getItemViewDelegate(T item,int posi){
        int size = delegates.size();
        for (int i = 0; i < size; i++) {
            //拿到当前delegate，判断delegate是否为当前所在的类别
            ItemViewDelegate<T> itemViewDelegate = delegates.valueAt(i);
            //如果是则返回
            if (itemViewDelegate.isForViewType(item,posi)){
                return itemViewDelegate;
            }
        }
        throw new IllegalArgumentException("没有找到这种类别");
    }

    public int getItemLayoutId(int viewType){
        return delegates.get(viewType).getLayoutId();
    }

    public int getItemLayoutId(T item, int position){
        return getItemViewDelegate(item,position).getLayoutId();
    }

}
