package com.evaluation.model.result.location.timezone;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Timezone {

    @SerializedName("offset")
    private String mOffset;

    @SerializedName("description")
    private String mDescription;

    public String getOffset() {
        return mOffset;
    }

    public String getDescription() {
        return mDescription;
    }
}
