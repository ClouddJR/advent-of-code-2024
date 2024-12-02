package com.clouddjr.advent2024

class Day02(input: List<String>) {
    private val reports = input.map { report -> report.split(" ").map { it.toInt() } }

    fun solvePart1() = reports.count { isSafe(it) }

    fun solvePart2() = reports.count { isSafeWithCorrection(it) }

    private fun isSafe(report: List<Int>): Boolean {
        val diffs = report.zipWithNext { a, b -> b - a }
        return diffs.all { it in 1..3 } || diffs.all { it in -3..-1 }
    }

    private fun isSafeWithCorrection(report: List<Int>): Boolean {
        return report.indices
            .map { toRemove -> report.filterIndexed { i, _ -> i != toRemove } }
            .any { isSafe(it) }
    }
}