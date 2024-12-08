package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
class Day08Test {
    private val input = """
        ............
        ........0...
        .....0......
        .......0....
        ....0.......
        ......A.....
        ............
        ............
        ........A...
        .........A..
        ............
        ............
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart1()

            assertEquals(14, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            assertEquals(320, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart2()

            assertEquals(34, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            assertEquals(1157, answer)
        }
    }
}