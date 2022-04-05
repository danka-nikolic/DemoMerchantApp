package com.wolkabout.demomerchantapp.api.reports

import com.wolkabout.demomerchantapp.model.reports.ReportResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ReportApi {

    @Headers("Accept: text/plain, application/json")
    @GET("reports/totalByDate?")
    fun getReports(@Query("since") since: Long, @Query("to") to: Long): Single<ReportResponse>

}