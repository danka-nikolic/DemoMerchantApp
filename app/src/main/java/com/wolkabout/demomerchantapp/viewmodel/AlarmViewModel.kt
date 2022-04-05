package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.alarms.AlarmRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.alarms.AlarmResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(private val alarmRepository: AlarmRepository) : ViewModel(){

    private val TAG: String = AlarmViewModel::class.java.simpleName
    val alarmLiveData: MutableLiveData<Result<List<AlarmResponse>>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAlarms() {
        alarmLiveData.postValue(Result.Loading())
        val disposable = alarmRepository.getAlarms()
            .subscribe(
                { response ->
                    Log.d(TAG, "AlARM DATA: $response")
                    alarmLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"ALARM ERROR -> ERROR MESSAGE $message")
                    alarmLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}