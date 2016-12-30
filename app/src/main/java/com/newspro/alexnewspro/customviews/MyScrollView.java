package com.newspro.alexnewspro.customviews;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * 不根据子控件变化而滚动的scrollView
 * 例如scrollview中嵌套listView在listView加载完毕会滚动到listView，
 * 这个控件就不会滚动
 * Alex
 */

public class MyScrollView extends NestedScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }
}
