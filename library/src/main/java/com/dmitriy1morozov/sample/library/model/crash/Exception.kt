package com.dmitriy1morozov.sample.library.model.crash

data class Exception(
    val frames: List<Frame>,
    val innerExceptions: List<InnerException>,
    val type: String
)