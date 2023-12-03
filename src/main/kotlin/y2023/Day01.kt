package y2023

import common.Resources.splitOnEmpty

class Day01(private val data: List<String>) {

    val VALID_DIGITS: Map<String, Int> = mapOf(
        Pair("1", 1),
        Pair("2", 2),
        Pair("3", 3),
        Pair("4", 4),
        Pair("5", 5),
        Pair("6", 6),
        Pair("7", 7),
        Pair("8", 8),
        Pair("9", 9),
        Pair("one", 1),
        Pair("two", 2),
        Pair("three", 3),
        Pair("four", 4),
        Pair("five", 5),
        Pair("six", 6),
        Pair("seven", 7),
        Pair("eight", 8),
        Pair("nine", 9)
    )

    fun part1(): Int {
        return data
            .splitOnEmpty()
            .map { grouped ->
                grouped.map { line -> line.filter { char -> char.digitToIntOrNull() != null } }
            }
            // Lines of Int
            .map {
                it.map { intInLine ->
                    if (intInLine.length < 2) {
                        StringBuilder().append(intInLine[0]).append(intInLine[0]).toString()
                    } else if (intInLine.length > 2) {
                        StringBuilder().append(intInLine[0]).append(intInLine[intInLine.length - 1]).toString()
                    } else {
                        intInLine
                    }
                }
            }
            .map { it.map { line -> line.toIntOrNull() } }
            .reduce { acc, ints -> acc + ints }
            .sumOf { it ?: 0 }
    }

    fun part2(): Int {
        return data
            .splitOnEmpty()
            .map { line ->
                line.map { word ->
                    val first = VALID_DIGITS.get(word.findAnyOf(VALID_DIGITS.keys)?.second)
                    val second = VALID_DIGITS.get(word.findLastAnyOf(VALID_DIGITS.keys)?.second)
                    "$first$second".toInt()
                }
            }
            .reduce { acc, ints -> acc + ints }
            .sumOf { it }
    }
}