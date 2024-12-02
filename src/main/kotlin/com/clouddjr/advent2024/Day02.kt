package com.clouddjr.advent2024

import kotlin.math.abs

class Day02(input: List<String>) {
    private val levels = input.map { level -> level.split(" ").map { it.toInt() } }

    fun solvePart1() = levels.toDiffs().count { diff -> diff.isSafe() }

    fun solvePart2() = levels.count { original ->
        original.indices.map { index -> original.toMutableList().also { it.removeAt(index) } }
            .toDiffs().any { diff -> diff.isSafe() }
    }

    private fun List<List<Int>>.toDiffs() = map { it.zipWithNext().map { (a, b) -> b - a } }

    private fun List<Int>.isSafe() = (all { it > 0 } || all { it < 0 }) && all { abs(it) in 1..3 }
}