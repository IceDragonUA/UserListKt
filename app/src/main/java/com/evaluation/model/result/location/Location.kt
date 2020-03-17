package com.evaluation.model.result.location

import com.evaluation.model.result.location.coordinates.Coordinates
import com.evaluation.model.result.location.street.Street
import com.evaluation.model.result.location.timezone.Timezone
import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
class Location(
    @SerializedName("street")
    val mStreet: Street,

    @SerializedName("city")
    val mCity: String,

    @SerializedName("state")
    val mState: String,

    @SerializedName("country")
    val mCountry: String,

    @SerializedName("postcode")
    val mPostcode: String,

    @SerializedName("coordinates")
    val mCoordinates: Coordinates,

    @SerializedName("timezone")
    val mTimezone: Timezone
)