package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 6")
class Day06Test {
    private val input = """
        ....#.....
        .........#
        ..........
        ..#.......
        .......#..
        ..........
        .#..^.....
        ........#.
        #.........
        ......#...
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart1()

            assertEquals(41, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()

            assertEquals(4964, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart2()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()

            assertEquals(1740, answer)
        }
    }
}