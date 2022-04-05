package com.wolkabout.demomerchantapp.api.reports

import com.wolkabout.demomerchantapp.model.reports.ReportResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ReportRepository @Inject internal constructor(private val reportApi: ReportApi){

    fun getReports(since: Long, to: Long): Single<ReportResponse> {
        return reportApi.getReports(since, to)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }

}