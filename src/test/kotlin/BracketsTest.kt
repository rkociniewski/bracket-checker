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
        assertTrue { isBalanced(brackets) }
    }

    @ParameterizedTest
    @MethodSource("falseProvider")
    fun `should return false when brackets aren't balanced`(brackets: String) {
        assertFalse { isBalanced(brackets) }
    }

    private fun trueProvider() = listOf(
        Arguments.of("()"),
        Arguments.of("[]"),
        Arguments.of("{}"),
        Arguments.of("[()]"),
        Arguments.of("{[()]}"),
        Arguments.of("()[]{}"),
    )

    private fun falseProvider() = listOf(
        Arguments.of("{{"),
        Arguments.of("{]"),
        Arguments.of(")"),
        Arguments.of("]["),
        Arguments.of("}{"),
        Arguments.of("([)]"),
    )
}
