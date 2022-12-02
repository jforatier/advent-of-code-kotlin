package y2022

class Day02(private val data: List<String>) {

    enum class Action(val char: Set<String>, val value:Int) {
        UNKNOWN(setOf(),0),
        ROCK(setOf("A","X"), 1),
        PAPER(setOf("B","Y"), 2),
        SCISSORS(setOf("C","Z"),3);

        fun winAgainst() : Action {
            return when(this) {
                UNKNOWN -> UNKNOWN
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }
        }

        fun failAgainst() : Action {
            return when(this) {
                UNKNOWN -> UNKNOWN
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
            }
        }
    }

    enum class ResultExpected(val char: String) {
        UNKNOWN(""),
        WIN("Z"),
        DRAW("Y"),
        LOSS("X");
    }

    private fun String.actionForResult(opponentChoose: Action): Day02.Action {
        var resultExpected = ResultExpected.UNKNOWN
        ResultExpected.values().forEach {
            if(it.char.contains(this)){
                resultExpected = it
            }
        }
        return when(resultExpected){
            ResultExpected.DRAW, ResultExpected.UNKNOWN -> opponentChoose
            ResultExpected.LOSS -> opponentChoose.winAgainst()
            ResultExpected.WIN -> opponentChoose.failAgainst()
        }
    }

    private fun String.toAction(): Action {
        Action.values().forEach {
            if(it.char.contains(this)){
                return it
            }
        }
        return Action.UNKNOWN
    }

    data class Round(val opponentChoose: Action, val myChoice: Action) {

        fun getScore() : Int {
            return when(myChoice.winState(opponentChoose)){
                true -> myChoice.value + 6
                null -> myChoice.value + 3
                false -> myChoice.value
            }
        }

    }

    fun part1(): Int {
        return data
            .map { line -> Round(line.split(" ")[0].toAction(),line.split(" ")[1].toAction() ) }
            .sumOf { it.getScore() }
    }

    fun part2(): Int {
        return data
            .map { line -> Round(line.split(" ")[0].toAction(),line.split(" ")[1].actionForResult(line.split(" ")[0].toAction()) ) }
            .sumOf { it.getScore() }
    }

}

private fun Day02.Action.winState(opponentChoose: Day02.Action): Boolean? {
    if(this == opponentChoose){
        return null
    }
    if(this.failAgainst() == opponentChoose){
        return false
    }
    return true
}
