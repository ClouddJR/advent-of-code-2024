package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day18(private val input: List<String>) {
    private val bytes =
        input
            .map { Point2D(it.substringBefore(",").toInt(), it.substringAfter(",").toInt()) }
            .withIndex()
            .associate { it.value to it.index }
            .withDefault { Int.MAX_VALUE }

    fun solvePart1() = minSteps(time = 1024)

    fun solvePart2(): String {
        var l = 1025
        var r = bytes.size

        while (l < r) {
            val time = (l + r) / 2
            if (minSteps(time) != -1) {
                l = time + 1
            } else {
                r = time
            }
        }

        return input[l]
    }

    private fun minSteps(time: Int): Int {
        val visited = mutableSetOf<Point2D>()
        val toVisit = ArrayDeque<State>().apply { add(State(Point2D(0, 0), 0)) }

        while (toVisit.isNotEmpty()) {
            val (current, score) = toVisit.removeFirst()

            if (current == Point2D(70, 70)) return score

            for (n in current.neighbours()) {
                if (n.isInBounds() && n !in visited && time < bytes.getValue(n)) {
                    visited += n
                    toVisit += State(n, score + 1)
                }
            }
        }

        return -1
    }

    private fun Point2D.isInBounds() = x in 0..70 && y in 0..70

    private data class State(val position: Point2D, val score: Int)
}