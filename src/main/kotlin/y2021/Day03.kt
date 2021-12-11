package y2021

class Day03(private val data: List<String>) {

    class Report(private val data: List<String>) {
        fun gamma(): String {
            // Using first line to determine limits of my browse (indices of line 1 will tell me I can look through column 0 to 4)
            // Then for each column (0 to 4), I count 1, if there are in majority we return 1 else 0
            // Last we generate final binary number with "10101"
            return data.first().indices.map { column ->
                if (data.count { it[column] == '1' } > data.size / 2) '1' else '0'
            }.joinToString("")
        }

        fun epsilon(): String {
            // The epsilon is the just a binary revert for gamma
            return gamma().map { if (it == '1') '0' else '1' }.joinToString("")
        }

        fun oxygen(): Int {
            return browse { ones, zeros -> if (ones.size >= zeros.size) ones else zeros }
        }

        fun co2(): Int {
            return browse { ones, zeros -> if (zeros.size <= ones.size) zeros else ones }
        }

        private fun browse(
            compare: (ones: List<String>, zeros: List<String>) -> List<String>
        ) = data.first().indices
            .fold(data) { acc, index ->
                if (acc.size == 1) {
                    acc
                } else {
                    val ones = acc.filter { it[index] == '1' }
                    val zeros = acc.filter { it[index] == '0' }
                    compare(ones, zeros)
                }
            }
            .joinToString("")
            .toInt(2)
    }

    fun part1(): Int {
        val report = Report(data)
        return report.gamma().toInt(2) * report.epsilon().toInt(2)
    }

    fun part2(): Int {
        val report = Report(data)
        return report.co2() * report.oxygen()

    }

}