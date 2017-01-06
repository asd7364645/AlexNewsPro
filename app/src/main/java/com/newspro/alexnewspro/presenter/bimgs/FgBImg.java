package com.newspro.alexnewspro.presenter.bimgs;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.BImgsModel;
import com.newspro.alexnewspro.model.bean.BImgListBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.bimg.FgBimgView;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBImg extends MvpBaseFrag<FgBimgView> implements SwipeRefreshLayout.OnRefreshListener{

    private int bImgType;
    private BImgsModel bImgsModel;
    private int page = 1;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        bImgsModel = new BImgsModel();
        bImgType = getArguments().getInt("bImgType");
    }


    public void refreshBImgs(final boolean isRefresh) {
        if (isRefresh)
            page = 1;
        else
            page = ++page;
        bImgsModel.getImgsList(bImgType, page, new MvpModelCallBack<BImgListBean>() {
            @Override
            public void result(BImgListBean data) {
                mvpView.showSuccess(data.getTngou(),isRefresh);
                ToastUtils.showShort(getContext(), Constant.BIMG_TITLE_SPARSEARRAY.get(bImgType)+" 加载成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "类型：" + Constant.BIMG_TITLE_SPARSEARRAY.get(bImgType) + ",原因：" + data);
                    mvpView.setRefreshLayoutRefresh(false);
                    mvpView.showError();
                }
            }
        });
    }


    @Override
    public void onRefresh() {
       refreshBImgs(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bImgsModel.getImgListCall() != null && !bImgsModel.getImgListCall().isCanceled()) {
            bImgsModel.getImgListCall().cancel();
        }
    }
}
