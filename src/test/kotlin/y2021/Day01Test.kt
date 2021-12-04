package y2021

import common.Resources.asListOfInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 1")
class Day01Test {

    // Arrange
    private val exampleInput = asListOfInt("2021/day01-sample.txt")
    private val input = asListOfInt("2021/day01-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(7)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(input).part1()

            // Assert
            assertThat(answer).isEqualTo(1715)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(exampleInput).part2()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(input).part2()

            // Assert
            assertThat(answer).isEqualTo(1739)
        }
    }
}