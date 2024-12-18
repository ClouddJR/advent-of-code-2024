package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {
    private val input = """
        Register A: 2024
        Register B: 0
        Register C: 0

        Program: 0,3,5,4,3,0
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart1()

            assertEquals("5,7,3,0", answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart1()

            assertEquals("6,0,6,3,0,2,3,1,6", answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day17(input).solvePart2()

            assertEquals(117_440, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart2()

            assertEquals(236_539_226_447_469, answer)
        }
    }
}