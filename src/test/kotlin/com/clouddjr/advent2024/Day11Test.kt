package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
class Day11Test {
    private val input = """
        125 17
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart1()

            assertEquals(55_312, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsText("day11.txt")).solvePart1()

            assertEquals(182_081, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day11(input).solvePart2()

            assertEquals(65_601_038_650_482, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsText("day11.txt")).solvePart2()

            assertEquals(216_318_908_621_637, answer)
        }
    }
}