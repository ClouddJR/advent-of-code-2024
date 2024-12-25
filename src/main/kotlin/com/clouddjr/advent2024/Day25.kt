package com.clouddjr.advent2024

class Day25(input: String) {
    private val schematics = input.split("\n\n").map { it.lines() }

    private val locks = schematics.filter { "#" in it.first() }.map { it.parse() }

    private val keys = schematics.filter { "#" in it.last() }.map { it.parse() }

    fun solvePart1() =
        keys.sumOf { key ->
            locks.count { lock ->
                (key zip lock).all { (k, l) -> k + l <= 5 }
            }
        }

    private fun List<String>.parse() =
        first().indices.map { col ->
            map { it[col] }.count { it == '#' } - 1
        }
}