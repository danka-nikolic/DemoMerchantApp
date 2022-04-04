package com.wolkabout.demomerchantapp.api.dailyTurnovers

import com.wolkabout.demomerchantapp.model.dailyTurnovers.DailyTurnoverResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface DailyTurnoverApi {

    @Headers("Accept: application/vnd.dailyturnover.v2+json")
    @GET("periodicReports/dailyTurnover")
    fun getDailyTurnover(): Single<DailyTurnoverResponse>
}