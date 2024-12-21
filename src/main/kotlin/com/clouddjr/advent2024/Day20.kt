package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day20(val input: List<String>) {
    private val grid = input.flatMapIndexed { y, row ->
        row.mapIndexedNotNull { x, c ->
            if (c != '#') Point2D(x, y) to c else null
        }
    }.toMap()

    private val start = grid.entries.first { it.value == 'S' }.key

    fun solvePart1() = countCheats(picoseconds = 2)

    fun solvePart2() = countCheats(picoseconds = 20)

    private fun countCheats(picoseconds: Int): Int {
        val path = mutableListOf(start)
        val visited = mutableSetOf(start)
        val toVisit = mutableListOf(start)

        while (toVisit.isNotEmpty()) {
            val current = toVisit.removeFirst()
            current.neighbours().forEach { n ->
                if (n in grid && n !in visited) {
                    toVisit += n
                    visited += n
                    path += n
                }
            }
        }

        return path.indices.sumOf { i ->
            (i + 100..path.lastIndex).count { j ->
                val d = path[i] distanceTo path[j]
                d <= picoseconds && j - i - d >= 100
            }
        }
    }
}