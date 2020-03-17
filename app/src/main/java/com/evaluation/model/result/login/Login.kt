package com.evaluation.model.result.login

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Login(
    @SerializedName("uuid")
    val mUuid: String,

    @SerializedName("username")
    val mUsername: String,

    @SerializedName("password")
    val mPassword: String,

    @SerializedName("salt")
    val mSalt: String,

    @SerializedName("md5")
    val mMd5: String,

    @SerializedName("sha1")
    val mSha1: String,

    @SerializedName("sha256")
    val mSha256: String
)