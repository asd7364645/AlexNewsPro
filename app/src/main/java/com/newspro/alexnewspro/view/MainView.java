package com.newspro.alexnewspro.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.presenter.MainActivity;
import com.newspro.alexnewspro.presenter.baisibudejie.FgBaiSi;
import com.newspro.alexnewspro.presenter.bimgs.FgBImg;
import com.newspro.alexnewspro.presenter.movie.FgMovie;
import com.newspro.alexnewspro.presenter.news.FgNewsType;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

/**
 * Created by Alex on 2016/12/23.
 * Alex
 */

public class MainView extends MvpBaseView<MainActivity> {

    private CoordinatorLayout main_coordinator;
    //ToolBar
    private Toolbar base_toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout main_drawer_layout;
    private NavigationView main_navigation_view;
    private TextView md_header_name_tv, md_header_login_tv;

    private FgNewsType fgNewsType;
    private FgBImg fgBImg;
    private FgMovie fgMovie;
    private FgBaiSi fgBaiSi;

    private int selectItem;

    private FragmentManager fragmentManager;

    /**
     * 设置选中后显示fragment
     *
     * @param tab
     */
    public void selectFg(int tab) {
        selectItem = tab;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFg(fragmentTransaction);
        switch (tab) {
            case 0:
                if (fgNewsType == null) {
                    fgNewsType = new FgNewsType();
                    fragmentTransaction.add(R.id.main_center_replace, fgNewsType);
                } else {
                    fragmentTransaction.show(fgNewsType);
                }
                main_navigation_view.setCheckedItem(R.id.menu_navigation_news);
                base_toolbar.setTitle(Constant.TITLE_NEWS);
                break;
            case 1:
                if (fgBImg == null) {
                    fgBImg = new FgBImg();
                    fragmentTransaction.add(R.id.main_center_replace, fgBImg);
                } else {
                    fragmentTransaction.show(fgBImg);
                }
                main_navigation_view.setCheckedItem(R.id.menu_navigation_imgs);
                base_toolbar.setTitle(Constant.TITLE_BIMGS);
                break;
            case 2:
                if (fgMovie == null) {
                    fgMovie = new FgMovie();
                    fragmentTransaction.add(R.id.main_center_replace, fgMovie);
                } else {
                    fragmentTransaction.show(fgMovie);
                }
                main_navigation_view.setCheckedItem(R.id.menu_navigation_movies);
                base_toolbar.setTitle(Constant.TITLE_MOVIES);
                break;
            case 3:
                if (fgBaiSi == null){
                    fgBaiSi = new FgBaiSi();
                    fragmentTransaction.add(R.id.main_center_replace,fgBaiSi);
                }else {
                    fragmentTransaction.show(fgBaiSi);
                }
                main_navigation_view.setCheckedItem(R.id.menu_navigation_baisibudejie);
                base_toolbar.setTitle(Constant.TITLE_BAISI);
                break;
        }

        fragmentTransaction.commitAllowingStateLoss();

    }

    /**
     * 隐藏所有fragment
     *
     * @param fragmentTransaction
     */
    private void hideAllFg(FragmentTransaction fragmentTransaction) {
        if (fgNewsType != null)
            fragmentTransaction.hide(fgNewsType);
        if (fgBImg != null)
            fragmentTransaction.hide(fgBImg);
        if (fgMovie != null)
            fragmentTransaction.hide(fgMovie);
        if (fgBaiSi != null)
            fragmentTransaction.hide(fgBaiSi);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void findMvpViews() {
        base_toolbar = findViewById(R.id.base_appbar_toolbar);
        main_coordinator = findViewById(R.id.main_coordinator);
        main_drawer_layout = findViewById(R.id.main_drawer_layout);
        main_navigation_view = findViewById(R.id.main_navigation_view);

        View headerView = main_navigation_view.getHeaderView(0);
        md_header_name_tv = (TextView) headerView.findViewById(R.id.md_header_name_tv);
        md_header_login_tv = (TextView) headerView.findViewById(R.id.md_header_login_tv);
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBarDrawerToggle = new ActionBarDrawerToggle(this.getContext(), main_drawer_layout, base_toolbar, R.string.open, R.string.close);
        main_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putInt("selectItem", selectItem);
        if (fgNewsType != null)
            fragmentManager.putFragment(outState, "fgNewsType", fgNewsType);
        if (fgBImg != null)
            fragmentManager.putFragment(outState, "fgImg", fgBImg);
        if (fgMovie != null)
            fragmentManager.putFragment(outState, "fgMovie", fgMovie);
        if (fgBaiSi != null)
            fragmentManager.putFragment(outState, "fgBaiSi", fgBaiSi);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        fragmentManager = presenter.getSupportFragmentManager();
        if (savedInstanceState != null) {
            selectItem = savedInstanceState.getInt("selectItem");
            if (savedInstanceState.containsKey("fgNewsType"))
                fgNewsType = (FgNewsType) fragmentManager.getFragment(savedInstanceState, "fgNewsType");
            if (savedInstanceState.containsKey("fgImg"))
                fgBImg = (FgBImg) fragmentManager.getFragment(savedInstanceState, "fgImg");
            if (savedInstanceState.containsKey("fgMovie"))
                fgMovie = (FgMovie) fragmentManager.getFragment(savedInstanceState, "fgMovie");
            if (savedInstanceState.containsKey("fgBaiSi"))
                fgBaiSi = (FgBaiSi) fragmentManager.getFragment(savedInstanceState, "fgBaiSi");
        }
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        main_navigation_view.setNavigationItemSelectedListener(presenter);
        md_header_login_tv.setOnClickListener(presenter);
    }

    @Override
    protected void setView() {
        super.setView();
        main_navigation_view.setItemIconTintList(null);
        //设置默认选中颜色
        Resources resources = getContext().getResources();
        main_navigation_view.setItemTextColor(resources.getColorStateList(R.color.main_navigation_menu_selector));
        selectFg(selectItem);
    }

    private void resetNavigationMenu(){
        main_navigation_view.getMenu().clear();
        main_navigation_view.inflateMenu(R.menu.main_navigation_menu);
    }

    private void addUserNavigationMenu(){
        resetNavigationMenu();
        Menu menu = main_navigation_view.getMenu();
        SubMenu subMenu = menu.addSubMenu(R.string.user_string);
        subMenu.add(0,R.id.menu_navigation_uinfo,0,R.string.user_info);
    }

    public void closeDrawer() {
        main_drawer_layout.closeDrawers();
    }

    @Override
    public Toolbar getToolBar() {

        AlexStatusBarUtils.setDyeDrawerStatusColor(presenter, main_drawer_layout, ContextCompat.getColor(presenter, R.color.colorPrimary), 0);

        return base_toolbar;
    }

    public boolean isOpenDrawer(){
        return main_drawer_layout.isDrawerOpen(Gravity.LEFT);
    }

    public void userIsLogin(String userName){
        md_header_name_tv.setText(userName);
        md_header_login_tv.setVisibility(View.GONE);
        addUserNavigationMenu();
        selectFg(selectItem);
    }

    public void userIsLogOut(){
        md_header_name_tv.setText("Alex");
        md_header_login_tv.setVisibility(View.VISIBLE);
        resetNavigationMenu();
        selectFg(selectItem);
    }

}
