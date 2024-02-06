package y2023

import common.Resources.splitOnEmpty

class Day03(private val data: List<String>) {

    fun part1(): Int {
        val digits = "\\d+".toRegex()
        val partNumbers = mutableListOf<Int>()
        data.forEachIndexed { row, s ->
            val numbers = digits.findAll(s)
                .map { it.range to it.value.toInt() }
                .filter { (range, _) ->
                    val adjacentCells = (range.first - 1..range.last + 1).flatMap {
                        listOf(row - 1 to it, row to it, row + 1 to it)
                    }

                    adjacentCells.forEach { (x, y) ->
                        runCatching {
                            if (!data[x][y].isDigit() && data[x][y] != '.') return@filter true
                        }
                    }
                    false
                }

            partNumbers += numbers.map { it.second }
        }

        return partNumbers.sum()
    }

    fun part2(): Int {
        val digits = "\\d+".toRegex()
        val numbersWithCoordinates = data.flatMapIndexed { row, s ->
            digits.findAll(s).map { (row to it.range) to it.value.toInt() }
        }.toMap()
        val gearRatios = mutableListOf<Int>()

        data.forEachIndexed { row, s ->
            val asteriskIndexes = s.mapIndexedNotNull { index: Int, c: Char -> if (c == '*') index else null }

            asteriskIndexes.forEach { index ->
                val adjacentNumbers = numbersWithCoordinates.filterKeys { (x, range) ->
                    x in row - 1..row + 1 && range.any { it in index - 1..index + 1 }
                }

                if (adjacentNumbers.values.size == 2) {
                    gearRatios += adjacentNumbers.values.fold(1) { acc, i -> i * acc }
                }
            }


        }

        return gearRatios.sum()
    }

}
