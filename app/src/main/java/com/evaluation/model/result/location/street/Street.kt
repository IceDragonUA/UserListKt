package com.evaluation.model.result.location.street

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Street(
    @SerializedName("number")
    val mNumber: Int,

    @SerializedName("name")
    val mName: String
)