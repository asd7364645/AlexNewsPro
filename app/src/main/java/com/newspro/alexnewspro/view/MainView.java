package com.newspro.alexnewspro.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.example.alex.mvplibrary.presenter.MvpPresenter;
import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.Presenter.FgNewsType;
import com.newspro.alexnewspro.Presenter.MainActivity;
import com.newspro.alexnewspro.R;

/**
 * Created by Alex on 2016/12/23.
 * Alex
 */

public class MainView extends MvpBaseView<MainActivity> {

    //ToolBar
    private Toolbar base_toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout main_drawer_layout;
    private NavigationView main_navigation_view;
    private FgNewsType fgNewsType;

    private FragmentManager fragmentManager;

    /**
     * 设置选中后显示fragment
     * @param tab
     */
    public void selectFg(int tab){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFg(fragmentTransaction);
        switch (tab){
            case 0:
                if (fgNewsType == null){
                    fgNewsType = new FgNewsType();
                    fragmentTransaction.add(R.id.main_center_replace, fgNewsType);
                }else {
                    fragmentTransaction.show(fgNewsType);
                }
                break;
        }

        fragmentTransaction.commitAllowingStateLoss();

    }

    /**
     * 隐藏所有fragment
     * @param fragmentTransaction
     */
    private void hideAllFg(FragmentTransaction fragmentTransaction) {
        if (fgNewsType != null)
            fragmentTransaction.hide(fgNewsType);
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
        }
        actionBarDrawerToggle = new ActionBarDrawerToggle(this.getContext(),main_drawer_layout,base_toolbar,R.string.open,R.string.close);
        main_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        fragmentManager.putFragment(outState,"fgNewsType",fgNewsType);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        fragmentManager = presenter.getSupportFragmentManager();
        if (savedInstanceState!=null){
            fgNewsType = (FgNewsType) fragmentManager.getFragment(savedInstanceState,"fgNewsType");
        }
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
        //设置默认选中颜色
        Resources resources = getContext().getResources();
        main_navigation_view.setItemTextColor(resources.getColorStateList(R.color.main_navigation_menu_selector));
        selectFg(0);
    }

    public void closeDrawer(){
        main_drawer_layout.closeDrawers();
    }

    @Override
    public Toolbar getToolBar() {
        return base_toolbar;
    }
}
