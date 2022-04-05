package com.wolkabout.demomerchantapp.model.issueLocalTokens

data class IssueLocalTokensRequest(
    val email: String,
    val amount: Int
)