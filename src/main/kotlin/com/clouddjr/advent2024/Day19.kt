package com.clouddjr.advent2024

class Day19(input: List<String>) {
    private val towels = input.first().split(", ")

    private val designs = input.drop(2)

    fun solvePart1() = designs.count { it.countOptions() > 0 }

    fun solvePart2() = designs.sumOf { it.countOptions() }

    private fun String.countOptions(): Long {
        val options = LongArray(length + 1).apply { this[length] = 1 }

        indices.reversed().forEach { i ->
            towels.forEach { towel ->
                if (substring(i).startsWith(towel)) {
                    options[i] += options[i + towel.length]
                }
            }
        }

        return options.first()
    }
}