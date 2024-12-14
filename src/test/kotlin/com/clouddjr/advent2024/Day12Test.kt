package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
class Day12Test {
    private val input = """
        RRRRIICCFF
        RRRRIICCCF
        VVRRRCCFFF
        VVRCCCJFFF
        VVVVCJJCFE
        VVIVCCJJEE
        VVIIICJJEE
        MIIIIIJJEE
        MIIISIJEEE
        MMMISSJEEE
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart1()

            assertEquals(1930, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart1()

            assertEquals(1_377_008, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day12(input).solvePart2()

            assertEquals(1206, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart2()

            assertEquals(815_788, answer)
        }
    }
}