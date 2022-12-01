package y2021

import kotlin.math.absoluteValue
import kotlin.math.sign

class Day05(private val data: List<String>) {

    private val table: MutableMap<Coordinate, Int> = mutableMapOf()

    data class Coordinate(val x: Int, val y: Int) {
        fun lineTo(that: Coordinate): List<Coordinate> {
            val xDelta = (that.x - x).sign
            val yDelta = (that.y - y).sign
            val steps = maxOf((x - that.x).absoluteValue, (y - that.y).absoluteValue)
            return (1..steps).scan(this) { last, _ -> Coordinate(last.x + xDelta, last.y + yDelta) }
        }
    }

    data class Line(val from: Coordinate, val to: Coordinate)

    private fun Line.onTheSameLine(): Boolean {
        return this.from.x == this.to.x
    }

    private fun Line.onTheSameColumn(): Boolean {
        return this.from.y == this.to.y
    }

    private fun getSegments(input: List<String>): List<Line> {
        return input
            .map { line ->
                line.split(" -> ")                // <= Split values with " -> " separator
                    .map {
                        Coordinate(
                            it.split(",")[0].toInt(),
                            it.split(",")[1].toInt()
                        )
                    }
            }.map { Line(it[0], it[1]) }
    }

    fun part1(): Int {
        getSegments(data)
            .filter { segment -> segment.onTheSameLine() || segment.onTheSameColumn() }
            .forEach {
                // 0,9 -> 5,9
                // 8,0 -> 0,8
                // ...
                val line = it.from.lineTo(it.to)
                line.forEach { point ->
                    if (table.get(Coordinate(point.x, point.y)) != null) {
                        table.put(Coordinate(point.x, point.y), table.get(Coordinate(point.x, point.y))!! + 1)
                    } else {
                        table.put(Coordinate(point.x, point.y), 1)
                    }
                }
            }
        return table.count { it.value > 1 }
    }

    fun part2(): Int {
        getSegments(data)
            .forEach {
                // 0,9 -> 5,9
                // 8,0 -> 0,8
                // ...
                val line = it.from.lineTo(it.to)
                line.forEach { point ->
                    if (table.get(Coordinate(point.x, point.y)) != null) {
                        table.put(Coordinate(point.x, point.y), table.get(Coordinate(point.x, point.y))!! + 1)
                    } else {
                        table.put(Coordinate(point.x, point.y), 1)
                    }
                }
            }
        return table.count { it.value > 1 }
    }

}
