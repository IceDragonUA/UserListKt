package com.evaluation.model.result.location.coordinates

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Coordinates(
    @SerializedName("latitude")
    val mLatitude: String,

    @SerializedName("longitude")
    val mLongitude: String
)