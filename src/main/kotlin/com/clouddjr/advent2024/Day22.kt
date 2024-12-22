package com.clouddjr.advent2024

class Day22(private val input: List<Long>) {
    fun solvePart1() =
        input.sumOf { it.generateSecrets().last() }

    fun solvePart2() =
        buildMap {
            input.forEach { initial ->
                val secrets = initial.generateSecrets()
                val diffs = secrets.zipWithNext().map { it.second % 10 - it.first % 10 }

                val seen = mutableSetOf<String>()
                (0..secrets.lastIndex - 4).forEach { i ->
                    val seq = diffs.slice(i..i + 3).joinToString()
                    if (seq !in seen) {
                        compute(seq) { _, current -> secrets[i + 4] % 10 + (current ?: 0L) }
                        seen += seq
                    }
                }
            }
        }.values.max()

    private fun Long.generateSecrets() = generateSequence(this) { it.evolve() }.take(2001).toList()

    private fun Long.evolve() =
        this
            .let { it xor (it shl 6 and 0xFFFFFF) }
            .let { it xor (it shr 5 and 0xFFFFFF) }
            .let { it xor (it shl 11 and 0xFFFFFF) }
}