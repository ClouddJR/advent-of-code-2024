package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {
    private val inputPart1 = """
       xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
    """.trimIndent()

    private val inputPart2 = """
       xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(inputPart1).solvePart1()

            assertEquals(161, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart1()

            assertEquals(196_826_776, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(inputPart2).solvePart2()

            assertEquals(48, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart2()

            assertEquals(106_780_429, answer)
        }
    }
}