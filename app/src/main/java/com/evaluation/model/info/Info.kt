package com.evaluation.model.info

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Info(
    @SerializedName("seed")
    val mSeed: String,

    @SerializedName("results")
    val mResults: Int,

    @SerializedName("page")
    val mPage: Int,

    @SerializedName("version")
    val mVersion: String
)