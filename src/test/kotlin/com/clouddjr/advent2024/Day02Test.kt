package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {
    private val input = """
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        8 6 4 4 1
        1 3 6 7 9
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart1()

            assertEquals(2, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart1()

            assertEquals(559, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart2()

            assertEquals(4, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart2()

            assertEquals(601, answer)
        }
    }
}