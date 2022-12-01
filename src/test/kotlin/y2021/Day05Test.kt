package y2021

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 5: Hydrothermal Venture")
class Day05Test {

    // Arrange
    private val exampleInput = asListOfString("2021/day05-sample.txt")
    private val input = asListOfString("2021/day05-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(input).part1()

            // Assert
            assertThat(answer).isEqualTo(5280)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(exampleInput).part2()

            // Assert
            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(input).part2()

            // Assert
            assertThat(answer).isEqualTo(16716)
        }
    }
}