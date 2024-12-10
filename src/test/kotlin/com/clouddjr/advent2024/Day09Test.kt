package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {
    private val input = """
        2333133121414131402
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart1()

            assertEquals(1928, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsText("day09.txt")).solvePart1()

            assertEquals(6_430_446_922_192, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart2()

            assertEquals(2858, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsText("day09.txt")).solvePart2()

            assertEquals(6_460_170_593_016, answer)
        }
    }
}