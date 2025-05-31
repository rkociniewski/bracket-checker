package rk.powermilk

/**
 * Checks if the string contains a balanced set of brackets.
 *
 * This function verifies that all opening brackets ('(', '[', '{')
 * have corresponding and correctly ordered closing brackets (')', ']', '}').
 * Any non-bracket characters are ignored.
 *
 * The check is performed using a functional approach with `fold`, which simulates
 * a stack structure to match bracket pairs.
 * The string is considered balanced if
 * all brackets are properly closed in the correct order and no unmatched brackets remain.
 *
 * @receiver the string to check for balanced brackets
 * @return `true` if the brackets in the string are balanced, `false` otherwise
 *
 * @sample
 * ```kotlin
 * "()[]{}".isBalanced() // true
 * "([{}])".isBalanced() // true
 * "(]".isBalanced()     // false
 * "([)]".isBalanced()   // false
 * ```
 */
fun String.isBalanced(): Boolean {
    val pairs = mapOf(')' to '(', ']' to '[', '}' to '{')

    val result = this.fold(listOf<Char>()) { stack, char ->
        when (char) {
            '(', '[', '{' -> stack + char
            ')', ']', '}' -> {
                if (stack.isNotEmpty() && stack.last() == pairs[char]) {
                    stack.dropLast(1)
                } else {
                    return false
                }
            }

            else -> stack
        }
    }

    return result.isEmpty()
}
