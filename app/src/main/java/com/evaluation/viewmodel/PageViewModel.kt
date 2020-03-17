package com.evaluation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evaluation.model.result.Result

/**
 * @author Vladyslav Havrylenko
 * @since 16.03.2020
 */
class PageViewModel : ViewModel() {

    private val mLiveData = MutableLiveData<Result>()

    fun setResult(results: Result) {
        mLiveData.value = results
    }

    val result: LiveData<Result>
        get() = mLiveData
}