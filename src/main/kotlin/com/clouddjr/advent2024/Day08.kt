package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day08(private val input: List<String>) {
    private val antennas = input.flatMapIndexed { y, line ->
        line.mapIndexedNotNull { x, char ->
            if (char == '.') null else char to Point2D(y, x)
        }
    }.groupBy({ it.first }, { it.second }).values

    fun solvePart1() = countAntinodes { a, b ->
        val diff = a - b
        listOf(a + diff, b - diff).filter { it.isOnGrid() }
    }

    fun solvePart2() = countAntinodes { a, b ->
        val diff = a - b
        val aSeq = generateSequence(a) { it + diff }.takeWhile { it.isOnGrid() }
        val bSeq = generateSequence(b) { it - diff }.takeWhile { it.isOnGrid() }
        aSeq.toList() + bSeq
    }

    private fun countAntinodes(generateAntinodes: (Point2D, Point2D) -> List<Point2D>) =
        antennas.flatMap { locations ->
            locations.flatMapIndexed { i, a ->
                locations.drop(i + 1).flatMap { b ->
                    generateAntinodes(a, b)
                }
            }
        }.toSet().size

    private fun Point2D.isOnGrid() =
        y in input.indices && x in input[y].indices
}