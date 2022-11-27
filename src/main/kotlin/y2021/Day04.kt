package y2021

// Considering a grid as full-line of Int
typealias Grid = List<Int>

class Day04(private val data: List<String>) {

    private fun getDrew(input: List<String>): List<Int> {
        return input[0]             // <= Get the first line
            .split(",")   // <= Split values with "," separator
            .map { it.toInt() }     // <= Values are int, convert them
    }

    private fun getGrids(input: List<String>): List<Grid> {
        return input
            .drop(2)                                    // <= Skip drew lines (used in getDrew)
            .chunked(6)                               // <= Split into lists of blocs of 6 lines
            .map { boardLines ->                           // <= For each chunk/bloc (of 6 lines), treat them as grid
                boardLines
                    .take(5)                            // <= Take a bloc of 5 lines
                    .flatMap { it.split(" ") }   // <= Split values with " " separator
                    .filter { it.isNotBlank() }            // <= Remove remaining spaces
                    .map { it.toInt() }                    // <= Remaining values are int, convert them
            }
            .toList()
    }

    private fun isBingo(board: List<Int>, numbers: Set<Int>): Boolean {
        // Browse grid values in two dimensions with 5 iterations
        for (i in 0..4) {
            // Check rows
            val start = i * 5
            // In a one-line grid, values in a row is index multiple of 5
            val row = listOf(board[start], board[start + 1], board[start + 2], board[start + 3], board[start + 4])
            if (numbers.containsAll(row)) return true

            // Check columns
            // In a one-line grid, values in a column is index addin a multiple of 5
            val column = listOf(board[i], board[i + 5], board[i + 10], board[i + 15], board[i + 20])
            if (numbers.containsAll(column)) return true
        }
        return false
    }

    private fun calculateResult(board: List<Int>, numbersChecked: Set<Int>): Int {
        return (board - numbersChecked).sum() * numbersChecked.last()
    }

    fun part1(): Int {
        val bingoDraw: List<Int> = getDrew(data)
        val grids: List<Grid> = getGrids(data)

        val numbersChecked = mutableSetOf<Int>()
        bingoDraw.forEach {
            numbersChecked.add(it)
            grids.firstOrNull { grid -> isBingo(grid, numbersChecked) }?.let { winningGrid ->
                return calculateResult(winningGrid, numbersChecked)
            }
        }

        return 0
    }

    fun part2(): Int {
        val bingoDraw: List<Int> = getDrew(data)
        var grids: List<Grid> = getGrids(data)

        val numbersChecked = mutableSetOf<Int>()
        bingoDraw.forEach {
            numbersChecked.add(it)
            if (grids.size != 1) {
                grids = grids.filter { grid -> !isBingo(grid, numbersChecked) }.toList()
            } else {
                if (isBingo(grids.first(), numbersChecked))
                    return calculateResult(grids.first(), numbersChecked)
            }
        }

        return 0
    }

    //region
}