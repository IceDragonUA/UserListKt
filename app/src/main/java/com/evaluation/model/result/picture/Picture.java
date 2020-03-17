package com.evaluation.model.result.picture;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Picture {

    @SerializedName("large")
    private String mLarge;

    @SerializedName("medium")
    private String mMedium;

    @SerializedName("thumbnail")
    private String mThumbnail;

    public String getLarge() {
        return mLarge;
    }

    public String getMedium() {
        return mMedium;
    }

    public String getThumbnail() {
        return mThumbnail;
    }
}
