package com.wolkabout.demomerchantapp.model

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val roles: ArrayList<String>,
    val user: User,
    val countryIsoCode: String,
    val receiveEmailNotificationsSelected: Boolean
)