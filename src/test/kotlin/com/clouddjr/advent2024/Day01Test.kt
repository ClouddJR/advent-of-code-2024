package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {
    private val input = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart1()

            assertEquals(11, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart1()

            assertEquals(2_344_935, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart2()

            assertEquals(31, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart2()

            assertEquals(27_647_262, answer)
        }
    }
}