package com.dmitriy1morozov.sample.library.model.customcrash

data class Thread(
    val frames: List<Frame>,
    val id: Int,
    val name: String
)