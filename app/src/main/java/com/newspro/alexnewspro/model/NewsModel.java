package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.HttpInterface;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.model.bean.NewsBean;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsModel {

    /**
     * 根据type来获取新闻列表
     *
     * @param type
     *
     */
    public void getNewsOfType(String type, int page, final MvpModelCallBack<List> success, final MvpModelCallBack<String> failure) {
        Call<NewsBean> newsBeanCall = RetrofitUtil.RetrofitUtil(Constant.NEWS_URL).create(HttpInterface.NewsInterface.class).getNews(type, page);
        newsBeanCall.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                if (response != null&&response.body().getShowapi_res_code() == 0) {
                    success.result(response.body().getShowapi_res_body().getPagebean().getContentlist());
                }else {
                    failure.result(response.body().getShowapi_res_error());
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                failure.result("错误");
            }
        });
    }

    /**
     * 将新闻详情中的空格转化为\n
     * @param contentlistBean
     */
    public void changeNewsContentSpaceToEnter(ContentlistBean contentlistBean, MvpModelCallBack<ContentlistBean> endContent){
        String content = contentlistBean.getContent();
        content.contains("　　");
        content = content.replace("　","\n\t\t ");
        contentlistBean.setContent(content);
        endContent.result(contentlistBean);
    }

}
