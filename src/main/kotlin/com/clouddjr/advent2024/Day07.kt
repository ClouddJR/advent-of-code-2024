package com.clouddjr.advent2024

import com.clouddjr.advent2024.Day07.Operator.ADD
import com.clouddjr.advent2024.Day07.Operator.CONCATENATE
import com.clouddjr.advent2024.Day07.Operator.MULTIPLY

class Day07(input: List<String>) {
    private val equations = input.map { Equation.from(it) }

    fun solvePart1() =
        calibrationResult(operators = listOf(ADD, MULTIPLY))

    fun solvePart2() =
        calibrationResult(operators = listOf(ADD, MULTIPLY, CONCATENATE))

    private fun calibrationResult(operators: List<Operator>) =
        equations
            .filter { it.hasSolution(operators) }
            .sumOf { it.value }

    private data class Equation(val value: Long, val numbers: List<Long>) {
        fun hasSolution(operators: List<Operator>) =
            check(
                current = value,
                i = numbers.lastIndex,
                operators = operators
            )

        private fun check(current: Long, i: Int, operators: List<Operator>): Boolean {
            if (i == 0) return current == numbers.first()

            return operators.any { operator ->
                operator.canYield(current, numbers[i]) && check(operator.reverse(current, numbers[i]), i - 1, operators)
            }
        }

        companion object {
            fun from(line: String): Equation {
                val value = line.substringBefore(":").toLong()
                val numbers = line.substringAfter(": ").split(" ").map { it.toLong() }

                return Equation(value, numbers)
            }
        }
    }

    private enum class Operator(
        val canYield: (Long, Long) -> Boolean,
        val reverse: (Long, Long) -> Long
    ) {
        ADD(
            canYield = { a, b -> a - b >= 0 },
            reverse = { a, b -> a - b }
        ),
        MULTIPLY(
            canYield = { a, b -> a % b == 0L },
            reverse = { a, b -> a / b }
        ),
        CONCATENATE(
            canYield = { a, b -> "$a".endsWith("$b") },
            reverse = { a, b -> "$a".removeSuffix("$b").toLongOrNull() ?: 0 }
        )
    }
}