package com.wolkabout.demomerchantapp.api

import com.wolkabout.demomerchantapp.model.Page
import com.wolkabout.demomerchantapp.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("/products")
    fun getProductPage(@Query("page") page: Int, @Query("size") size: Int = 20): Single<Page<Product>>

}