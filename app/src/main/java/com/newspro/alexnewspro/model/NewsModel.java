package com.newspro.alexnewspro.model;

import android.os.AsyncTask;

import com.example.alex.mvplibrary.model.MvpModelInterface;
import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.http.converter.JsonConverterFactory;
import com.newspro.alexnewspro.http.httpinterface.NewsInterface;
import com.newspro.alexnewspro.model.bean.NewsBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsModel implements MvpModelInterface {

    private static final String TAG = "NewsModel";

    private Call<JSONObject> newsBeanCall;

    /**
     * 根据type来获取新闻列表
     *
     * @param type
     */
    public void getNewsOfType(String type, int page, final MvpModelCallBack<NewsBean.ShowapiResBodyBean.PagebeanBean> success, final MvpModelCallBack<String> failure) {
        newsBeanCall = RetrofitUtil.retrofitUtil(Constant.NEWS_URL, JsonConverterFactory.create()).create(NewsInterface.class).getNews(type, page);
        newsBeanCall.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                changeJsonToNewsBean(response.body(), success);

            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                failure.result("获取失败，请检查网络");
            }
        });
    }

    public Call<JSONObject> getNewsBeanCall() {
        return newsBeanCall;
    }

    /**
     * 转化JSON为NewsBean
     *
     * @param result
     * @param callback
     */
    private void changeJsonToNewsBean(JSONObject result, final MvpModelCallBack<NewsBean.ShowapiResBodyBean.PagebeanBean> callback) {

        new AsyncTask<JSONObject, Void, NewsBean>() {

            @Override
            protected NewsBean doInBackground(JSONObject... params) {
                NewsBean newsBean = changeJSONToNews(params[0]);
                if (newsBean == null) return null;
                return newsBean;
            }

            @Override
            protected void onPostExecute(NewsBean newsBean) {
                super.onPostExecute(newsBean);
                if (newsBean != null) {
                    callback.result(newsBean.getShowapi_res_body().getPagebean());
                }
            }
        }.execute(result);

    }

    /**
     * 新闻的JSON比较特殊，所以手动转化为新闻对象
     *
     * @param params
     * @return
     */
    private NewsBean changeJSONToNews(JSONObject params) {
        int showapi_res_code = params.optInt("showapi_res_code");
        String showapi_res_error = params.optString("showapi_res_error");
        JSONObject showapi_res_body = params.optJSONObject("showapi_res_body");
        if (showapi_res_body == null) return null;
        int ret_code = showapi_res_body.optInt("ret_code");
        JSONObject pagebean = showapi_res_body.optJSONObject("pagebean");
        if (pagebean == null) return null;
        int allPages = pagebean.optInt("allPages");
        int currentPage = pagebean.optInt("currentPage");
        int allNum = pagebean.optInt("allNum");
        int maxResult = pagebean.optInt("maxResult");
        JSONArray contentlist = pagebean.optJSONArray("contentlist");
        if (contentlist == null) return null;
        List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistBeans = new ArrayList<>();
        for (int i = 0; i < contentlist.length(); i++) {
            JSONObject content = contentlist.optJSONObject(i);
            String pubDate = content.optString("pubDate");
            boolean havePic = content.optBoolean("havePic");
            String title = content.optString("title");
            String channelName = content.optString("channelName");
            String desc = content.optString("desc");
            String source = content.optString("source");
            String channelId = content.optString("channelId");
            String link = content.optString("link");

            JSONArray allListArray = content.optJSONArray("allList");
            List<String> allListStr = new ArrayList<>();
            if (null == allListArray)
                return null;
            for (int j = 0; j < allListArray.length(); j++) {
                if (allListArray.opt(j) instanceof JSONObject) {
                    JSONObject imgJSONObj = allListArray.optJSONObject(j);
                    allListStr.add(imgJSONObj.optString("url"));
                } else {
                    allListStr.add(allListArray.optString(j));
                }
            }
            JSONArray imgUrlsArray = content.optJSONArray("imageurls");
            List<String> imageurls = new ArrayList<>();
            if (null == imgUrlsArray)
                return null;
            for (int j = 0; j < imgUrlsArray.length(); j++) {
                JSONObject imgJsonObj = imgUrlsArray.optJSONObject(j);
                imageurls.add(imgJsonObj.optString("url"));
            }
            NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean contentlistBean = new NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean(pubDate, havePic, title, channelName, desc, source, channelId, link, allListStr, imageurls);
            contentlistBeans.add(contentlistBean);
        }
        NewsBean.ShowapiResBodyBean.PagebeanBean pagebeanBean = new NewsBean.ShowapiResBodyBean.PagebeanBean(allPages, currentPage, allNum, maxResult, contentlistBeans);
        NewsBean.ShowapiResBodyBean showapiResBodyBean = new NewsBean.ShowapiResBodyBean(ret_code, pagebeanBean);
        NewsBean newsBean = new NewsBean(showapi_res_code, showapi_res_error, showapiResBodyBean);
        return newsBean;
    }


}
