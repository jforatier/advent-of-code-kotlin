package y2022

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 6")
class Day06Test {

    // Arrange
    private val exampleInput = asListOfString("2022/day06-sample.txt")
    private val input = asListOfString("2022/day06-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(7)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(input).part1()

            // Assert
            assertThat(answer).isEqualTo(1833)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(exampleInput).part2()

            // Assert
            assertThat(answer).isEqualTo(19)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(input).part2()

            // Assert
            assertThat(answer).isEqualTo(3425)
        }
    }
}