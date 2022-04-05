package com.wolkabout.demomerchantapp.api.devices

import com.wolkabout.demomerchantapp.model.devices.DeviceResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface DeviceApi {

    @Headers("Accept: text/plain, application/json")
    @GET("r2wDevices")
    fun getDevices(): Single<List<DeviceResponse>>

}