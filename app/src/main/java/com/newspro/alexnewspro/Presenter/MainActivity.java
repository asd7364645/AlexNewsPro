package com.newspro.alexnewspro.presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.view.MainView;

public class MainActivity extends MvpBaseAct<MainView>
        implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_navigation_news:
                mvpView.closeDrawer();
                mvpView.selectFg(0, Constant.TITLE_NEWS);
                break;
            case R.id.menu_navigation_imgs:
                mvpView.closeDrawer();
                mvpView.selectFg(1, Constant.TITLE_BIMGS);
                break;
        }
        return true;
    }
}
