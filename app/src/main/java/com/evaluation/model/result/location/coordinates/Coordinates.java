package com.evaluation.model.result.location.coordinates;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Coordinates {

    @SerializedName("latitude")
    private String mLatitude;

    @SerializedName("longitude")
    private String mLongitude;

    public String getLatitude() {
        return mLatitude;
    }

    public String getLongitude() {
        return mLongitude;
    }
}
