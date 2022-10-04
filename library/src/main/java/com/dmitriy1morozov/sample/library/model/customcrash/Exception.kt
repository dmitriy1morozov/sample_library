package com.dmitriy1morozov.sample.library.model.customcrash

data class Exception(
    val frames: List<Frame>,
    val innerExceptions: List<InnerException>,
    val message: String,
    val type: String
)