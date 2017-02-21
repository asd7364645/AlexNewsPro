package com.newspro.alexnewspro.model.bean.doubanmovie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class DetailsSubjectBean implements Parcelable{

    /**
     * max : 10
     * average : 7.8
     * stars : 40
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"average":7.8,"stars":"40","min":0}
     * reviews_count : 78
     * wish_count : 4526
     * douban_site :
     * year : 2002
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2174120073.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2174120073.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2174120073.jpg"}
     * alt : https://movie.douban.com/subject/1306809/
     * id : 1306809
     * mobile_url : https://movie.douban.com/subject/1306809/mobile
     * title : 生化危机
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1306809
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["英国","德国","法国","美国"]
     * genres : ["动作","科幻","恐怖"]
     * collect_count : 138653
     * casts : [{"alt":"https://movie.douban.com/celebrity/1025154/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/2431.jpg","large":"https://img3.doubanio.com/img/celebrity/large/2431.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/2431.jpg"},"name":"米拉·乔沃维奇","id":"1025154"},{"alt":"https://movie.douban.com/celebrity/1025174/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/23535.jpg","large":"https://img3.doubanio.com/img/celebrity/large/23535.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/23535.jpg"},"name":"米歇尔·罗德里格兹","id":"1025174"},{"alt":"https://movie.douban.com/celebrity/1314721/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/27565.jpg","large":"https://img3.doubanio.com/img/celebrity/large/27565.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27565.jpg"},"name":"科林·萨蒙","id":"1314721"},{"alt":"https://movie.douban.com/celebrity/1044914/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/10215.jpg","large":"https://img3.doubanio.com/img/celebrity/large/10215.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/10215.jpg"},"name":"埃里克·马比斯","id":"1044914"}]
     * current_season : null
     * original_title : Resident Evil
     * summary : 为军方研究生化武器的安布雷拉公司在浣熊市地下设有巨大的研究中心——蜂巢，由于一次意外事故导致可通过空气传播的生化武器泄露，负责蜂巢安保的电脑系统“红色女王”启动应急措施，却导致数百名工作人员罹难……四小时后，蜂巢安保人员爱丽丝（米拉·乔沃维奇 Milla Jovovich 饰）在蜂巢出口醒来，并且因为催眠气体而失忆。一支受命关闭红色女王的特种小队来到此处，与爱丽丝、自称警察的安德森，以及蜂巢工作人员帕克斯组队深入地下。一行人因任务目标与红色女王冲突而先后遭遇保卫系统和丧尸的连番袭击，而爱丽丝渐渐恢复的记忆揭示了她与同行者非同一般的联系。这场生化丧尸危机该如何解除？又或者根本是一曲绝望的前奏？
     本片是根据知名电子游戏《生化危机》改编而成系列电影的首部。©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1031921/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/11288.jpg","large":"https://img1.doubanio.com/img/celebrity/large/11288.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/11288.jpg"},"name":"保罗·安德森","id":"1031921"}]
     * comments_count : 13771
     * ratings_count : 103895
     * aka : ["2002恶灵古堡","生化危机之变种生还","生化危机"]
     */

    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2174120073.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2174120073.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2174120073.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private String share_url;
    private int collect_count;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    /**
     * alt : https://movie.douban.com/celebrity/1025154/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/2431.jpg","large":"https://img3.doubanio.com/img/celebrity/large/2431.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/2431.jpg"}
     * name : 米拉·乔沃维奇
     * id : 1025154
     */

    private List<CastsBean> casts;
    /**
     * alt : https://movie.douban.com/celebrity/1031921/
     * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/11288.jpg","large":"https://img1.doubanio.com/img/celebrity/large/11288.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/11288.jpg"}
     * name : 保罗·安德森
     * id : 1031921
     */

    private List<DirectorsBean> directors;
    private List<String> aka;

    protected DetailsSubjectBean(Parcel in) {
        reviews_count = in.readInt();
        wish_count = in.readInt();
        douban_site = in.readString();
        year = in.readString();
        alt = in.readString();
        id = in.readString();
        mobile_url = in.readString();
        title = in.readString();
        share_url = in.readString();
        collect_count = in.readInt();
        original_title = in.readString();
        summary = in.readString();
        subtype = in.readString();
        comments_count = in.readInt();
        ratings_count = in.readInt();
        countries = in.createStringArrayList();
        genres = in.createStringArrayList();
        aka = in.createStringArrayList();
    }

    public static final Creator<DetailsSubjectBean> CREATOR = new Creator<DetailsSubjectBean>() {
        @Override
        public DetailsSubjectBean createFromParcel(Parcel in) {
            return new DetailsSubjectBean(in);
        }

        @Override
        public DetailsSubjectBean[] newArray(int size) {
            return new DetailsSubjectBean[size];
        }
    };

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(reviews_count);
        dest.writeInt(wish_count);
        dest.writeString(douban_site);
        dest.writeString(year);
        dest.writeString(alt);
        dest.writeString(id);
        dest.writeString(mobile_url);
        dest.writeString(title);
        dest.writeString(share_url);
        dest.writeInt(collect_count);
        dest.writeString(original_title);
        dest.writeString(summary);
        dest.writeString(subtype);
        dest.writeInt(comments_count);
        dest.writeInt(ratings_count);
        dest.writeStringList(countries);
        dest.writeStringList(genres);
        dest.writeStringList(aka);
    }

    public static class RatingBean implements Parcelable{
        private int max;
        private double average;
        private String stars;
        private int min;

        protected RatingBean(Parcel in) {
            max = in.readInt();
            average = in.readDouble();
            stars = in.readString();
            min = in.readInt();
        }

        public static final Creator<RatingBean> CREATOR = new Creator<RatingBean>() {
            @Override
            public RatingBean createFromParcel(Parcel in) {
                return new RatingBean(in);
            }

            @Override
            public RatingBean[] newArray(int size) {
                return new RatingBean[size];
            }
        };

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(max);
            dest.writeDouble(average);
            dest.writeString(stars);
            dest.writeInt(min);
        }
    }

    public static class ImagesBean implements Parcelable{
        private String small;
        private String large;
        private String medium;

        protected ImagesBean(Parcel in) {
            small = in.readString();
            large = in.readString();
            medium = in.readString();
        }

        public static final Creator<ImagesBean> CREATOR = new Creator<ImagesBean>() {
            @Override
            public ImagesBean createFromParcel(Parcel in) {
                return new ImagesBean(in);
            }

            @Override
            public ImagesBean[] newArray(int size) {
                return new ImagesBean[size];
            }
        };

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(small);
            dest.writeString(large);
            dest.writeString(medium);
        }
    }

    public static class CastsBean implements Parcelable{
        private String alt;
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/2431.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/2431.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/2431.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        protected CastsBean(Parcel in) {
            alt = in.readString();
            name = in.readString();
            id = in.readString();
        }

        public static final Creator<CastsBean> CREATOR = new Creator<CastsBean>() {
            @Override
            public CastsBean createFromParcel(Parcel in) {
                return new CastsBean(in);
            }

            @Override
            public CastsBean[] newArray(int size) {
                return new CastsBean[size];
            }
        };

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(alt);
            dest.writeString(name);
            dest.writeString(id);
        }

    }

    public static class DirectorsBean implements Parcelable{
        private String alt;
        /**
         * small : https://img1.doubanio.com/img/celebrity/small/11288.jpg
         * large : https://img1.doubanio.com/img/celebrity/large/11288.jpg
         * medium : https://img1.doubanio.com/img/celebrity/medium/11288.jpg
         */

        private AvatarsBean avatars;
        private String name;
        private String id;

        protected DirectorsBean(Parcel in) {
            alt = in.readString();
            name = in.readString();
            id = in.readString();
        }

        public static final Creator<DirectorsBean> CREATOR = new Creator<DirectorsBean>() {
            @Override
            public DirectorsBean createFromParcel(Parcel in) {
                return new DirectorsBean(in);
            }

            @Override
            public DirectorsBean[] newArray(int size) {
                return new DirectorsBean[size];
            }
        };

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(alt);
            dest.writeString(name);
            dest.writeString(id);
        }

    }
}
