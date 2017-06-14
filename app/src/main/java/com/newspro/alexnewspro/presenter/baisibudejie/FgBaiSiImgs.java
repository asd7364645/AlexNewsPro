package com.newspro.alexnewspro.presenter.baisibudejie;

import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.bean.baisi.BaiSiBean;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.baisibudejie.FgBaiSiImgsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class FgBaiSiImgs extends MvpBaseFrag<FgBaiSiImgsView, NewsModel> implements XRecyclerView.LoadingListener {

    private int page = 1;

    private List<BaiSiBean.PagebeanBean.ContentlistBean> datas;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        datas = new ArrayList<>();
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);


    }

    private void refreshList(List<BaiSiBean.PagebeanBean.ContentlistBean> datas, boolean isRefresh) {
        if (isRefresh) {
            this.datas.clear();
        }
        this.datas.addAll(datas);
        mvpView.refreshList();
        mvpView.stopRefreshOrLoading(isRefresh);
    }

    public List<BaiSiBean.PagebeanBean.ContentlistBean> getDatas() {
        return datas;
    }

    @Override
    public void onRefresh() {
        mvpModel.getBaiSiImgsWithPage(Constant.BAISIBUDEJIE_IMGS_TYPE, page, new MvpModelCallBack<BaiSiBean>() {
            @Override
            public void result(BaiSiBean data) {
                if (data.getRet_code() == 0) {
                    refreshList(data.getPagebean().getContentlist(), true);
                }
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                ToastUtils.showShort(getContext(),data);
            }
        });
    }

    @Override
    public void onLoadMore() {

    }
}
