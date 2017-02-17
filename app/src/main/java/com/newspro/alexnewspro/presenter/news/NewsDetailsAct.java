package com.newspro.alexnewspro.presenter.news;

import android.content.Intent;
import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsDetailsContentAdapter;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.presenter.BigImgAct;
import com.newspro.alexnewspro.view.news.NewsDetailsView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailsAct extends MvpBaseAct<NewsDetailsView,MvpModel> implements NewsDetailsContentAdapter.NewsDetailsContentsItemClickListener{

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
    }

    @Override
    public void click(int posi) {
        //点击查看大图，进入大图的界面
        int selectImgPosi = getSelectImgPosi(posi);
        Intent intent = new Intent(this, BigImgAct.class);
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) imgs);
        intent.putExtra("selectPosi", selectImgPosi);
        if (selectImgPosi !=-1) {
            startActivity(intent);
            overridePendingTransition(R.anim.activity_anim_in,0);
        }
    }

    /**
     * 得到当前选择图片在图片列表中的位置
     * @param posi
     * @return
     */
    private int getSelectImgPosi(int posi){
        String content = contentlistBean.getAllList().get(posi);
        int size = imgs.size();
        for (int i = 0;i<size;i++) {
            if (content.equals(imgs.get(i))){
                return i;
            }
        }
        return -1;
    }

}
