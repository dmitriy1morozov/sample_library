package com.dmitriy1morozov.sample.library.model.customcrash

data class Log(
    val appLaunchTimestamp: String,
    val architecture: String,
    val device: Device,
    val errorThreadId: Int,
    val errorThreadName: String,
    val exception: Exception,
    val fatal: Boolean,
    val id: String,
    val processId: Int,
    val processName: String,
    val sid: String,
    val threads: List<Thread>,
    val timestamp: String,
    val type: String,
    val userId: String
)