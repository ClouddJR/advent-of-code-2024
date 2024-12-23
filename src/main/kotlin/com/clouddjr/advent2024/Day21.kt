package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day21(private val codes: List<String>) {
    private val numeric = mapOf(
        Point2D(0, 0) to '7', Point2D(1, 0) to '8', Point2D(2, 0) to '9',
        Point2D(0, 1) to '4', Point2D(1, 1) to '5', Point2D(2, 1) to '6',
        Point2D(0, 2) to '1', Point2D(1, 2) to '2', Point2D(2, 2) to '3',
                              Point2D(1, 3) to '0', Point2D(2, 3) to 'A'
    )

    private val directional = mapOf(
                              Point2D(1, 0) to '^', Point2D(2, 0) to 'A',
        Point2D(0, 1) to '<', Point2D(1, 1) to 'v', Point2D(2, 1) to '>'
    )

    private val numericPaths = buildShortestPaths(keypad = numeric)

    private val directionalPaths = buildShortestPaths(keypad = directional)

    fun solvePart1() = solve(levels = 3)

    fun solvePart2() = solve(levels = 26)

    private fun solve(levels: Int) =
        codes.sumOf { code -> code.findCost(levels) * code.filter { it.isDigit() }.toInt() }

    private fun String.findCost(
        levels: Int,
        keypad: Map<Char, Map<Char, List<String>>> = numericPaths,
        cache: MutableMap<Pair<String, Int>, Long> = mutableMapOf()
    ): Long =
        cache.getOrPut(this to levels) {
            when (levels) {
                0 -> length.toLong()
                else -> {
                    "A$this".zipWithNext().sumOf { (from, to) ->
                        keypad.getValue(from).getValue(to).minOf { path ->
                            "${path}A".findCost(levels - 1, directionalPaths, cache)
                        }
                    }
                }
            }
        }

    private fun buildShortestPaths(keypad: Map<Point2D, Char>): Map<Char, Map<Char, List<String>>> =
        buildMap {
            for (start in keypad.keys) {
                val paths = mutableMapOf<Char, MutableList<String>>()
                paths[keypad.getValue(start)] = mutableListOf("")

                val queue = mutableListOf(start to "")
                val visited = mutableSetOf<Point2D>()

                while (queue.isNotEmpty()) {
                    val (current, path) = queue.removeFirst()
                    visited += current

                    current.neighbours().forEach {
                        if (it in keypad && it !in visited) {
                            val newPath = path + (it - current).toChar()
                            queue += it to newPath
                            paths.getOrPut(keypad.getValue(it)) { mutableListOf() } += newPath
                        }
                    }
                }

                set(keypad[start]!!, paths)
            }
        }

    private fun Point2D.toChar() =
        when (this) {
            Point2D.UP -> "^"
            Point2D.RIGHT -> ">"
            Point2D.DOWN -> "v"
            Point2D.LEFT -> "<"
            else -> error("Invalid direction: $this")
        }
}