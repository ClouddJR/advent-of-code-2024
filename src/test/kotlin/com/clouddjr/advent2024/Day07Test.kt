package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 7")
class Day07Test {
    private val input = """
        190: 10 19
        3267: 81 40 27
        83: 17 5
        156: 15 6
        7290: 6 8 6 15
        161011: 16 10 13
        192: 17 8 14
        21037: 9 7 18 13
        292: 11 6 16 20
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart1()

            assertEquals(3749, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()

            assertEquals(2_941_973_819_040, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart2()

            assertEquals(11_387, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()

            assertEquals(249_943_041_417_600, answer)
        }
    }
}