package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.devices.DeviceRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.devices.DeviceResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class DeviceViewModel @Inject constructor(private val deviceRepository: DeviceRepository) : ViewModel(){

    private val TAG: String = DeviceViewModel::class.java.simpleName
    val deviceLiveData: MutableLiveData<Result<List<DeviceResponse>>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getDevices() {
       deviceLiveData.postValue(Result.Loading())
        val disposable = deviceRepository.getDevices()
            .subscribe(
                { response ->
                    Log.d(TAG, "DEVICE DATA: $response")
                    deviceLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"DEVICE ERROR -> ERROR MESSAGE $message")
                    deviceLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}