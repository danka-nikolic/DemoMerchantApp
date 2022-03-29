package com.wolkabout.demomerchantapp.api

import com.wolkabout.demomerchantapp.model.Page
import com.wolkabout.demomerchantapp.model.Product
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ProductRepository @Inject internal constructor(private val productApi: ProductApi) {

    fun getProductPage(page: Int, size: Int = 20): Single<Page<Product>> {
        return productApi.getProductPage(page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }

}