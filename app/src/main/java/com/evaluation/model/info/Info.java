package com.evaluation.model.info;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Info {

    @SerializedName("seed")
    private String mSeed;

    @SerializedName("results")
    private Integer mResults;

    @SerializedName("page")
    private Integer mPage;

    @SerializedName("version")
    private String mVersion;

    public String getSeed() {
        return mSeed;
    }

    public Integer getResults() {
        return mResults;
    }

    public Integer getPage() {
        return mPage;
    }

    public String getVersion() {
        return mVersion;
    }
}
