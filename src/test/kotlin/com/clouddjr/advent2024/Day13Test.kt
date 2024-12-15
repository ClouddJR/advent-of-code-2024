package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {
    private val input = """
        Button A: X+94, Y+34
        Button B: X+22, Y+67
        Prize: X=8400, Y=5400

        Button A: X+26, Y+66
        Button B: X+67, Y+21
        Prize: X=12748, Y=12176

        Button A: X+17, Y+86
        Button B: X+84, Y+37
        Prize: X=7870, Y=6450

        Button A: X+69, Y+23
        Button B: X+27, Y+71
        Prize: X=18641, Y=10279
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day13(input).solvePart1()

            assertEquals(480, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsListOfString("day13.txt")).solvePart1()

            assertEquals(31_897, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day13(input).solvePart2()

            assertEquals(875_318_608_908, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day13(resourceAsListOfString("day13.txt")).solvePart2()

            assertEquals(87_596_249_540_359, answer)
        }
    }
}