package com.clouddjr.advent2024

class Day11(input: String) {
    private val stones =
        input.split(" ").map { it.toLong() }.groupingBy { it }.eachCount().mapValues { it.value.toLong() }

    fun solvePart1() = countStones(blinks = 25)

    fun solvePart2() = countStones(blinks = 75)

    private fun countStones(blinks: Int): Long =
        (0..<blinks).fold(stones) { current, _ ->
            buildMap {
                current.entries.forEach { (key, count) ->
                    if (key == 0L) {
                        merge(1, count, Long::plus)
                    } else {
                        val str = "$key"
                        if (str.length % 2 == 0) {
                            merge(str.take(str.length / 2).toLong(), count, Long::plus)
                            merge(str.takeLast(str.length / 2).toLong(), count, Long::plus)
                        } else {
                            merge(key * 2024, count, Long::plus)
                        }
                    }
                }
            }
        }.values.sum()
}