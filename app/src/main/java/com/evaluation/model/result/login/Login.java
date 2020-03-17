package com.evaluation.model.result.login;

import com.google.gson.annotations.SerializedName;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class Login {

    @SerializedName("uuid")
    private String mUuid;

    @SerializedName("username")
    private String mUsername;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("salt")
    private String mSalt;

    @SerializedName("md5")
    private String mMd5;

    @SerializedName("sha1")
    private String mSha1;

    @SerializedName("sha256")
    private String mSha256;

    public String getUuid() {
        return mUuid;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getSalt() {
        return mSalt;
    }

    public String getMd5() {
        return mMd5;
    }

    public String getSha1() {
        return mSha1;
    }

    public String getSha256() {
        return mSha256;
    }
}
