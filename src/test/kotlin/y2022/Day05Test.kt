package y2022

import common.Resources.asListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 5")
class Day05Test {

    // Arrange
    private val exampleInput = asListOfString("2022/day05-sample.txt")
    private val input = asListOfString("2022/day05-input.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(exampleInput).part1()

            // Assert
            assertThat(answer).isEqualTo("CMZ")
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(input).part1()

            // Assert
            assertThat(answer).isEqualTo("CFFHVVHNC")
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
            assertThat(answer).isEqualTo("MCD")
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(input).part2()

            // Assert
            assertThat(answer).isEqualTo("FSZWBPTBG")
        }
    }
}