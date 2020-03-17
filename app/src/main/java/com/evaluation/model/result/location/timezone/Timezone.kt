package com.evaluation.model.result.location.timezone

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Timezone(
    @SerializedName("offset")
    val mOffset: String,

    @SerializedName("description")
    val mDescription: String
)