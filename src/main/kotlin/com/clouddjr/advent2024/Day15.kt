package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day15(input: String) {
    private val warehouse = input.substringBefore("\n\n").lines().map { it.toCharArray() }

    private val moves = input.substringAfter("\n\n").lines().flatMap { row -> row.map { it.toDir() } }

    fun solvePart1() =
        warehouse
            .performMoves()
            .findAll('O')
            .sumOf { it.gps() }

    fun solvePart2() =
        warehouse.scaledUp()
            .performMoves()
            .findAll('[')
            .sumOf { it.gps() }

    private fun List<CharArray>.performMoves(): List<CharArray> {
        val start = findAll('@').single()

        var current = start
        moves.forEach { dir ->
            val next = current + dir
            when (this[next]) {
                '[', 'O', ']' ->
                    pointsToMove(next, dir)
                        .also { if (it.isNotEmpty()) current = next }
                        .forEach { point ->
                            this[point + dir] = this[point]
                            this[point] = '.'
                        }
                !in "#" -> current = next
            }
        }

        return this
    }

    private fun List<CharArray>.pointsToMove(
        from: Point2D,
        dir: Point2D
    ): List<Point2D> {
        val queue = ArrayDeque(listOf(from))
        val seen = mutableSetOf<Point2D>()
        val toMove = mutableListOf<Point2D>()

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current in seen) continue
            seen += current
            toMove += current

            if (dir == Point2D.UP || dir == Point2D.DOWN) {
                when (this[current]) {
                    '[' -> queue.add(current + Point2D.RIGHT)
                    ']' -> queue.add(current + Point2D.LEFT)
                }
            }

            val next = current + dir
            when (this[next]) {
                '[', 'O', ']' -> queue.add(next)
                '#' -> return emptyList()
            }
        }

        return toMove.reversed()
    }

    private fun List<CharArray>.scaledUp() =
        map { row ->
            row.joinToString("") { char ->
                when (char) {
                    '#' -> "##"
                    'O' -> "[]"
                    '.' -> ".."
                    '@' -> "@."
                    else -> error("Invalid char: $this")
                }
            }.toCharArray()
        }

    private fun List<CharArray>.findAll(char: Char) =
        flatMapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c == char) Point2D(x, y) else null
            }
        }.filterNotNull()

    private operator fun List<CharArray>.get(point: Point2D) =
        this[point.y][point.x]

    private operator fun List<CharArray>.set(point: Point2D, char: Char) {
        this[point.y][point.x] = char
    }

    private fun Point2D.gps() =
        100 * y + x

    private fun Char.toDir() =
        when (this) {
            '^' -> Point2D.UP
            '>' -> Point2D.RIGHT
            'v' -> Point2D.DOWN
            '<' -> Point2D.LEFT
            else -> error("Invalid direction: $this")
        }
}