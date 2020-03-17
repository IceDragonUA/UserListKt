package com.evaluation.model.result.id;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Id {

    @SerializedName("name")
    private String mName;

    @SerializedName("value")
    private String mValue;

    public String getName() {
        return mName;
    }

    public String getValue() {
        return mValue;
    }
}
