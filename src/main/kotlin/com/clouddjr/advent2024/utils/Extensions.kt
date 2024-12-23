package com.clouddjr.advent2024.utils

fun <T> List<T>.combinations(k: Int): List<List<T>> {
    if (k == 0) return listOf(emptyList())
    if (isEmpty()) return emptyList()

    val head = first()
    val tail = drop(1)

    val withHead = tail.combinations(k - 1).map { it + head }
    val withoutHead = tail.combinations(k)
    return withHead + withoutHead
}