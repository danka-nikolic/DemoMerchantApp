package com.wolkabout.demomerchantapp.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    var originApp: String
)