package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.dailyTurnovers.DailyTurnoverRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.dailyTurnovers.DailyTurnoverResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class DailyTurnoverViewModel @Inject constructor(private val dailyTurnoverRepository: DailyTurnoverRepository) : ViewModel(){

    private val TAG: String = DailyTurnoverViewModel::class.java.simpleName
    val dailyTurnoverLiveData: MutableLiveData<Result<DailyTurnoverResponse>?> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getDailyTurnoverData() {
        dailyTurnoverLiveData.postValue(Result.Loading())
        val disposable = dailyTurnoverRepository.getDailyTurnover()
            .subscribe(
                { response ->
                    Log.d(TAG, "DAILY TURNOVER DATA: $response")
                    dailyTurnoverLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"DAILY TURNOVER ERROR -> ERROR MESSAGE $message")
                    dailyTurnoverLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}