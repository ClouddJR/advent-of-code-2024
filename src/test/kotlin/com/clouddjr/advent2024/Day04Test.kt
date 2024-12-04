package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
class Day04Test {
    private val input = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart1()

            assertEquals(18, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart1()

            assertEquals(2560, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart2()

            assertEquals(9, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart2()

            assertEquals(1910, answer)
        }
    }
}