package com.wolkabout.demomerchantapp.api.login

import com.wolkabout.demomerchantapp.model.login.LoginRequest
import com.wolkabout.demomerchantapp.model.login.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {

    @Headers("Accept: application/vnd.authentication.v2+json")
    @POST("emailSignIn")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

}