package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day10(input: List<String>) {
    private val grid = input.flatMapIndexed { y, line ->
        line.mapIndexed { x, char ->
            Point2D(x, y) to char.digitToInt()
        }
    }.toMap().withDefault { -1 }

    private val trailheads = grid.entries.filter { it.value == 0 }.map { it.key }

    fun solvePart1() = trailheads.sumOf { it.score(onlyDistinct = true) }

    fun solvePart2() = trailheads.sumOf { it.score(onlyDistinct = false) }

    private fun Point2D.score(onlyDistinct: Boolean, visited: MutableSet<Point2D> = mutableSetOf()): Int {
        if (onlyDistinct) {
            if (this in visited) return 0
            visited.add(this)
        }

        if (grid[this] == 9) return 1

        return neighbours()
            .filter { grid.getValue(it) - grid.getValue(this) == 1 }
            .sumOf { it.score(onlyDistinct, visited) }
    }
}