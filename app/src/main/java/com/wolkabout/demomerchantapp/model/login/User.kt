package com.wolkabout.demomerchantapp.model.login

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    var originApp: String
)