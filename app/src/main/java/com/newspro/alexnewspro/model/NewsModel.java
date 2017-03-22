package com.newspro.alexnewspro.model;

import android.os.AsyncTask;
import android.util.Log;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.model.MvpModelInterface;
import com.newspro.alexnewspro.bean.NewsBean;
import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.http.converter.JsonConverterFactory;
import com.newspro.alexnewspro.http.httpinterface.NewsInterface;
import com.newspro.alexnewspro.utils.BmobUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
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
        List<ContentlistBean> contentlistBeans = new ArrayList<>();
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
            ContentlistBean contentlistBean = new ContentlistBean(pubDate, havePic, title, channelName, desc, source, channelId, link, allListStr, imageurls);
            contentlistBeans.add(contentlistBean);
        }
        NewsBean.ShowapiResBodyBean.PagebeanBean pagebeanBean = new NewsBean.ShowapiResBodyBean.PagebeanBean(allPages, currentPage, allNum, maxResult, contentlistBeans);
        NewsBean.ShowapiResBodyBean showapiResBodyBean = new NewsBean.ShowapiResBodyBean(ret_code, pagebeanBean);
        NewsBean newsBean = new NewsBean(showapi_res_code, showapi_res_error, showapiResBodyBean);
        return newsBean;
    }

    /**
     * 添加收藏
     *
     * @param userId
     * @param success
     * @param error
     */
    public void addCollect(String userId, ContentlistBean contentlistBean, final MvpModelCallBack<String> success, final MvpModelCallBack<Integer> error) {
        contentlistBean.setUserId(userId);
        BmobUtils.CollectUtils.addCollect(contentlistBean, new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    success.result(s);
                } else {
                    error.result(e.getErrorCode());
                }
            }
        });
    }

    /**
     * 判断该用户是否收藏了这个url的新闻
     *
     * @param url
     * @param userId
     * @param success
     */
    public void getIsCollectWithUser(String url, String userId, final MvpModelCallBack<String> success, final MvpModelCallBack<Void> error) {
        BmobUtils.CollectUtils.getNewsCollectWithUser(url, userId, new FindListener<ContentlistBean>() {
            @Override
            public void done(List<ContentlistBean> list, BmobException e) {
                if (e == null) {
                    if (list.isEmpty())
                        error.result(null);
                    else
                        success.result(list.get(0).getObjectId());
                } else {
                    error.result(null);
                    Log.d(TAG, "done: " + e.getMessage() + "  ::  " + e.getErrorCode());
                }
            }
        });
    }


    /**
     * 删除对应ID的新闻
     *
     * @param objId
     * @param success
     * @param error
     */
    public void deleteCollect(ContentlistBean contentlistBean, String objId, final MvpModelCallBack<Void> success, final MvpModelCallBack<Integer> error) {

        BmobUtils.CollectUtils.deleteCollectWithUrl(contentlistBean, objId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    success.result(null);
                } else {
                    error.result(e.getErrorCode());
                }
            }
        });

    }


}
