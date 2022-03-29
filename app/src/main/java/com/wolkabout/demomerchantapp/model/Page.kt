package com.wolkabout.demomerchantapp.model

data class Page<T>(
    val list: List<T>,
    val page: Int,
    val size: Int,
    val isLast: Boolean
)
