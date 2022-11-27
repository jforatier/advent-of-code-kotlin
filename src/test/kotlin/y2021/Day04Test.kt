package y2021

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 4")
class Day04Test {

    // Arrange
    private val exampleInput = asListOfString("2021/day04-sample.txt")
    private val input = asListOfString("2021/day04-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day04(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(4512)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(input).part1()

            // Assert
            assertThat(answer).isEqualTo(64084)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day04(exampleInput).part2()

            // Assert
            assertThat(answer).isEqualTo(1924)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(input).part2()

            // Assert
            assertThat(answer).isEqualTo(12833)
        }
    }
}