package com.newspro.alexnewspro.bean;

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

    public NewsBean(int showapi_res_code, String showapi_res_error, ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_code = showapi_res_code;
        this.showapi_res_error = showapi_res_error;
        this.showapi_res_body = showapi_res_body;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(showapi_res_code);
        dest.writeString(showapi_res_error);
    }

    public static class ShowapiResBodyBean implements Parcelable{
        private int ret_code;

        private PagebeanBean pagebean;

        protected ShowapiResBodyBean(Parcel in) {
            ret_code = in.readInt();
        }

        public ShowapiResBodyBean(int ret_code, PagebeanBean pagebean) {
            this.ret_code = ret_code;
            this.pagebean = pagebean;
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

        public static class PagebeanBean implements Parcelable{
            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;

            private List<ContentlistBean> contentlist;

            protected PagebeanBean(Parcel in) {
                allPages = in.readInt();
                currentPage = in.readInt();
                allNum = in.readInt();
                maxResult = in.readInt();
                contentlist = in.createTypedArrayList(ContentlistBean.CREATOR);
            }

            public PagebeanBean(int allPages, int currentPage, int allNum, int maxResult, List<ContentlistBean> contentlist) {
                this.allPages = allPages;
                this.currentPage = currentPage;
                this.allNum = allNum;
                this.maxResult = maxResult;
                this.contentlist = contentlist;
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
                dest.writeTypedList(contentlist);
            }

            public static class ContentlistBean implements Parcelable{
                private String pubDate;
                private boolean havePic;
                private String title;
                private String channelName;
                private String desc;
                private String source;
                private String channelId;
                private String link;
                private List<String> allList;
                /**
                 * height : 360
                 * width : 640
                 * url : http://img1.gtimg.com/ent/pics/hv1/192/188/2173/141347457.jpg
                 */

                private List<String> imageurls;

                public ContentlistBean(String pubDate, boolean havePic, String title, String channelName, String desc, String source, String channelId, String link, List<String> allList, List<String> imageurls) {
                    this.pubDate = pubDate;
                    this.havePic = havePic;
                    this.title = title;
                    this.channelName = channelName;
                    this.desc = desc;
                    this.source = source;
                    this.channelId = channelId;
                    this.link = link;
                    this.allList = allList;
                    this.imageurls = imageurls;
                }

                protected ContentlistBean(Parcel in) {
                    pubDate = in.readString();
                    havePic = in.readByte() != 0;
                    title = in.readString();
                    channelName = in.readString();
                    desc = in.readString();
                    source = in.readString();
                    channelId = in.readString();
                    link = in.readString();
                    allList = in.createStringArrayList();
                    imageurls = in.createStringArrayList();
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
                    dest.writeStringList(allList);
                    dest.writeStringList(imageurls);
                }

                @Override
                public int describeContents() {
                    return 0;
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

                public List<String> getAllList() {
                    return allList;
                }

                public void setAllList(List<String> allList) {
                    this.allList = allList;
                }

                public List<String> getImageurls() {
                    return imageurls;
                }

                public void setImageurls(List<String> imageurls) {
                    this.imageurls = imageurls;
                }

//                public static class ImageurlsBean implements Parcelable{
//                    private String url;
//
//                    protected ImageurlsBean(Parcel in) {
//                        url = in.readString();
//                    }
//
//                    public ImageurlsBean(String url) {
//                        this.url = url;
//                    }
//
//                    public static final Creator<ImageurlsBean> CREATOR = new Creator<ImageurlsBean>() {
//                        @Override
//                        public ImageurlsBean createFromParcel(Parcel in) {
//                            return new ImageurlsBean(in);
//                        }
//
//                        @Override
//                        public ImageurlsBean[] newArray(int size) {
//                            return new ImageurlsBean[size];
//                        }
//                    };
//
//                    public String getUrl() {
//                        return url;
//                    }
//
//                    public void setUrl(String url) {
//                        this.url = url;
//                    }
//
//                    @Override
//                    public int describeContents() {
//                        return 0;
//                    }
//
//                    @Override
//                    public void writeToParcel(Parcel dest, int flags) {
//                        dest.writeString(url);
//                    }
//                }
            }
        }
    }
}
