package com.clouddjr.advent2024

import com.clouddjr.advent2024.utils.Point2D

class Day12(private val garden: List<String>) {
    fun solvePart1() = findRegions().sumOf { it.area * it.perimeter }

    fun solvePart2() = findRegions().sumOf { it.area * it.sides }

    private fun findRegions(): List<Region> {
        val visited = mutableSetOf<Point2D>()

        return garden.indices.flatMap { y ->
            garden[y].indices.mapNotNull { x ->
                val point = Point2D(x, y)
                if (point !in visited) findRegion(point, visited) else null
            }
        }
    }

    private fun findRegion(current: Point2D, visited: MutableSet<Point2D>): Region {
        if (current in visited) return Region(0, 0, 0)
        visited.add(current)

        val (inside, outside) = current.neighbours().partition {
            garden[current] == garden[it]
        }

        return inside.fold(
            Region(
                area = 1,
                perimeter = outside.size,
                sides = current.countCorners()
            )
        ) { region, neighbour ->
            region + findRegion(neighbour, visited)
        }
    }

    private operator fun List<String>.get(p: Point2D) =
        if (p.y in indices && p.x in this[p.y].indices) this[p.y][p.x] else null

    private fun Point2D.countCorners(): Int {
        return listOf(Point2D.UP, Point2D.RIGHT, Point2D.DOWN, Point2D.LEFT, Point2D.UP)
            .zipWithNext()
            .map { (d1, d2) ->
                listOf(
                    garden[this],
                    garden[this + d1],
                    garden[this + d2],
                    garden[this + d1 + d2]
                )
            }
            .count { (target, s1, s2, corner) ->
                (target != s1 && target != s2) || (target == s1 && target == s2 && target != corner)
            }
    }

    private data class Region(val area: Int, val perimeter: Int, val sides: Int) {
        operator fun plus(other: Region) =
            Region(
                area + other.area,
                perimeter + other.perimeter,
                sides + other.sides
            )
    }
}