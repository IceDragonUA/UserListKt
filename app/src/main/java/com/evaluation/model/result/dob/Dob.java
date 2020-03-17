package com.evaluation.model.result.dob;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Dob {

    @SerializedName("date")
    private String mDate;

    @SerializedName("age")
    private Integer mAge;

    public String getDate() {
        return mDate;
    }

    public Integer getAge() {
        return mAge;
    }
}
