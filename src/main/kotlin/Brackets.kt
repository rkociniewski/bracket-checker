import java.util.*

fun isBalanced(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        when {
            !stack.isEmpty() && it == '}' && stack.peek() == '{' -> stack.pop()
            !stack.isEmpty() && it == ')' && stack.peek() == '(' -> stack.pop()
            !stack.isEmpty() && it == ']' && stack.peek() == '[' -> stack.pop()
            else -> stack.push(it)
        }
    }
    return stack.isEmpty()
}
