package com.dmitriy1morozov.sample.library.model.crash

data class Log(
    val appLaunchTimestamp: String,
    val device: Device,
    val exception: Exception,
    val fatal: Boolean,
    val id: String,
    val processId: String,
    val processName: String,
    val timestamp: String,
    val type: String,
    val userId: String
)