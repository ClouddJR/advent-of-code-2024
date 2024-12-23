package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.combinations

class Day23(input: List<String>) {
    private val graph = buildMap<String, MutableList<String>> {
        input.forEach { line ->
            val (from, to) = line.split("-")
            getOrPut(from) { mutableListOf() } += to
            getOrPut(to) { mutableListOf() } += from
        }
    }

    fun solvePart1() =
        buildSet {
            graph.entries.forEach { (v, n) ->
                if (v.startsWith("t")) {
                    for (i in n.indices) {
                        for (j in i + 1..n.lastIndex) {
                            if (listOf(v, n[i], n[j]).isClique()) {
                                add(setOf(v, n[i], n[j]))
                            }
                        }
                    }
                }
            }
        }.size

    fun solvePart2() =
        (14 downTo 4).firstNotNullOf { size ->
            graph.entries.firstNotNullOfOrNull { (v, n) ->
                (n + v).combinations(size)
                    .firstOrNull { it.isClique() }
                    ?.sorted()
                    ?.joinToString(",")
            }
        }

    private fun List<String>.isClique() = combinations(2).all { (i, j) -> i in graph.getValue(j) }
}