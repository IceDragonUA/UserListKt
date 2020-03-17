package com.evaluation.model.result.location.street;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Street {

    @SerializedName("number")
    private Integer mNumber;

    @SerializedName("name")
    private String mName;

    public Integer getNumber() {
        return mNumber;
    }

    public String getName() {
        return mName;
    }
}
