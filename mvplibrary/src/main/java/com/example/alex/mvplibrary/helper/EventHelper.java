package com.example.alex.mvplibrary.helper;

/**
 * Created by Alex on 2016/12/2.
 * Alex
 */

import android.view.View;
import android.widget.AdapterView;

/**
 * 事件帮助类，提供click,longClick itemClick等常用事件的封装 <br />
 * Created by qibin on 2015/11/15.
 */
public class EventHelper {

    public static void click(View.OnClickListener li, View ...views) {
        if(views == null || views.length == 0) return;
        for(View v : views) v.setOnClickListener(li);
    }

    public static void longClick(View.OnLongClickListener li, View ...views) {
        if(views == null || views.length == 0) return;
        for(View v : views) v.setOnLongClickListener(li);
    }

    public static void itemClick(AdapterView.OnItemClickListener li, AdapterView ...views) {
        if(views == null || views.length == 0) return;
        for(AdapterView v : views) v.setOnItemClickListener(li);
    }

    public static void itemLongClick(AdapterView.OnItemLongClickListener li, AdapterView ... views) {
        if(views == null || views.length == 0) return;
        for(AdapterView v : views) v.setOnItemLongClickListener(li);
    }

    public static void itemSelected(AdapterView.OnItemSelectedListener li, AdapterView ...views) {
        if(views == null || views.length == 0) return;
        for(AdapterView v : views) v.setOnItemSelectedListener(li);
    }
}
