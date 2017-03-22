package com.newspro.alexnewspro.bean;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsBean extends BmobObject {


    private int showapi_res_code;
    private String showapi_res_error;

    private ShowapiResBodyBean showapi_res_body;

    public NewsBean(int showapi_res_code, String showapi_res_error, ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_code = showapi_res_code;
        this.showapi_res_error = showapi_res_error;
        this.showapi_res_body = showapi_res_body;
    }

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

    public static class ShowapiResBodyBean extends BmobObject {
        private int ret_code;

        private PagebeanBean pagebean;

        public ShowapiResBodyBean(int ret_code, PagebeanBean pagebean) {
            this.ret_code = ret_code;
            this.pagebean = pagebean;
        }

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

        public static class PagebeanBean extends BmobObject {
            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;

            private List<ContentlistBean> contentlist;

            public PagebeanBean(int allPages, int currentPage, int allNum, int maxResult, List<ContentlistBean> contentlist) {
                this.allPages = allPages;
                this.currentPage = currentPage;
                this.allNum = allNum;
                this.maxResult = maxResult;
                this.contentlist = contentlist;
            }

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

            public static class ContentlistBean extends BmobObject{
                //用户ID
                private String userId;

                private String pubDate;
                private boolean havePic;
                private String title;
                private String channelName;
                private String desc;
                private String source;
                private String channelId;
                private String link;
                private List<String> allList;

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

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

            }
        }
    }
}
