package y2020

import common.Resources.asListOfInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 1")
class Day01Test {

    // Arrange
    private val input = listOf(1721, 979, 366, 299, 675, 1456)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).part1()

            // Assert
            assertThat(answer).isEqualTo(514_579)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(asListOfInt("2020/day01.txt")).part1()

            // Assert
            assertThat(answer).isEqualTo(181_044)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).part2()

            // Assert
            assertThat(answer).isEqualTo(241_861_950)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(asListOfInt("2020/day01.txt")).part2()

            // Assert
            assertThat(answer).isEqualTo(82_660_352)
        }
    }
}