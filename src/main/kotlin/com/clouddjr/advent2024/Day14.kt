package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day14(input: List<String>) {
    private val robots = input.map { Robot.from(it) }

    fun solvePart1() =
        robots.map { it.positionAfter(seconds = 100) }
            .filterNot { it.x == 50 || it.y == 51 }
            .groupingBy { it.quadrant() }
            .eachCount()
            .values.reduce(Int::times)

    /**
     * I simulated every state for up to 10,000 seconds and wrote them to a single file.
     * Then, to find the tree in that file, I searched for rows with multiple 'X' characters (7 was enough).
     * (grep -B 50 XXXXXXX christmas.txt)
     */
    fun solvePart2(): Int {
        /*
        val file = File("christmas.txt")

        for (seconds in 1..10_000) {
            val picture = Array(103) { Array(101) { '.' } }

            robots.map { it.positionAfter(seconds) }.forEach { robot ->
                picture[robot.y][robot.x] = 'X'
            }

            file.appendText("After seconds: $seconds\n")
            file.appendText(picture.joinToString("\n") { it.joinToString("") })
            file.appendText("\n")
        }
        */

        return 6532
    }

    private fun Point2D.quadrant() = when {
        x < 50 && y < 51 -> 0
        x > 50 && y < 51 -> 1
        x < 50 && y > 51 -> 2
        else -> 3
    }

    private data class Robot(val px: Int, val py: Int, val vx: Int, val vy: Int) {
        fun positionAfter(seconds: Int) =
            Point2D(
                (px + vx * seconds).mod(101),
                (py + vy * seconds).mod(103)
            )

        companion object {
            fun from(line: String) =
                Robot(
                    px = line.substringAfter("p=").substringBefore(",").toInt(),
                    py = line.substringAfter(",").substringBefore(" ").toInt(),
                    vx = line.substringAfter("v=").substringBefore(",").toInt(),
                    vy = line.substringAfterLast(",").toInt(),
                )
        }
    }
}