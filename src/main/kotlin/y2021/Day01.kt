package y2021

class Day01(private val data: List<Int>) {

    fun part1(input: List<Int> = data): Int {
        var prev: Int? = null
        var increased = 0
        input.forEach {
            if (prev != null && it > prev!!) {
                increased++
            }
            prev = it
        }
        return increased
    }

    fun part2(): Int {
        val sums: MutableMap<Int, Int> = mutableMapOf()
        data.mapIndexed { index, value ->
            if(index + 2 < data.size) {
                sums[index] = value + data[index + 1] + data[index + 2]
            }
        }
        return part1(sums.values.toList())
    }

}