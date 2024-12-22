package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfLong
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches actual`() {
            val answer = Day22(resourceAsListOfLong("day22.txt")).solvePart1()

            assertEquals(14_476_723_788, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day22(resourceAsListOfLong("day22.txt")).solvePart2()

            assertEquals(1630, answer)
        }
    }
}