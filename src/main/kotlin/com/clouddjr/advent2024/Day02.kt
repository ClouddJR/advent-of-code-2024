package com.clouddjr.advent2024

class Day02(input: List<String>) {
    private val reports = input.map { report -> report.split(" ").map { it.toInt() } }

    fun solvePart1() = reports.toDiffs().count { diff -> diff.isSafe() }

    fun solvePart2() = reports.count { original ->
        original.indices.map { toRemove -> original.filterIndexed { i, _ -> i != toRemove } }
            .toDiffs().any { diff -> diff.isSafe() }
    }

    private fun List<List<Int>>.toDiffs() = map { it.zipWithNext().map { (a, b) -> b - a } }

    private fun List<Int>.isSafe() = all { it in 1..3 } || all { it in -3..-1 }
}