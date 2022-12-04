package y2022

import common.Resources.splitOnEmpty
import java.util.*

class Day05(private val data: List<String>) {

    data class Move(val size: Int, val start: Int, val dest: Int)

    class Cargo(val data: List<String>) {

        val stacksInput = data.splitOnEmpty()
            .first()
            /**
             *     [D]
             * [N] [C]
             * [Z] [M] [P]
             *  1   2   3
             */
            .reversed()
        /**
         *  1   2   3
         * [Z] [M] [P]
         * [N] [C]
         *     [D]
         */

        val size = stacksInput.first().split(" ").filter { it -> it.isNotEmpty() }.last().toInt()
        val stack: MutableMap<Int, MutableList<String>> = mutableMapOf()

        val moves = data
            .dropWhile {
                !it.startsWith("move")
            }.map {
                val splittedValue = it.split(" ")
                Move(splittedValue[1].toInt(), splittedValue[3].toInt(), splittedValue[5].toInt())
            }

        init {
            (0 until size).map { mapIndex ->
                if(stack[mapIndex] == null) {
                    stack.put(mapIndex, mutableListOf())
                }
                stacksInput.drop(1).forEach {
                    // * [Z] [M] [P]
                    val splittedLetters = it.chunked(4)
                    if(mapIndex < splittedLetters.size && splittedLetters[mapIndex].isNotBlank()) {
                        stack[mapIndex]!!.add(splittedLetters[mapIndex]
                            .replace(" ","")
                            .replace("[","")
                            .replace("]",""))
                    }
                }
                stack[mapIndex] = stack[mapIndex]!!.reversed().toMutableList()
            }
        }

        fun applyMoves(reversed: Boolean = true): String {
            var result = ""
            moves.forEach { move ->
                val toBeMoved = stack[move.start - 1]!!.take(move.size)
                repeat(move.size) { stack[move.start - 1]?.removeFirst() }
                stack[move.dest - 1]?.addAll(0, if (reversed) toBeMoved.reversed() else toBeMoved)
            }

            stack.forEach {
                result += it.value.first()
            }
            return result
        }
    }

    fun part1(): String {
        val cargo = Cargo(data)
        return cargo.applyMoves(true)
    }

    fun part2(): String {
        val cargo = Cargo(data)
        return cargo.applyMoves(false)
    }

}
