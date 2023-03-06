import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BracketsTest {
    @Test
    fun `should return true when brackets are balanced`() {
        assertTrue(isBalanced("()()"))
    }

    @Test
    fun `should return false when brackets aren't balanced`() {
        assertFalse(isBalanced("(()"))
    }
}