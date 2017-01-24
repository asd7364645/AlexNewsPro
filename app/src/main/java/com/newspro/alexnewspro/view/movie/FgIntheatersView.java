package com.newspro.alexnewspro.view.movie;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.presenter.movie.FgInTheaters;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class FgIntheatersView extends MvpBaseFragView<FgInTheaters> {

    private XRecyclerView fg_intheaters_rv;

    @Override
    public int setLayoutId() {
        return R.layout.fg_intheaters;
    }

    @Override
    public void findMvpViews() {
        fg_intheaters_rv = findViewById(R.id.fg_intheaters_rv);
    }
}
