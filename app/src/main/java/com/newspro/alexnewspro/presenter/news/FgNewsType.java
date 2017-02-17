package com.newspro.alexnewspro.presenter.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.event.NewsActionBtnEvent;
import com.newspro.alexnewspro.event.NewsLoadingEvent;
import com.newspro.alexnewspro.event.NewsRefreshEvent;
import com.newspro.alexnewspro.view.news.FgNewsTypeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class FgNewsType extends MvpBaseFrag<FgNewsTypeView,MvpModel> implements View.OnClickListener,ViewPager.OnPageChangeListener {

    boolean isRefreshOver = true;

    ArrayList<FgNews> fgNewses;

    private List<String> titles;
    private ArrayList<String> types;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        //初始化内容里需要的fragment
        fgNewses = new ArrayList<>();
        titles = new ArrayList<>();
        types = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = Constant.NEWS_TITLES_MAP.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entrySet) {
            titles.add(stringStringEntry.getValue());
            types.add(stringStringEntry.getKey());
            FgNews fgNews = new FgNews();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.NEWS_TYPE_STR, stringStringEntry.getKey());
            fgNews.setArguments(bundle);
            fgNewses.add(fgNews);
        }

        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshOverEvent(NewsActionBtnEvent actionBtnEvent) {
        this.isRefreshOver = actionBtnEvent.isRefreshOver();
        mvpView.stopActionBtnAnim();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadingEvent(NewsLoadingEvent event){
        if (event.isLoading()) {
            mvpView.startActionBtnAnim();
        }
    }

    @Override
    public void onClick(View v) {
        if (isRefreshOver) {
            NewsRefreshEvent newsRefreshEvent = new NewsRefreshEvent();
            newsRefreshEvent.setType(mvpView.getSelectFgNewsType());
            EventBus.getDefault().post(newsRefreshEvent);
            isRefreshOver = false;
            mvpView.startActionBtnAnim();
        }
    }

    public ArrayList<String> getTitles(){
        return (ArrayList<String>) this.titles;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<FgNews> getNewsFgs(){
        return this.fgNewses;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {
        System.out.println("position = " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
