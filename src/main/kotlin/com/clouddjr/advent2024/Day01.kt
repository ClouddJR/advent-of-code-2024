package com.clouddjr.advent2024

import kotlin.math.abs

class Day01(input: List<String>) {
    private val left = input.map { it.substringBefore(" ").toInt() }.sorted()
    private val right = input.map { it.substringAfterLast(" ").toInt() }.sorted()

    private val rightCounts = right.groupingBy { it }.eachCount()

    fun solvePart1() = (left zip right).sumOf { (l, r) -> abs(l - r) }

    fun solvePart2() = left.sumOf { it * rightCounts.getOrDefault(it, 0) }
}