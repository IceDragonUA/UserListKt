package com.evaluation.model.result.name

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Name(
    @SerializedName("title")
    val mTitle: String,

    @SerializedName("first")
    val mFirst: String,

    @SerializedName("last")
    val mLast: String
)