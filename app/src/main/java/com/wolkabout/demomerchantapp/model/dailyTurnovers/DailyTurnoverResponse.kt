package com.wolkabout.demomerchantapp.model.dailyTurnovers

data class DailyTurnoverResponse (
    var currency: String,
    var facilities: ArrayList<Facility>,
    var total: Double
)