package com.wolkabout.demomerchantapp.model.dailyTurnovers

data class DailyTurnoverResponse (
    val currency: String,
    val facilities: ArrayList<Facility>,
    val total: Double
)