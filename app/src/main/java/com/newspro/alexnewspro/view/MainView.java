package com.newspro.alexnewspro.view;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.example.alex.mvplibrary.presenter.MvpPresenter;
import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.Presenter.FgNews;
import com.newspro.alexnewspro.R;

/**
 * Created by Alex on 2016/12/23.
 * Alex
 */

public class MainView extends MvpBaseView {

    //ToolBar
    private Toolbar base_toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout main_drawer_layout;
    private NavigationView main_navigation_view;
    private FgNews fgNews;

    public void selectFg(int tab){
        FragmentTransaction fragmentTransaction = getContext().getSupportFragmentManager().beginTransaction();
        hideAllFg(fragmentTransaction);
        switch (tab){
            case 0:
                if (fgNews == null){
                    fgNews = new FgNews();
                    fragmentTransaction.add(R.id.main_center_replace,fgNews);
                }else {
                    fragmentTransaction.show(fgNews);
                }
                break;
        }

        fragmentTransaction.commitAllowingStateLoss();

    }

    private void hideAllFg(FragmentTransaction fragmentTransaction) {
        if (fgNews != null)
            fragmentTransaction.hide(fgNews);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void findMvpViews() {
        base_toolbar = findViewById(R.id.base_toolbar);
        main_drawer_layout = findViewById(R.id.main_drawer_layout);
        main_navigation_view = findViewById(R.id.main_navigation_view);
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            System.out.println(" actionbar!=null");
        }
        actionBarDrawerToggle = new ActionBarDrawerToggle(this.getContext(),main_drawer_layout,base_toolbar,R.string.open,R.string.close);
        main_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void setData() {
        super.setData();

    }

    @Override
    public void bindEvent(MvpPresenter presenter) {
        super.bindEvent(presenter);
        main_navigation_view.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) presenter);
    }

    @Override
    protected void setView() {
        super.setView();
        main_navigation_view.setItemIconTintList(null);
    }

    @Override
    public Toolbar getToolBar() {
        return base_toolbar;
    }
}
