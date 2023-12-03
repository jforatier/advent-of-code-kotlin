package y2023

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 1")
class Day01Test {

    // Arrange
    private val exampleInput = asListOfString("2023/day01-sample.txt")
    private val input = asListOfString("2023/day01-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(142)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(input).part1()

            // Assert
            assertThat(answer).isEqualTo(54697)
        }
    }

    private val example2Input = asListOfString("2023/day01-sample-02.txt")

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(example2Input).part2()

            // Assert
            assertThat(answer).isEqualTo(281)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(input).part2()

            // Assert
            assertThat(answer).isEqualTo(54885)
        }
    }
}