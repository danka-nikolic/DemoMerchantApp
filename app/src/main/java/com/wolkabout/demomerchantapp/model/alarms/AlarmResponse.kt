package com.wolkabout.demomerchantapp.model.alarms

data class AlarmResponse (
    val id: Int,
    val device: String,
    val content: String,
    val timestamp: Any,
    val collapseKey: String,
    val details: String
)
