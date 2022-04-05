package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.reports.ReportRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.reports.ReportResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(private val reportRepository: ReportRepository) : ViewModel(){

    private val TAG: String = ReportViewModel::class.java.simpleName
    val reportLiveData: MutableLiveData<Result<ReportResponse>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getReports(since: Long, to: Long) {
        reportLiveData.postValue(Result.Loading())
        val disposable = reportRepository.getReports(since, to)
            .subscribe(
                { response ->
                    Log.d(TAG, "REPORT DATA: $response")
                    reportLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"REPORT ERROR -> ERROR MESSAGE $message")
                    reportLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}