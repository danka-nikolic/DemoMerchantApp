package com.wolkabout.demomerchantapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolkabout.demomerchantapp.api.issueLocalTokens.IssueLocalTokensRepository
import com.wolkabout.demomerchantapp.model.Result
import com.wolkabout.demomerchantapp.model.issueLocalTokens.IssueLocalTokensResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class IssueLocalTokensViewModel @Inject constructor(private val issueLocalTokensRepository: IssueLocalTokensRepository) : ViewModel(){

    val TAG: String = IssueLocalTokensViewModel::class.java.simpleName
    private val issueLocalTokensLiveData: MutableLiveData<Result<IssueLocalTokensResponse>?> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun issueLocalTokens(email: String, amount: Int) {
        issueLocalTokensLiveData.postValue(Result.Loading())
        val disposable = issueLocalTokensRepository.issueLocalTokens(email, amount)
            .subscribe(
                { response ->
                    Log.d(TAG, "ISSUE LOCAL TOKENS SUCCESS -> RESPONSE: $response")
                    issueLocalTokensLiveData.postValue(Result.Success(response))
                },
                { error ->
                    val message = error.message ?: "UNKNOWN_ERROR"
                    Log.e(TAG,"ISSUE LOCAL TOKENS -> ERROR MESSAGE $message")
                    issueLocalTokensLiveData.postValue(Result.Error(message))
                }
            )

        compositeDisposable.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}