package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 16")
class Day16Test {
    private val input = """
        #################
        #...#...#...#..E#
        #.#.#.#.#.#.#.#.#
        #.#.#.#...#...#.#
        #.#.#.#.###.#.#.#
        #...#.#.#.....#.#
        #.#.#.#.#.#####.#
        #.#...#.#.#.....#
        #.#.#####.#.###.#
        #.#.#.......#...#
        #.#.###.#####.###
        #.#.#...#.....#.#
        #.#.#.#####.###.#
        #.#.#.........#.#
        #.#.#.#########.#
        #S#.............#
        #################
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day16(input).solvePart1()

            assertEquals(11_048, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart1()

            assertEquals(135_512, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day16(input).solvePart2()

            assertEquals(64, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart2()

            assertEquals(541, answer)
        }
    }
}