package com.newspro.alexnewspro.model.bean.doubanmovie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Alex on 2017/2/15.
 * Alex
 */

public class SubjectsBean implements Parcelable {
    /**
     * max : 10
     * average : 7.8
     * stars : 40
     * min : 0
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2411622421.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2411622421.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2411622421.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    /**
     * alt : https://movie.douban.com/celebrity/1022563/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/23782.jpg","large":"https://img3.doubanio.com/img/celebrity/large/23782.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/23782.jpg"}
     * name : 艾米·亚当斯
     * id : 1022563
     */

    private List<CastsBean> casts;
    /**
     * alt : https://movie.douban.com/celebrity/1028333/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1451296171.85.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1451296171.85.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1451296171.85.jpg"}
     * name : 丹尼斯·维伦纽瓦
     * id : 1028333
     */

    private List<DirectorsBean> directors;

    protected SubjectsBean(Parcel in) {
        title = in.readString();
        collect_count = in.readInt();
        original_title = in.readString();
        subtype = in.readString();
        year = in.readString();
        alt = in.readString();
        id = in.readString();
        genres = in.createStringArrayList();
    }

    public static final Creator<SubjectsBean> CREATOR = new Creator<SubjectsBean>() {
        @Override
        public SubjectsBean createFromParcel(Parcel in) {
            return new SubjectsBean(in);
        }

        @Override
        public SubjectsBean[] newArray(int size) {
            return new SubjectsBean[size];
        }
    };

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(collect_count);
        dest.writeString(original_title);
        dest.writeString(subtype);
        dest.writeString(year);
        dest.writeString(alt);
        dest.writeString(id);
        dest.writeStringList(genres);
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
         * small : https://img3.doubanio.com/img/celebrity/small/23782.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/23782.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/23782.jpg
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

        public static class AvatarsBean implements Parcelable{
            private String small;
            private String large;
            private String medium;

            protected AvatarsBean(Parcel in) {
                small = in.readString();
                large = in.readString();
                medium = in.readString();
            }

            public static final Creator<AvatarsBean> CREATOR = new Creator<AvatarsBean>() {
                @Override
                public AvatarsBean createFromParcel(Parcel in) {
                    return new AvatarsBean(in);
                }

                @Override
                public AvatarsBean[] newArray(int size) {
                    return new AvatarsBean[size];
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
    }

    public static class DirectorsBean implements Parcelable{
        private String alt;
        /**
         * small : https://img3.doubanio.com/img/celebrity/small/1451296171.85.jpg
         * large : https://img3.doubanio.com/img/celebrity/large/1451296171.85.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/1451296171.85.jpg
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

        public static class AvatarsBean implements Parcelable{
            private String small;
            private String large;
            private String medium;

            protected AvatarsBean(Parcel in) {
                small = in.readString();
                large = in.readString();
                medium = in.readString();
            }

            public static final Creator<AvatarsBean> CREATOR = new Creator<AvatarsBean>() {
                @Override
                public AvatarsBean createFromParcel(Parcel in) {
                    return new AvatarsBean(in);
                }

                @Override
                public AvatarsBean[] newArray(int size) {
                    return new AvatarsBean[size];
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
    }
}
