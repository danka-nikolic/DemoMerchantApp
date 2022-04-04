package com.wolkabout.demomerchantapp.api

import com.wolkabout.demomerchantapp.model.LoginRequest
import com.wolkabout.demomerchantapp.model.LoginResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginRepository @Inject internal constructor(private val loginApi: LoginApi) {

    fun login(username: String, password: String): Single<LoginResponse> {
        val loginRequest = LoginRequest(username, password)
        return loginApi.login(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }

}