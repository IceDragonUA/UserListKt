package com.evaluation.model.result

import com.evaluation.model.result.dob.Dob
import com.evaluation.model.result.id.Id
import com.evaluation.model.result.location.Location
import com.evaluation.model.result.login.Login
import com.evaluation.model.result.name.Name
import com.evaluation.model.result.picture.Picture
import com.evaluation.model.result.registered.Registered
import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
data class Result(
    @SerializedName("gender")
    val mGender: String,

    @SerializedName("name")
    val mName: Name,

    @SerializedName("location")
    val mLocation: Location,

    @SerializedName("email")
    val mEmail: String,

    @SerializedName("login")
    val mLogin: Login,

    @SerializedName("dob")
    val mDob: Dob,

    @SerializedName("registered")
    val mRegistered: Registered,

    @SerializedName("phone")
    val mPhone: String,

    @SerializedName("cell")
    val mCell: String,

    @SerializedName("id")
    val mId: Id,

    @SerializedName("picture")
    val mPicture: Picture,

    @SerializedName("nat")
    val mNat: String
)