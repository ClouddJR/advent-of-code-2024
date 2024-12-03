package com.clouddjr.advent2024

class Day03(private val input: String) {
    private val pattern = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

    fun solvePart1() = sumProductsIn(input)

    fun solvePart2() =
        input.split("do()")
            .map { it.substringBefore("don't()") }
            .sumOf { sumProductsIn(it) }

    private fun sumProductsIn(section: String): Int {
        return pattern.findAll(section).sumOf { match ->
            val (x, y) = match.destructured
            x.toInt() * y.toInt()
        }
    }
}