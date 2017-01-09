package com.newspro.alexnewspro.http;

import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.bean.BImgListBean;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public interface HttpInterface {
    /**
     * 新闻接口
     */
    interface NewsInterface {
        /**
         * 获取新闻列表
         *
         * @param channelId 新闻类型
         * @param page      当前页数
         * @return
         */
        @GET(Constant.NEWS_DEF_PARAM)
        Call<JSONObject> getNews(@Query("channelId") String channelId, @Query("page") int page);
    }

    /**
     * 美图列表接口
     */
    interface BImgsInterface {
        @GET("{page}" )
        Call<BImgListBean> getBImgList(@Path("page") int page);
    }

}
