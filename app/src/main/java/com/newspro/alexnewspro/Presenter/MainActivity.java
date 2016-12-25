package com.newspro.alexnewspro.Presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.view.MainView;

public class MainActivity extends MvpBaseAct<MainView> implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_navigation_news:
                mvpView.selectFg(0);
                break;
        }
        return true;
    }
}
