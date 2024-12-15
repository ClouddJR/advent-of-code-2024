package com.clouddjr.advent2024

class Day13(input: List<String>) {
    private val claws = input.chunked(4) { Claw.from(it) }

    fun solvePart1() = claws.sumOf { it.tokens() }

    fun solvePart2() =
        claws.map {
            it.copy(
                x = it.x + 10_000_000_000_000,
                y = it.y + 10_000_000_000_000,
            )
        }.sumOf { it.tokens() }

    private data class Claw(val ax: Int, val ay: Int, val bx: Int, val by: Int, val x: Long, val y: Long) {
        fun tokens(): Long {
            val a = (x * by - y * bx) / (ax * by - ay * bx)
            val b = (x - ax * a) / bx
            return if (a * ax + b * bx == x && a * ay + b * by == y) 3 * a + b else 0
        }

        companion object {
            fun from(lines: List<String>) =
                Claw(
                    ax = lines[0].substringAfter("X+").substringBefore(",").toInt(),
                    ay = lines[0].substringAfter("Y+").toInt(),
                    bx = lines[1].substringAfter("X+").substringBefore(",").toInt(),
                    by = lines[1].substringAfter("Y+").toInt(),
                    x = lines[2].substringAfter("X=").substringBefore(",").toLong(),
                    y = lines[2].substringAfter("Y=").toLong(),
                )
        }
    }
}