package com.dmitriy1morozov.sample.library.model.crash

data class Frame(
    val className: String,
    val fileName: String,
    val lineNumber: Int,
    val methodName: String
)