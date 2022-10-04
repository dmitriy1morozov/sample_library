package com.dmitriy1morozov.sample.library.model.customcrash

data class Device(
    val appBuild: String,
    val appNamespace: String,
    val appVersion: String,
    val carrierCountry: String,
    val locale: String,
    val model: String,
    val oemName: String,
    val osApiLevel: Int,
    val osBuild: String,
    val osName: String,
    val osVersion: String,
    val screenSize: String,
    val sdkName: String,
    val sdkVersion: String,
    val timeZoneOffset: Int
)