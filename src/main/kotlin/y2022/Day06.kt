package y2022

import common.Resources.splitOnEmpty
import java.util.*

class Day06(private val data: List<String>) {

    private fun String.findStartMarker(startMarkerSize: Int): Int =
        withIndex()
            .windowed(startMarkerSize, 1)
            .first { window ->
                window.map { it.value }.toSet().size == startMarkerSize
            }.last().index + 1

    fun part1(): Int {
        return data.reduce { acc, s -> acc + s }.findStartMarker(4)
    }

    fun part2(): Int {
        return data.reduce { acc, s -> acc + s }.findStartMarker(14)
    }

}
