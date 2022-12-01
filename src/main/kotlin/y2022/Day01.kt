package y2022

import common.Resources.splitOnEmpty

class Day01(private val data: List<String>) {

    fun part1(): Int {
        return data
            .splitOnEmpty()
            .map { grouped -> grouped.sumOf { it.toInt() } }
            .max()
    }

    fun part2(): Int {
        return data
            .splitOnEmpty()
            .map { grouped -> grouped.sumOf { it.toInt() } }
            .sortedDescending()
            .take(3)
            .sum()
    }

}