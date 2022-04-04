package com.wolkabout.demomerchantapp.model.dailyTurnovers

data class Facility (
    var deviceSerial: String,
    var facilityName: String,
    var online: Double,
    var cash: Double,
    var tokens: Double,
    var tokensCount: Int,
    var changer: Double,
    var lwtTokenCount: Int,
    var gwtTokenCount: Int,
    var total: Double,
)