package y2022

class Day03(private val data: List<String>) {

    // region Letter values

    private val abc = "abcdefghijklmnopqrstuvwxyz"
    private fun Char.letterValue(): Int {
        val index = abc.indexOf(this.lowercase())
        return if (this.isUpperCase()) {
            index + 27
        } else {
            index + 1
        }
    }

    // endregion

    data class Rucksack(val leftCompartment: String, val rightCompartment: String) {
        fun findCommonChar(): Char {
            leftCompartment.forEach { value ->
                if (rightCompartment.any { it == value }) {
                    return value
                }
            }
            return '*'
        }
    }

    private fun getGrids(input: List<String>): List<Rucksack> {
        return input
            .map { line ->
                Rucksack(line.substring(0, line.length / 2), line.substring(line.length / 2, line.length))
            }
            .toList()
    }

    fun part1(): Int {
        val rucksackList = getGrids(data)
        return rucksackList.sumOf {
            it.findCommonChar().letterValue()
        }
    }

    fun part2(): Int {
        return data.chunked(3) { group ->     // <= For each chunk/bloc of 3 lines : Treat them as Team / List<Rucksack>
            val firstLine = group[0].toSet()
            group
                .drop(1)    // ignore first line
                .fold(firstLine) { acc, rucksack -> acc.intersect(rucksack.toSet()) }
                .sumOf { it.letterValue() }
        }.sum()
    }

}
