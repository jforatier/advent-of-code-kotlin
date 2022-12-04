package y2022

class Day04(private val data: List<String>) {

    data class Section(val start: Int, val end: Int)
    data class Assignment(val firstElf: Section, val secondElf: Section) {
        fun fullyContain(): Boolean {
            val firstElfRange = firstElf.start.rangeTo(firstElf.end)
            val secondElfRange = secondElf.start.rangeTo(secondElf.end)
            return firstElfRange.all { secondElfRange.contains(it) } || secondElfRange.all { firstElfRange.contains(it) }
        }

        fun neverContain(): Boolean {
            val firstElfRange = firstElf.start.rangeTo(firstElf.end)
            val secondElfRange = secondElf.start.rangeTo(secondElf.end)
            return firstElfRange.any { secondElfRange.contains(it) } && secondElfRange.any { firstElfRange.contains(it) }
        }
    }

    fun part1(): Int {
        return data.map {
            Assignment(
                Section(it.split(",")[0].split("-")[0].toInt(), it.split(",")[0].split("-")[1].toInt()),
                Section(it.split(",")[1].split("-")[0].toInt(), it.split(",")[1].split("-")[1].toInt())
            )
        }.count {
            it.fullyContain()
        }
    }

    fun part2(): Int {
        return data.map {
            Assignment(
                Section(it.split(",")[0].split("-")[0].toInt(), it.split(",")[0].split("-")[1].toInt()),
                Section(it.split(",")[1].split("-")[0].toInt(), it.split(",")[1].split("-")[1].toInt())
            )
        }.count {
            it.neverContain()
        }
    }

}
