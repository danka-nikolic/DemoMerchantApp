package com.wolkabout.demomerchantapp.model.devices

data class Point(
    val actuators: List<Actuator>,
    val feeds: List<Feed>,
    val id: Int,
    val label: String,
    val name: String,
    val pointType: String,
    val points: List<PointX>
)