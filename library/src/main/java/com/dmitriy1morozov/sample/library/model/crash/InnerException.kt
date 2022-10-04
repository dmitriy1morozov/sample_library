package com.dmitriy1morozov.sample.library.model.crash

data class InnerException(
    val frames: List<Frame>,
    val type: String
)