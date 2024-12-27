package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 24")
class Day24Test {
    private val input = """
        x00: 1
        x01: 1
        x02: 1
        y00: 0
        y01: 1
        y02: 0

        x00 AND y00 -> z00
        x01 XOR y01 -> z01
        x02 OR y02 -> z02
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day24(input).solvePart1()

            assertEquals(4, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsText("day24.txt")).solvePart1()

            assertEquals(51_657_025_112_326, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches actual`() {
            val answer = Day24(resourceAsText("day24.txt")).solvePart2()

            assertEquals("gbf,hdt,jgt,mht,nbf,z05,z09,z30", answer)
        }
    }
}