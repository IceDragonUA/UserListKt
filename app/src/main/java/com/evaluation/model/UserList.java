package com.evaluation.model;

import com.evaluation.model.info.Info;
import com.evaluation.model.result.Result;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class UserList {

    @SerializedName("results")
    private ArrayList<Result> mResultList;

    @SerializedName("info")
    private Info mInfo;

    public ArrayList<Result> getResultList() {
        return mResultList;
    }

    public Info getInfo() {
        return mInfo;
    }

}
