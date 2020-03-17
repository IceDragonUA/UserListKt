package com.evaluation.model.result.id

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Id(
    @SerializedName("name")
    val mName: String,

    @SerializedName("value")
    val mValue: String
)