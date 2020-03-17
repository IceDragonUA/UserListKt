package com.evaluation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.evaluation.model.result.Result;

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
public class PageViewModel extends ViewModel {

    private MutableLiveData<Result> mLiveData = new MutableLiveData<>();

    public void setResult(Result results) {
        mLiveData.setValue(results);
    }

    public LiveData<Result> getResult() {
        return mLiveData;
    }


}
