package com.wolkabout.demomerchantapp.api.alarms

import com.wolkabout.demomerchantapp.model.alarms.AlarmResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface AlarmApi {

    @Headers("Accept: text/plain, application/json")
    @GET("messages/alarms")
    fun getAlarms(): Single<List<AlarmResponse>>
}