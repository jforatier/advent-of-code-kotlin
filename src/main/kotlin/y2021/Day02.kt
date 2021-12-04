package y2021

class Day02(private val data: List<String>) {

    data class Move(val direction: String, val value: Int)

    private fun commandValue(data: List<String>): MutableList<Move> {
        val result: MutableList<Move> = mutableListOf()
        data.forEach {
            result.add(Move(it.split(" ")[0], it.split(" ")[1].toInt()))
        }
        return result
    }

    fun part1(input: MutableList<Move> = commandValue(data)): Int {
        var horizontal = 0
        var depth = 0
        input.forEach {
            when (it.direction) {
                "forward" -> horizontal = horizontal.plus(it.value)
                "down" -> depth = depth.plus(it.value)
                "up" -> depth = depth.minus(it.value)
                else -> print("Unhandled direction")
            }
        }
        return horizontal * depth
    }

    fun part2(input: MutableList<Move> = commandValue(data)): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach {
            when (it.direction) {
                "forward" -> {
                    horizontal = horizontal.plus(it.value)
                    depth = depth.plus(aim * it.value)
                }
                "down" -> aim = aim.plus(it.value)
                "up" -> aim = aim.minus(it.value)
                else -> print("Unhandled direction")
            }
        }
        return horizontal * depth
    }

}