package com.dmitriy1morozov.sample.library.model.customcrash

data class InnerException(
    val frames: List<Frame>,
    val message: String,
    val type: String
)