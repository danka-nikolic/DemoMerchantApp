package com.wolkabout.demomerchantapp.model.devices

data class DeviceResponseItem(
    val activationTimestamp: Long,
    val baudRate: Int,
    val certificateSerial: String,
    val connectedPoints: String,
    val deviceKey: String,
    val deviceType: String,
    val expectedNextReportTimestamp: Long,
    val hardwareVersion: Int,
    val heartbeat: Int,
    val id: Int,
    val lastReportTimestamp: Long,
    val listenerByteTimeout: Int,
    val listenerResponseTimeout: Int,
    val listenerSerialPort: String,
    val modbusType: String,
    val mqttIpAddress: String,
    val multiplier: Double,
    val plcIpAddress: String,
    val plcPort: Int,
    val point: Point,
    val remoteReversePort: Int,
    val state: String,
    val tokenChannel: Int,
    val tokenValue: Double
)