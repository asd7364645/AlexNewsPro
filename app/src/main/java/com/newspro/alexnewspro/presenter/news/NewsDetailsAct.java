package com.newspro.alexnewspro.presenter.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsDetailsContentAdapter;
import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.presenter.BigImgAct;
import com.newspro.alexnewspro.utils.BmobUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.news.NewsDetailsView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailsAct extends MvpBaseAct<NewsDetailsView, NewsModel> implements NewsDetailsContentAdapter.NewsDetailsImgItemClickListener, View.OnClickListener {

    private boolean isCollect = false;
    private String collectObjId;
    private Intent intent;
    private List<String> imgs;
    private ContentlistBean contentlistBean;

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        intent = getIntent();
        contentlistBean = intent.getParcelableExtra("newsBean");
        mvpView.showAll(contentlistBean);
        imgs = contentlistBean.getImageurls();
        mvpView.setCollectBtnEnable(false);
        if (BmobUtils.UserUtils.isLogin()) {
            mvpModel.getIsCollectWithUser(contentlistBean.getLink(), BmobUtils.UserUtils.getUserId(), new MvpModelCallBack<String>() {
                @Override
                public void result(String data) {
                    collectObjId = data;
                    isCollect = true;
                    mvpView.setCollectBtnEnable(true);
                    mvpView.setCollect(isCollect);
                }
            }, new MvpModelCallBack<Void>() {
                @Override
                public void result(Void data) {
                    isCollect = false;
                    mvpView.setCollectBtnEnable(true);
                    mvpView.setCollect(isCollect);
                }
            });
        }


    }

    @Override
    public void click(int posi) {
        //点击查看大图，进入大图的界面
        int selectImgPosi = getSelectImgPosi(posi);
        Intent intent = new Intent(this, BigImgAct.class);
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) imgs);
        intent.putExtra("selectPosi", selectImgPosi);
        if (selectImgPosi != -1) {
            startActivity(intent);
            overridePendingTransition(R.anim.activity_anim_in, 0);
        }
    }

    /**
     * 得到当前选择图片在图片列表中的位置
     *
     * @param posi
     * @return
     */
    private int getSelectImgPosi(int posi) {
        String content = contentlistBean.getAllList().get(posi);
        int size = imgs.size();
        for (int i = 0; i < size; i++) {
            if (content.equals(imgs.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.news_details_floating_btn:
                if (BmobUtils.UserUtils.isLogin()) {
                    if (isCollect) {
                        mvpView.setCollectBtnEnable(false);
                        deleteCollect();
                    } else {
                        mvpView.setCollectBtnEnable(false);
                        addCollect();
                    }
                }
                break;
        }
    }

    private void deleteCollect() {
        mvpModel.deleteCollect(collectObjId, new MvpModelCallBack<Void>() {
            @Override
            public void result(Void data) {
                ToastUtils.showShort(NewsDetailsAct.this, "删除收藏成功！");
                isCollect = false;
                mvpView.setCollectBtnEnable(true);
                mvpView.setCollect(isCollect);
            }
        }, new MvpModelCallBack<Integer>() {
            @Override
            public void result(Integer data) {
                ToastUtils.showShort(NewsDetailsAct.this, "删除收藏失败！");
                isCollect = true;
                mvpView.setCollectBtnEnable(true);
                mvpView.setCollect(isCollect);
            }
        });
    }

    private void addCollect() {
        mvpModel.addCollect(BmobUtils.UserUtils.getUserId(), contentlistBean.getLink(), contentlistBean.getTitle(), new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                ToastUtils.showShort(NewsDetailsAct.this, "添加成功！");
                collectObjId = data;
                isCollect = true;
                mvpView.setCollectBtnEnable(true);
                mvpView.setCollect(isCollect);
            }
        }, new MvpModelCallBack<Integer>() {
            @Override
            public void result(Integer data) {
                ToastUtils.showShort(NewsDetailsAct.this, "添加失败！");
                isCollect = false;
                mvpView.setCollectBtnEnable(true);
                mvpView.setCollect(isCollect);
            }
        });
    }
}
