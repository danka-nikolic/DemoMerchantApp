package com.wolkabout.demomerchantapp.model.devices

data class Actuator(
    val actuatorRange: String,
    val actuatorType: String,
    val id: Int,
    val reference: String,
    val state: String,
    val value: String
)