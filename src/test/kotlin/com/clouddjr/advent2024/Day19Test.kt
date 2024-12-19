package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 19")
class Day19Test {
    private val input = """
        r, wr, b, g, bwu, rb, gb, br

        brwrr
        bggr
        gbbr
        rrbgbr
        ubwu
        bwurrg
        brgr
        bbrgwb
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day19(input).solvePart1()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsListOfString("day19.txt")).solvePart1()

            assertEquals(283, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day19(input).solvePart2()

            assertEquals(16, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day19(resourceAsListOfString("day19.txt")).solvePart2()

            assertEquals(615_388_132_411_142, answer)
        }
    }
}