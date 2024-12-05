package com.clouddjr.advent2024

class Day05(input: String) {
    private val rules =
        input.substringBefore("\n\n").lines().map { it.split("|").map(String::toInt) }
            .groupBy({ it.first() }, { it.last() })
            .mapValues { it.value.toSet() }
            .withDefault { emptySet() }

    private val updates = input.substringAfter("\n\n").lines().map { it.split(",").map(String::toInt) }

    fun solvePart1() = updates.filter { it.isSortedByRules() }.sumOf { it[it.size / 2] }

    fun solvePart2() = updates.filterNot { it.isSortedByRules() }.map { it.sortedByRules() }.sumOf { it[it.size / 2] }

    private fun List<Int>.isSortedByRules() = this == this.sortedByRules()

    private fun List<Int>.sortedByRules() = this.sortedWith { o1, o2 -> if (o2 in rules.getValue(o1)) -1 else 1 }
}