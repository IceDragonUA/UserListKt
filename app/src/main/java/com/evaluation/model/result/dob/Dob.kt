package com.evaluation.model.result.dob

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Dob(
    @SerializedName("date")
    val mDate: String,

    @SerializedName("age")
    val mAge: Int
)