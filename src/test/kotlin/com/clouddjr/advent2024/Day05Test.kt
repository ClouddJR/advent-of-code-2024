package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
class Day05Test {
    private val input = """
        47|53
        97|13
        97|61
        97|47
        75|29
        61|13
        75|53
        29|13
        97|29
        53|29
        61|53
        97|53
        61|29
        47|13
        75|47
        97|75
        47|61
        75|61
        47|29
        75|13
        53|13

        75,47,61,53,29
        97,61,53,29,13
        75,29,13
        75,97,47,61,53
        61,13,29
        97,13,75,29,47
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart1()

            assertEquals(143, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart1()

            assertEquals(4462, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart2()

            assertEquals(123, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart2()

            assertEquals(6767, answer)
        }
    }
}