package com.wolkabout.demomerchantapp.model.devices

data class Feed(
    val activationTimestamp: Long,
    val alarmHigh: String,
    val alarmHighEnabled: Boolean,
    val alarmLow: String,
    val alarmLowEnabled: Boolean,
    val alarmState: String,
    val currentValue: String,
    val enabled: Boolean,
    val id: Int,
    val lastUpdate: Long,
    val readingType: String,
    val reference: String,
    val trend: String,
    val visible: Boolean
)