import java.util.*

fun isBalanced(s: String): Boolean {
    val stack = Stack<Char>()

    val map = mapOf('}' to '{', ')' to '(', ']' to '[')

    s.forEach {
        when {
            !stack.isEmpty() && stack.peek() == map[it] -> stack.pop()
            else -> stack.push(it)
        }
    }

    return stack.empty()
}
