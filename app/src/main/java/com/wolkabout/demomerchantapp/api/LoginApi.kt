package com.wolkabout.demomerchantapp.api

import com.wolkabout.demomerchantapp.model.LoginRequest
import com.wolkabout.demomerchantapp.model.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {

    @Headers("Accept: application/vnd.authentication.v2+json")
    @POST("emailSignIn")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

}