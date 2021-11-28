package y2020

class Day01(data: List<Int>) {

    private val input = data.sorted()

    fun part1(): Int =
        input.mapIndexedNotNull { idx, a ->
            input
                .drop(idx + 1)
                .dropWhile { a + it < 2020 }
                .take(1)
                .firstOrNull { a + it == 2020 }
                ?.let { a * it }
        }.first()

    fun part2(): Int =
        input.mapIndexedNotNull { aIdx, a ->
            input
                .drop(aIdx + 1)
                .mapIndexedNotNull { bIdx, b ->
                    input
                        .drop(bIdx + 1)
                        .dropWhile { a + b + it < 2020 }
                        .take(1)
                        .firstOrNull { a + b + it == 2020 }
                        ?.let { a * b * it }
                }.firstOrNull()
        }.first()

}