package com.clouddjr.advent2024

class Day04(private val input: List<String>) {
    fun solvePart1() =
        input.indices.sumOf { r ->
            input[r].indices.sumOf { c ->
                if (input[r][c] == 'X') {
                    DIRS.count { (dr, dc) ->
                        (1..3).map { n -> input.safeAt(r + n * dr, c + n * dc) } == "MAS".toList()
                    }
                } else 0
            }
        }

    fun solvePart2() =
        (1..<input.size - 1).sumOf { r ->
            (1..<input[r].length - 1).count { c ->
                if (input[r][c] == 'A') {
                    val left = "${input[r - 1][c - 1]}${input[r + 1][c + 1]}"
                    val right = "${input[r + 1][c - 1]}${input[r - 1][c + 1]}"
                    (left == "MS" || left == "SM") && (right == "MS" || right == "SM")
                } else false
            }
        }

    private fun List<String>.safeAt(row: Int, col: Int) =
        if (row in indices && col in this[row].indices) this[row][col] else ' '

    private companion object {
        val DIRS = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
    }
}