package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day06(input: List<String>) {
    private val grid = input.flatMapIndexed { y, row ->
        row.mapIndexed { x, char -> Point2D(x, y) to char }
    }.toMap().withDefault { ' ' }

    private val start = grid.entries.first { it.value == '^' }.key

    fun solvePart1() =
        traverse().path.size

    fun solvePart2() =
        traverse().path
            .filterNot { it == start }
            .count { obstacle -> traverse(newObstacle = obstacle).hasLoop }

    private fun traverse(newObstacle: Point2D? = null): TraverseResult {
        var current = start
        var dir = Point2D.UP

        val seen = mutableSetOf<Pair<Point2D, Point2D>>()

        while (current in grid && (current to dir) !in seen) {
            seen.add(current to dir)

            val next = current + dir
            if (grid.getValue(next) == '#' || next == newObstacle) {
                dir = dir.turnedRight()
            } else {
                current = next
            }
        }

        return TraverseResult(
            path = seen.map { it.first }.toSet(),
            hasLoop = current to dir in seen
        )
    }

    private data class TraverseResult(val path: Set<Point2D>, val hasLoop: Boolean)
}