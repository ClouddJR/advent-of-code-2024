package com.clouddjr.advent2024

class Day19(input: List<String>) {
    private val towels = input.first().split(", ")

    private val designs = input.drop(2)

    fun solvePart1() = designs.count { it.countOptions() > 0 }

    fun solvePart2() = designs.sumOf { it.countOptions() }

    private fun String.countOptions(): Long {
        val cache = mutableMapOf<Int, Long>()

        fun options(i: Int): Long =
            when {
                i == length -> 1
                else -> cache.getOrPut(i) {
                    towels.sumOf { towel ->
                        if (substring(i).startsWith(towel)) options(i + towel.length) else 0
                    }
                }
            }

        return options(0)
    }
}