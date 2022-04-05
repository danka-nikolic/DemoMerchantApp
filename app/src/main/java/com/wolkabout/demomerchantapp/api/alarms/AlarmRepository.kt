package com.wolkabout.demomerchantapp.api.alarms

import com.wolkabout.demomerchantapp.model.alarms.AlarmResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AlarmRepository @Inject internal constructor(private val alarmApi: AlarmApi){

    fun getAlarms(): Single<List<AlarmResponse>> {
        return alarmApi.getAlarms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }
}
