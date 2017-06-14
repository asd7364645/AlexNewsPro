package com.newspro.alexnewspro.bean.baisi;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Alex on 2017/6/9.
 * Alex
 */

public class BaiSiBean extends BmobObject{


    private int ret_code;

    private PagebeanBean pagebean;

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

    public static class PagebeanBean {
        private int allPages;
        private int currentPage;
        private int allNum;
        private int maxResult;

        private List<ContentlistBean> contentlist;

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

        public static class ContentlistBean {
            private String text;
            private String hate;
            private String videotime;
            private String voicetime;
            private String weixin_url;
            private String profile_image;
            private String width;
            private String cdn_img;
            private String voiceuri;
            private String type;
            private String ct;
            private String image0;
            private String id;
            private String love;
            private String image2;
            private String image1;
            private String height;
            private String _id;
            private String name;
            private String create_time;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getHate() {
                return hate;
            }

            public void setHate(String hate) {
                this.hate = hate;
            }

            public String getVideotime() {
                return videotime;
            }

            public void setVideotime(String videotime) {
                this.videotime = videotime;
            }

            public String getVoicetime() {
                return voicetime;
            }

            public void setVoicetime(String voicetime) {
                this.voicetime = voicetime;
            }

            public String getWeixin_url() {
                return weixin_url;
            }

            public void setWeixin_url(String weixin_url) {
                this.weixin_url = weixin_url;
            }

            public String getProfile_image() {
                return profile_image;
            }

            public void setProfile_image(String profile_image) {
                this.profile_image = profile_image;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getCdn_img() {
                return cdn_img;
            }

            public void setCdn_img(String cdn_img) {
                this.cdn_img = cdn_img;
            }

            public String getVoiceuri() {
                return voiceuri;
            }

            public void setVoiceuri(String voiceuri) {
                this.voiceuri = voiceuri;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public String getImage0() {
                return image0;
            }

            public void setImage0(String image0) {
                this.image0 = image0;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLove() {
                return love;
            }

            public void setLove(String love) {
                this.love = love;
            }

            public String getImage2() {
                return image2;
            }

            public void setImage2(String image2) {
                this.image2 = image2;
            }

            public String getImage1() {
                return image1;
            }

            public void setImage1(String image1) {
                this.image1 = image1;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }
    }
}
