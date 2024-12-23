package com.clouddjr.advent2024

import com.clouddjr.advent2024.Resources.resourceAsListOfString
import kotlin.test.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {
    private val input = """
        kh-tc
        qp-kh
        de-cg
        ka-co
        yn-aq
        qp-ub
        cg-tb
        vc-aq
        tb-ka
        wh-tc
        yn-cg
        kh-ub
        ta-co
        de-co
        tc-td
        tb-wq
        wh-td
        ta-ka
        td-qp
        aq-cg
        wq-ub
        ub-vc
        de-ta
        wq-aq
        wq-vc
        wh-yn
        ka-de
        kh-ta
        co-tc
        wh-qp
        tb-vc
        td-yn
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day23(input).solvePart1()

            assertEquals(7, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day23(resourceAsListOfString("day23.txt")).solvePart1()

            assertEquals(1184, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day23(input).solvePart2()

            assertEquals("co,de,ka,ta", answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day23(resourceAsListOfString("day23.txt")).solvePart2()

            assertEquals("hf,hz,lb,lm,ls,my,ps,qu,ra,uc,vi,xz,yv", answer)
        }
    }
}