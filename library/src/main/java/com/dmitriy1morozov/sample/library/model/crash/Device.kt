package com.dmitriy1morozov.sample.library.model.crash

data class Device(
    val appBuild: String,
    val appNamespace: String,
    val appVersion: String,
    val locale: String,
    val model: String,
    val osName: String,
    val osVersion: String,
    val sdkName: String,
    val sdkVersion: String
)