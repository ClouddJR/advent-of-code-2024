package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {
    private val input = """
        029A
        980A
        179A
        456A
        379A
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day21(input).solvePart1()

            assertEquals(126_384, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart1()

            assertEquals(179_444, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day21(input).solvePart2()

            assertEquals(154_115_708_116_294, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart2()

            assertEquals(223_285_811_665_866, answer)
        }
    }
}