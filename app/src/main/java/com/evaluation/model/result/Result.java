package com.evaluation.model.result;

import com.evaluation.model.result.dob.Dob;
import com.evaluation.model.result.id.Id;
import com.evaluation.model.result.location.Location;
import com.evaluation.model.result.login.Login;
import com.evaluation.model.result.name.Name;
import com.evaluation.model.result.picture.Picture;
import com.evaluation.model.result.registered.Registered;
import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Result {

    @SerializedName("gender")
    private String mGender;

    @SerializedName("name")
    private Name mName;

    @SerializedName("location")
    private Location mLocation;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("login")
    private Login mLogin;

    @SerializedName("dob")
    private Dob mDob;

    @SerializedName("registered")
    private Registered mRegistered;

    @SerializedName("phone")
    private String mPhone;

    @SerializedName("cell")
    private String mCell;

    @SerializedName("id")
    private Id mId;

    @SerializedName("picture")
    private Picture mPicture;

    @SerializedName("nat")
    private String mNat;

    public String getGender() {
        return mGender;
    }

    public Name getName() {
        return mName;
    }

    public Location getLocation() {
        return mLocation;
    }

    public String getEmail() {
        return mEmail;
    }

    public Login getLogin() {
        return mLogin;
    }

    public Dob getDob() {
        return mDob;
    }

    public Registered getRegistered() {
        return mRegistered;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getCell() {
        return mCell;
    }

    public Id getId() {
        return mId;
    }

    public Picture getPicture() {
        return mPicture;
    }

    public String getNat() {
        return mNat;
    }
}
