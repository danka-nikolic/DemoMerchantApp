package com.wolkabout.demomerchantapp.model.devices

data class PointX(
    val actuators: List<ActuatorX>,
    val feeds: List<FeedX>,
    val id: Int,
    val label: String,
    val name: String,
    val pointType: String,
    val points: List<Any>
)