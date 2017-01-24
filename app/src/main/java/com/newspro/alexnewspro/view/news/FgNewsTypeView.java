package com.newspro.alexnewspro.view.news;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.presenter.news.FgNewsType;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.NewsTypeVpAdapter;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class FgNewsTypeView extends MvpBaseFragView<FgNewsType> {

    private TabLayout news_type_tablayout;
    private ViewPager news_type_viewpager;

    private FloatingActionButton fg_news_type_refresh_act_btn;

    private NewsTypeVpAdapter newsTypeVpAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_news_type;
    }

    @Override
    public void findMvpViews() {
        news_type_tablayout = findViewById(R.id.base_tablayout);
        news_type_viewpager = findViewById(R.id.news_type_viewpager);
        fg_news_type_refresh_act_btn = findViewById(R.id.fg_news_type_refresh_act_btn);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        newsTypeVpAdapter = new NewsTypeVpAdapter(presenter.getChildFragmentManager(),presenter.getNewsFgs(),presenter.getTitles());
        news_type_viewpager.setAdapter(newsTypeVpAdapter);
        news_type_tablayout.setupWithViewPager(news_type_viewpager);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_news_type_refresh_act_btn.setOnClickListener(presenter);
        news_type_viewpager.addOnPageChangeListener(presenter);
    }

    @Override
    protected void setView() {
        news_type_viewpager.setCurrentItem(0);
        super.setView();
    }

    /**
     * 得到当前选择的fragment新闻type
     */
    public String getSelectFgNewsType() {
        return presenter.getTypes().get(news_type_tablayout.getSelectedTabPosition());
    }

    public void startActionBtnAnim(){
        Animation rotateAnimation = AnimationUtils.loadAnimation(this.getContext(),R.anim.fg_news_action_anim);
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        fg_news_type_refresh_act_btn.startAnimation(rotateAnimation);
    }

    public void stopActionBtnAnim(){
        if (fg_news_type_refresh_act_btn.getAnimation()!=null){
            fg_news_type_refresh_act_btn.clearAnimation();
        }
    }

}
