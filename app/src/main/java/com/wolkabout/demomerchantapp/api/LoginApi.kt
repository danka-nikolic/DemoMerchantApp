package com.wolkabout.demomerchantapp.api

import com.wolkabout.demomerchantapp.model.LoginRequest
import com.wolkabout.demomerchantapp.model.LoginResponse
import com.wolkabout.demomerchantapp.model.Page
import com.wolkabout.demomerchantapp.model.Product
import io.reactivex.Single
import retrofit2.http.*

interface LoginApi {

    @Headers("Accept: application/vnd.authentication.v2+json")
    @POST("emailSignIn")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

}