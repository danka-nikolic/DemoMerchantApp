package com.wolkabout.demomerchantapp.api.issueLocalTokens

import com.wolkabout.demomerchantapp.model.issueLocalTokens.IssueLocalTokensRequest
import com.wolkabout.demomerchantapp.model.issueLocalTokens.IssueLocalTokensResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IssueLocalTokensApi {

    @Headers("Accept: text/plain, application/json")
    @POST("vouchers/directTopUp")
    fun issueLocalTokens(@Body issueLocalTokensRequest: IssueLocalTokensRequest): Single<IssueLocalTokensResponse>
}