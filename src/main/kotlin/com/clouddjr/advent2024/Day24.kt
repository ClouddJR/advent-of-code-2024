package com.clouddjr.advent2024

class Day24(input: String) {
    private val values =
        input.substringBefore("\n\n")
            .lines()
            .associate { it.substringBefore(":") to (it.substringAfter(": ") != "0") }
            .toMutableMap()

    private val connections =
        input.substringAfter("\n\n")
            .lines()
            .associate {
                val (in1, op, in2) = it.substringBefore(" ->").split(" ")
                it.substringAfter("-> ") to Operation(in1, op, in2)
            }

    fun solvePart1() =
        connections.keys
            .filter { it.startsWith("z") }
            .associateWith { it.evaluate() }
            .entries.sortedByDescending { it.key }
            .map { if (it.value) 1 else 0 }
            .joinToString("")
            .toLong(2)

    /*
     * Solved manually by observing that each zXX should have the following equation:
     *
     * z[n] = xor(
     *     xor(x[n], y[n]),
     *     or(
     *         and(x[n-1], y[n-1]),
     *         and(
     *             xor(x[n-1], y[n-1]),
     *             ...
     *         )
     *     )
     * )
     *
     * There were three zXX that didn't have XOR as the topmost operation.
     * The fourth one was found by scanning the input visually.
     */
    fun solvePart2() = "gbf,hdt,jgt,mht,nbf,z05,z09,z30"

    private fun String.evaluate(): Boolean =
        values.getOrPut(this) {
            val (in1, op, in2) = connections.getValue(this)

            when (op) {
                "AND" -> in1.evaluate() && in2.evaluate()
                "XOR" -> in1.evaluate() xor in2.evaluate()
                "OR" -> in1.evaluate() or in2.evaluate()
                else -> error("Invalid operation: $op")
            }
        }

    private data class Operation(val in1: String, val op: String, val in2: String)
}