package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D
import java.util.PriorityQueue

class Day16(input: List<String>) {
    private val maze = input.map { it.toCharArray() }

    private val start = maze.flatMapIndexed { y, row ->
        row.mapIndexed { x, c ->
            if (c == 'S') Point2D(x, y) else null
        }
    }.filterNotNull().single()

    fun solvePart1() = traverse().lowestScore

    fun solvePart2() = traverse().seats

    private fun traverse(): Result {
        val paths = mutableSetOf<Point2D>()
        var lowest = Int.MAX_VALUE
        val scores = mutableMapOf<Pair<Point2D, Point2D>, Int>().withDefault { Int.MAX_VALUE }

        val toVisit = PriorityQueue<State>(compareBy { it.score })
        toVisit.add(State(start, Point2D.RIGHT, 0))

        while (toVisit.isNotEmpty()) {
            val (pos, dir, score, path) = toVisit.poll()

            if (score > scores.getValue(pos to dir)) continue
            scores[pos to dir] = score

            if (maze[pos] == 'E') {
                if (score > lowest) break
                paths.addAll(path)
                lowest = score
            }

            for ((d, s) in listOf(dir to 1, dir.turnedRight() to 1001, dir.turnedLeft() to 1001)) {
                if (maze[pos + d] == '#') continue
                toVisit.add(State(pos + d, d, score + s, path + pos))
            }
        }

        return Result(lowest, paths.size + 1)
    }

    private data class State(
        val position: Point2D,
        val dir: Point2D,
        val score: Int,
        val path: List<Point2D> = emptyList()
    )

    private data class Result(val lowestScore: Int, val seats: Int)

    private operator fun List<CharArray>.get(point: Point2D) =
        this[point.y][point.x]
}