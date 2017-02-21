package com.newspro.alexnewspro.model.bean.doubanmovie;

import android.os.Parcel;
import android.os.Parcelable;

public class AvatarsBean implements Parcelable {
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