package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day10Test {
    private val input = """
        89010123
        78121874
        87430965
        96549874
        45678903
        32019012
        01329801
        10456732
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day10(input).solvePart1()

            assertEquals(36, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()

            assertEquals(776, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day10(input).solvePart2()

            assertEquals(81, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()

            assertEquals(1657, answer)
        }
    }
}