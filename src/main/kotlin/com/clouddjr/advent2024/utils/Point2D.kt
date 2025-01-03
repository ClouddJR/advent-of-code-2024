package com.clouddjr.advent2024.utils

import kotlin.math.abs

data class Point2D(val x: Int, val y: Int) {
    operator fun plus(other: Point2D) =
        Point2D(x + other.x, y + other.y)

    operator fun minus(other: Point2D) =
        Point2D(x - other.x, y - other.y)

    infix fun distanceTo(other: Point2D) =
        abs(x - other.x) + abs(y - other.y)

    fun neighbours() =
        listOf(
            Point2D(x - 1, y),
            Point2D(x + 1, y),
            Point2D(x, y - 1),
            Point2D(x, y + 1),
        )

    fun turnedRight() =
        when (this) {
            UP -> RIGHT
            RIGHT -> DOWN
            DOWN -> LEFT
            LEFT -> UP
            else -> error("Invalid direction: $this")
        }

    fun turnedLeft() =
        when (this) {
            UP -> LEFT
            RIGHT -> UP
            DOWN -> RIGHT
            LEFT -> DOWN
            else -> error("Invalid direction: $this")
        }

    companion object {
        val UP = Point2D(0, -1)
        val RIGHT = Point2D(1, 0)
        val DOWN = Point2D(0, 1)
        val LEFT = Point2D(-1, 0)
    }
}