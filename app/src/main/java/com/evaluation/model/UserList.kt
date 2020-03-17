package com.evaluation.model

import com.evaluation.model.info.Info
import com.evaluation.model.result.Result
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class UserList(
    @SerializedName("results")
    val mResultList: ArrayList<Result>,

    @SerializedName("info")
    val mInfo: Info
)