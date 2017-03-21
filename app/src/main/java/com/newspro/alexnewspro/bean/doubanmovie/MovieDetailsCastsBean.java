package com.newspro.alexnewspro.bean.doubanmovie;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class MovieDetailsCastsBean {

    private boolean isCasts;
    private String alt;
    private AvatarsBean avatars;
    private String name;
    private String id;

    public MovieDetailsCastsBean(boolean isCasts, String alt, AvatarsBean avatars, String name, String id) {
        this.isCasts = isCasts;
        this.alt = alt;
        this.avatars = avatars;
        this.name = name;
        this.id = id;
    }


    public boolean isCasts() {
        return isCasts;
    }

    public void setCasts(boolean casts) {
        isCasts = casts;
    }

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
}
