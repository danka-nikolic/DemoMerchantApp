package com.wolkabout.demomerchantapp.api.issueLocalTokens

import com.wolkabout.demomerchantapp.model.issueLocalTokens.IssueLocalTokensRequest
import com.wolkabout.demomerchantapp.model.issueLocalTokens.IssueLocalTokensResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class IssueLocalTokensRepository @Inject internal constructor(private val issueLocalTokensApi: IssueLocalTokensApi){

    fun issueLocalTokens(email: String, amount: Int): Single<IssueLocalTokensResponse> {
        val issueLocalTokensRequest = IssueLocalTokensRequest(email, amount)
        return issueLocalTokensApi.issueLocalTokens(issueLocalTokensRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(10, TimeUnit.SECONDS)
    }
}