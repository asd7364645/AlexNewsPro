package com.newspro.alexnewspro.bean.doubanmovie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class MoviesListBean implements Parcelable{

    private int count;
    private int start;
    private int total;
    private String title;
    /**
     * rating : {"max":10,"average":7.8,"stars":"40","min":0}
     * genres : ["剧情","科幻"]
     * title : 降临
     * casts : [{"alt":"https://movie.douban.com/celebrity/1022563/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/23782.jpg","large":"https://img3.doubanio.com/img/celebrity/large/23782.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/23782.jpg"},"name":"艾米·亚当斯","id":"1022563"},{"alt":"https://movie.douban.com/celebrity/1013770/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/15184.jpg","large":"https://img3.doubanio.com/img/celebrity/large/15184.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/15184.jpg"},"name":"杰瑞米·雷纳","id":"1013770"},{"alt":"https://movie.douban.com/celebrity/1053567/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/40097.jpg","large":"https://img1.doubanio.com/img/celebrity/large/40097.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/40097.jpg"},"name":"福里斯特·惠特克","id":"1053567"}]
     * collect_count : 53484
     * original_title : Arrival
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1028333/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1451296171.85.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1451296171.85.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1451296171.85.jpg"},"name":"丹尼斯·维伦纽瓦","id":"1028333"}]
     * year : 2016
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2411622421.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2411622421.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2411622421.jpg"}
     * alt : https://movie.douban.com/subject/21324900/
     * id : 21324900
     */

    private List<SubjectsBean> subjects;

    protected MoviesListBean(Parcel in) {
        count = in.readInt();
        start = in.readInt();
        total = in.readInt();
        title = in.readString();
    }

    public static final Creator<MoviesListBean> CREATOR = new Creator<MoviesListBean>() {
        @Override
        public MoviesListBean createFromParcel(Parcel in) {
            return new MoviesListBean(in);
        }

        @Override
        public MoviesListBean[] newArray(int size) {
            return new MoviesListBean[size];
        }
    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeInt(start);
        dest.writeInt(total);
        dest.writeString(title);
    }

}
