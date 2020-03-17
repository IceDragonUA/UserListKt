package com.evaluation.model.result.picture

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Picture(
    @SerializedName("large")
    val mLarge: String,

    @SerializedName("medium")
    val mMedium: String,

    @SerializedName("thumbnail")
    val mThumbnail: String
)