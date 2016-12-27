package com.newspro.alexnewspro.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsBean implements Parcelable {


    private int showapi_res_code;
    private String showapi_res_error;

    private ShowapiResBodyBean showapi_res_body;

    protected NewsBean(Parcel in) {
        showapi_res_code = in.readInt();
        showapi_res_error = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(showapi_res_code);
        dest.writeString(showapi_res_error);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel in) {
            return new NewsBean(in);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean implements Parcelable {
        private int ret_code;

        private PagebeanBean pagebean;

        protected ShowapiResBodyBean(Parcel in) {
            ret_code = in.readInt();
        }

        public static final Creator<ShowapiResBodyBean> CREATOR = new Creator<ShowapiResBodyBean>() {
            @Override
            public ShowapiResBodyBean createFromParcel(Parcel in) {
                return new ShowapiResBodyBean(in);
            }

            @Override
            public ShowapiResBodyBean[] newArray(int size) {
                return new ShowapiResBodyBean[size];
            }
        };

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(ret_code);
        }

        public static class PagebeanBean implements Parcelable {
            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            /**
             * pubDate : 2016-12-27 09:11:32
             * havePic : true
             * title : 美媒撰文试水中国摔角市场 王彬成开门金钥匙
             * channelName : 综合体育最新
             * imageurls : [{"height":427,"width":640,"url":"http://img1.gtimg.com/sports/pics/hv1/124/167/2172/141277009.jpg"},{"height":427,"width":640,"url":"http://img1.gtimg.com/sports/pics/hv1/146/167/2172/141277031.jpg"}]
             * desc : 近日，美国权威媒体《纽约时报》撰文体育潮兴起，职业摔角欲试水中国庞大新市场。为寻找观众和更多收入来源，世界摔角娱乐公司（WWE）对中国这个庞大市场充满雄心。
             * source : 综合体育新闻
             * channelId : 5572a10ab3cdc86cf39001ea
             * link : http://sports.qq.com/a/20161227/009683.htm
             */

            private List<ContentlistBean> contentlist;

            protected PagebeanBean(Parcel in) {
                allPages = in.readInt();
                currentPage = in.readInt();
                allNum = in.readInt();
                maxResult = in.readInt();
            }

            public static final Creator<PagebeanBean> CREATOR = new Creator<PagebeanBean>() {
                @Override
                public PagebeanBean createFromParcel(Parcel in) {
                    return new PagebeanBean(in);
                }

                @Override
                public PagebeanBean[] newArray(int size) {
                    return new PagebeanBean[size];
                }
            };

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(allPages);
                dest.writeInt(currentPage);
                dest.writeInt(allNum);
                dest.writeInt(maxResult);
            }

            public static class ContentlistBean implements Parcelable {
                private String pubDate;
                private boolean havePic;
                private String title;
                private String channelName;
                private String desc;
                private String source;
                private String channelId;
                private String link;
                /**
                 * height : 427
                 * width : 640
                 * url : http://img1.gtimg.com/sports/pics/hv1/124/167/2172/141277009.jpg
                 */

                private List<ImageurlsBean> imageurls;

                protected ContentlistBean(Parcel in) {
                    pubDate = in.readString();
                    havePic = in.readByte() != 0;
                    title = in.readString();
                    channelName = in.readString();
                    desc = in.readString();
                    source = in.readString();
                    channelId = in.readString();
                    link = in.readString();
                }

                public static final Creator<ContentlistBean> CREATOR = new Creator<ContentlistBean>() {
                    @Override
                    public ContentlistBean createFromParcel(Parcel in) {
                        return new ContentlistBean(in);
                    }

                    @Override
                    public ContentlistBean[] newArray(int size) {
                        return new ContentlistBean[size];
                    }
                };

                public String getPubDate() {
                    return pubDate;
                }

                public void setPubDate(String pubDate) {
                    this.pubDate = pubDate;
                }

                public boolean isHavePic() {
                    return havePic;
                }

                public void setHavePic(boolean havePic) {
                    this.havePic = havePic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getChannelName() {
                    return channelName;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getChannelId() {
                    return channelId;
                }

                public void setChannelId(String channelId) {
                    this.channelId = channelId;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public List<ImageurlsBean> getImageurls() {
                    return imageurls;
                }

                public void setImageurls(List<ImageurlsBean> imageurls) {
                    this.imageurls = imageurls;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(pubDate);
                    dest.writeByte((byte) (havePic ? 1 : 0));
                    dest.writeString(title);
                    dest.writeString(channelName);
                    dest.writeString(desc);
                    dest.writeString(source);
                    dest.writeString(channelId);
                    dest.writeString(link);
                }

                public static class ImageurlsBean implements Parcelable {
                    private int height;
                    private int width;
                    private String url;

                    protected ImageurlsBean(Parcel in) {
                        height = in.readInt();
                        width = in.readInt();
                        url = in.readString();
                    }

                    public static final Creator<ImageurlsBean> CREATOR = new Creator<ImageurlsBean>() {
                        @Override
                        public ImageurlsBean createFromParcel(Parcel in) {
                            return new ImageurlsBean(in);
                        }

                        @Override
                        public ImageurlsBean[] newArray(int size) {
                            return new ImageurlsBean[size];
                        }
                    };

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(height);
                        dest.writeInt(width);
                        dest.writeString(url);
                    }
                }
            }
        }
    }
}
