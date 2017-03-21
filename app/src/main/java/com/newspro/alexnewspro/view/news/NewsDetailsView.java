package com.newspro.alexnewspro.view.news;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsDetailsContentAdapter;
import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.presenter.news.NewsDetailsAct;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/28.
 * Alex
 */

public class NewsDetailsView extends MvpBaseView<NewsDetailsAct> {

    private CoordinatorLayout activity_news_details;
    private Toolbar news_details_toolbar;
    private AppBarLayout news_details_appbar_layout;
    private ImageView news_details_appbar_img;
    private RecyclerView news_details_recycler;
    private CollapsingToolbarLayout news_details_coll_layout;
    private FloatingActionButton news_details_floating_btn;
    private TextView news_details_title_tv, news_details_date,
            news_details_desc_tv;
    private List<String> contents;
    //适配器
    private NewsDetailsContentAdapter newsDetailsContentAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    public void findMvpViews() {
        news_details_toolbar = findViewById(R.id.news_details_toolbar);
        news_details_appbar_layout = findViewById(R.id.news_details_appbar_layout);
        activity_news_details = findViewById(R.id.activity_news_details);
        news_details_appbar_img = findViewById(R.id.news_details_appbar_img);
        news_details_recycler = findViewById(R.id.news_details_recycler);
        news_details_floating_btn = findViewById(R.id.news_details_floating_btn);
        news_details_coll_layout = findViewById(R.id.news_details_coll_layout);
        news_details_title_tv = findViewById(R.id.news_details_title_tv);
        news_details_desc_tv = findViewById(R.id.news_details_desc_tv);
        news_details_date = findViewById(R.id.news_details_date);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        news_details_floating_btn.setOnClickListener(presenter);
    }

    @Override
    public Toolbar getToolBar() {

        return news_details_toolbar;
    }

    @Override
    protected void setView() {
        super.setView();
        //设置recyclerview与NestedScrollView嵌套的解决方案,详情查看笔记中
        LinearLayoutManager contentLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        contentLayoutManager.setSmoothScrollbarEnabled(true);
        contentLayoutManager.setAutoMeasureEnabled(true);
        //设置内容RecyclerView
        contents = new ArrayList<>();
        newsDetailsContentAdapter = new NewsDetailsContentAdapter(contents, this.getContext());
        newsDetailsContentAdapter.setNewsDetailsImgItemClickListener(presenter);
        news_details_recycler.setLayoutManager(contentLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        news_details_recycler.setHasFixedSize(true);
        news_details_recycler.setNestedScrollingEnabled(false);
        news_details_recycler.setAdapter(newsDetailsContentAdapter);
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);
        AlexStatusBarUtils.setCollapsingToolbar(presenter, activity_news_details, news_details_appbar_layout, news_details_appbar_img, news_details_toolbar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        news_details_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.finish();
            }
        });
    }

    public void showAll(final ContentlistBean contentlistBean) {
        if (!contentlistBean.getImageurls().isEmpty())
            showNewsBigImg(contentlistBean.getImageurls().get(0));
        showTitle(contentlistBean.getTitle());
        showSourceAndDate(contentlistBean.getSource(), contentlistBean.getPubDate());
        showDesc(contentlistBean.getDesc());
        showContentsAll(contentlistBean.getAllList());
    }

    public void setCollect(boolean isCollect) {
        if (isCollect)
            news_details_floating_btn.setImageResource(R.drawable.ic_star_24dp);
        else
            news_details_floating_btn.setImageResource(R.drawable.ic_star_border_24dp);
    }

    public void setCollectBtnEnable(boolean enable){
        news_details_floating_btn.setEnabled(enable);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    private void showTitle(CharSequence title) {
        news_details_coll_layout.setTitle(title);
        news_details_title_tv.setText(title);
    }

    /**
     * 设置来源和时间
     *
     * @param source
     * @param date
     */
    private void showSourceAndDate(CharSequence source, CharSequence date) {
        news_details_date.setText(source + "\t" + date);
    }

    /**
     * 设置简述
     *
     * @param desc
     */
    private void showDesc(CharSequence desc) {
        news_details_desc_tv.setText(desc);
    }

    /**
     * 设置全文内容
     *
     * @param contents
     */
    private void showContentsAll(List<String> contents) {
        this.contents.clear();
        this.contents.addAll(contents);
        newsDetailsContentAdapter.notifyDataSetChanged();
    }

    /**
     * 设置图片头
     *
     * @param url
     */
    private void showNewsBigImg(String url) {
        GlideLoader.getInstance().display(news_details_appbar_img, url, R.drawable.img, 0);
    }

}
