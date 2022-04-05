package com.wolkabout.demomerchantapp.api.devices

import com.wolkabout.demomerchantapp.model.devices.DeviceResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DeviceRepository @Inject internal constructor(private val deviceApi: DeviceApi){

    fun getDevices(): Single<List<DeviceResponse>> {
        return deviceApi.getDevices()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }
}