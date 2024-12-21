package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart1()

            assertEquals(1518, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart2()

            assertEquals(1_032_257, answer)
        }
    }
}