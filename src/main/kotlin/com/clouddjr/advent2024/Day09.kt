package com.clouddjr.advent2024

class Day09(private val input: String) {
    fun solvePart1(): Long {
        val (spaces, files) = parseDiskMap()

        val spacesFlattened = spaces.flatMap { s -> (0..<s.length).map { i -> Block(s.position + i, 1, s.id) } }
        val filesFlattened = files.flatMap { f -> (0..<f.length).map { i -> Block(f.position + i, 1, f.id) } }

        return calculateResult(spacesFlattened.toMutableList(), filesFlattened.toMutableList())
    }

    fun solvePart2(): Long {
        val (spaces, files) = parseDiskMap()
        return calculateResult(spaces, files)
    }

    private fun calculateResult(spaces: MutableList<Block>, files: MutableList<Block>): Long {
        for (fi in files.indices.reversed()) {
            val (fp, fl, fid) = files[fi]

            for (si in spaces.indices) {
                val (sp, sl, sid) = spaces[si]

                if (sp >= fp) break

                if (sl >= fl) {
                    files[fi] = Block(sp, fl, fid)
                    spaces[si] = Block(sp + fl, sl - fl, sid)
                    break
                }
            }
        }

        return files.sumOf { f -> (0..<f.length).sumOf { i -> f.id.toLong() * (f.position + i) } }
    }

    private fun parseDiskMap(): Pair<MutableList<Block>, MutableList<Block>> {
        val spaces = mutableListOf<Block>()
        val files = mutableListOf<Block>()

        var position = 0
        input.map { it.digitToInt() }.forEachIndexed { i, length ->
            (if (i % 2 == 0) files else spaces).add(Block(position, length, i / 2))
            position += length
        }

        return spaces to files
    }

    private data class Block(val position: Int, val length: Int, val id: Int)
}