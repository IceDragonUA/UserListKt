package com.evaluation.model.result.location;

import com.evaluation.model.result.location.coordinates.Coordinates;
import com.evaluation.model.result.location.street.Street;
import com.evaluation.model.result.location.timezone.Timezone;
import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Location {

    @SerializedName("street")
    private Street mStreet;

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("postcode")
    private String mPostcode;

    @SerializedName("coordinates")
    private Coordinates mCoordinates;

    @SerializedName("timezone")
    private Timezone mTimezone;

    public Street getStreet() {
        return mStreet;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getPostcode() {
        return mPostcode;
    }

    public Coordinates getCoordinates() {
        return mCoordinates;
    }

    public Timezone getTimezone() {
        return mTimezone;
    }
}
