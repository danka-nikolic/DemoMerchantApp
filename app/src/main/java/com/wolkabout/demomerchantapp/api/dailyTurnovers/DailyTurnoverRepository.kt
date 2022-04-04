package com.wolkabout.demomerchantapp.api.dailyTurnovers

import com.wolkabout.demomerchantapp.model.dailyTurnovers.DailyTurnoverResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DailyTurnoverRepository @Inject internal constructor(private val dailyTurnoverApi: DailyTurnoverApi){

    fun getDailyTurnoverList(): Single<List<DailyTurnoverResponse>> {
        return dailyTurnoverApi.getDailyTurnoverList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }
}