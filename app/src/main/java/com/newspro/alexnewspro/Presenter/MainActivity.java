package com.newspro.alexnewspro.presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.view.MainView;

public class MainActivity extends MvpBaseAct<MainView,MvpModel>
        implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_navigation_news:
                mvpView.closeDrawer();
                mvpView.selectFg(0);
                break;
            case R.id.menu_navigation_imgs:
                mvpView.closeDrawer();
                mvpView.selectFg(1);
                break;
            case R.id.menu_navigation_movies:
                mvpView.closeDrawer();
                mvpView.selectFg(2);
                break;
        }
        return true;
    }
}
