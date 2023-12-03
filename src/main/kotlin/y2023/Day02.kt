package y2023

import common.Resources.splitOnEmpty

class Day02(private val data: List<String>) {

    data class Game(
        val id: Int,
        val numOfRed: MutableSet<Int> = mutableSetOf(),
        val numOfGreen: MutableSet<Int> = mutableSetOf(),
        val numOfBlue: MutableSet<Int> = mutableSetOf(),
    )

    fun part1(): Int {
        return data
            .splitOnEmpty()
            .map { it.map { line -> line.toGame() } }
            .sumOf {
                it.filter { game ->
                    game.numOfRed.find { it > 12 } == null
                            && game.numOfGreen.find { it > 13 } == null && game.numOfBlue.find { it > 14 } == null
                }.map { game -> game.id }.sum()
            }
    }

    fun part2(): Int {
        return data
            .splitOnEmpty()
            .map { it.map { line -> line.toGame() } }
            .sumOf { it.map { game -> game.numOfRed.max() * game.numOfGreen.max() * game.numOfBlue.max() }.sum() }
    }

    private fun String.toGame(): Game {
        var separator: List<String> = listOf()
        var values: List<String> = listOf()
        var result: MutableList<String> = mutableListOf()
        separator = this.split(":")
        values = separator[1].split(";")
        values.forEach {
            result.addAll(it.split(","))
        }
        val game = Game(
            id = separator[0].trim().split(" ")[1].toInt(),
        )
        result.forEach {
            if (it.contains("red")) {
                game.numOfRed.add(it.trim().split(" ")[0].toInt())
            } else if (it.contains("green")) {
                game.numOfGreen.add(it.trim().split(" ")[0].toInt())
            } else if (it.contains("blue")) {
                game.numOfBlue.add(it.trim().split(" ")[0].toInt())
            }
        }
        print(game.toString())
        return game
    }

}