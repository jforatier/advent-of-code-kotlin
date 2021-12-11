package y2021

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 3")
class Day03Test {

    // Arrange
    private val exampleInput = asListOfString("2021/day03-sample.txt")
    private val input = asListOfString("2021/day03-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(198)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(input).part1()

            // Assert
            assertThat(answer).isEqualTo(2250414)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(exampleInput).part2()

            // Assert
            assertThat(answer).isEqualTo(230)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(input).part2()

            // Assert
            assertThat(answer).isEqualTo(6085575)
        }
    }
}