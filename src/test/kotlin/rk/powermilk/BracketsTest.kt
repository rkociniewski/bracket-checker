package rk.powermilk

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BracketsTest {

    @ParameterizedTest
    @MethodSource("trueProvider")
    fun `should return true when brackets are balanced`(brackets: String) {
        assertTrue { brackets.isBalanced() }
    }

    @ParameterizedTest
    @MethodSource("falseProvider")
    fun `should return false when brackets aren't balanced`(brackets: String) {
        assertFalse { brackets.isBalanced() }
    }

    private fun trueProvider() = listOf(
        Arguments.of("()"),
        Arguments.of("[]"),
        Arguments.of("{}"),
        Arguments.of("[()]"),
        Arguments.of("{[()]}"),
        Arguments.of("()[]{}"),
        Arguments.of(""),
        Arguments.of("{[()]} some text (still works)"),
        Arguments.of("(((((((((())))))))))"),
        Arguments.of("function() { return [true]; }"),
        Arguments.of("if (a[0] == 'b') { println(\"OK\") }"),
    )

    private fun falseProvider() = listOf(
        Arguments.of("{{"),
        Arguments.of("{]"),
        Arguments.of(")"),
        Arguments.of("]["),
        Arguments.of("}{"),
        Arguments.of("([)]"),
        Arguments.of("((("),
        Arguments.of(")))"),
        Arguments.of("([{}]))"),
        Arguments.of("function(arg] = {})"),
        Arguments.of("()[]{}[)"),
        Arguments.of("function() { return [true]; "),
        Arguments.of("a + b) * c"),
        Arguments.of("{[}]"),
        Arguments.of("if (a[0] == '{') { println(\"OK\") }"),
    )
}
