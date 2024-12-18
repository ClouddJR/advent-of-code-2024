package com.clouddjr.advent2024

class Day17(private val input: List<String>) {
    private val program = input[4].substringAfter(": ").split(",").map { it.toInt() }

    fun solvePart1() =
        execute(
            initialA = input[0].substringAfter("A: ").toLong(),
            initialB = input[1].substringAfter("B: ").toLong(),
            initialC = input[2].substringAfter("C: ").toLong()
        ).joinToString(",")

    fun solvePart2(): Long {
        fun findA(currentA: Long = 0): Long? =
            (currentA..currentA + 8).firstNotNullOfOrNull { a ->
                val out = execute(initialA = a)

                if (program.takeLast(out.size) == out) {
                    if (program == out) a else findA(maxOf(a shl 3, 8))
                } else {
                    null
                }
            }

        return findA() ?: error("No solution")
    }

    private fun execute(initialA: Long = 0, initialB: Long = 0, initialC: Long = 0): List<Int> {
        var a = initialA
        var b = initialB
        var c = initialC

        val combo = { operand: Int ->
            when (operand) {
                in 0..3 -> operand.toLong()
                4 -> a
                5 -> b
                6 -> c
                else -> error("Invalid operand: $operand")
            }
        }

        val out = mutableListOf<Int>()

        var pc = 0
        while (pc in program.indices) {
            val opcode = program[pc]
            val operand = program[pc + 1]

            when (opcode) {
                0 -> a = a shr combo(operand).toInt()
                1 -> b = b xor operand.toLong()
                2 -> b = combo(operand) % 8
                3 -> if (a != 0L) {
                    pc = operand
                    continue
                }
                4 -> b = b xor c
                5 -> out += (combo(operand) % 8).toInt()
                6 -> b = a shr combo(operand).toInt()
                7 -> c = a shr combo(operand).toInt()
            }
            pc += 2
        }

        return out
    }
}