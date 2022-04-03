package com.wolkabout.demomerchantapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.LoginRepository
import com.wolkabout.demomerchantapp.api.ProductRepository
import com.wolkabout.demomerchantapp.model.LoginResponse
import com.wolkabout.demomerchantapp.model.Page
import com.wolkabout.demomerchantapp.model.Product
import com.wolkabout.demomerchantapp.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository, private val loginRepository: LoginRepository) : ViewModel() {

    val productListLiveData: MutableLiveData<Result<Page<Product>>?> = MutableLiveData()
    val loginLiveData: MutableLiveData<Result<LoginResponse>?> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getProductPage(page: Int, size: Int = 20) {
        productListLiveData.postValue(Result.Loading())
        val disposable = productRepository.getProductPage(page, size)
            .subscribe(
                { response ->
                    productListLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    productListLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    fun getLoginData(username: String, password: String) {
        loginLiveData.postValue(Result.Loading())
        val disposable = loginRepository.login(username, password)
            .subscribe(
                { response ->
                    Log.d("### LOGIN SUCCESS", "### LOGIN DATA: $response")
                    loginLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e("#### LOGIN ERROR"," ### ERROR MESSAGE $message")
                    loginLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}