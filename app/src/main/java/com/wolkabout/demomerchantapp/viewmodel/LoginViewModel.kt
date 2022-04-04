package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.login.LoginRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.login.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel(){

    val TAG: String = LoginViewModel::class.java.simpleName
    private val loginLiveData: MutableLiveData<Result<LoginResponse>?> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getLoginData(username: String, password: String) {
        loginLiveData.postValue(Result.Loading())
        val disposable = loginRepository.login(username, password)
            .subscribe(
                { response ->
                    Log.d(TAG, "LOGIN SUCCESS -> LOGIN DATA: $response")
                    loginLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"LOGIN ERROR -> ERROR MESSAGE $message")
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