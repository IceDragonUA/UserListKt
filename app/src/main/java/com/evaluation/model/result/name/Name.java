package com.evaluation.model.result.name;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Name {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("first")
    private String mFirst;

    @SerializedName("last")
    private String mLast;

    public String getTitle() {
        return mTitle;
    }

    public String getFirst() {
        return mFirst;
    }

    public String getLast() {
        return mLast;
    }
}
