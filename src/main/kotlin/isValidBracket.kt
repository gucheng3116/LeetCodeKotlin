import java.util.Stack

class isValidBracket {
    fun isValid(s: String): Boolean {
        val length = s.length
        val map = mapOf('(' to ')', '[' to ']', '{' to '}')
        var stack = Stack<Char>()
        for (i in 0 until length) {
            if (!stack.isEmpty() && map[stack.peek()] == s[i]) {
                stack.pop()
            } else if (map.containsKey(s[i])){
                stack.push(s[i])
            } else {
                return false
            }
        }
        return stack.size == 0

    }
}

fun main() {
    val isValidBracket = isValidBracket()
    println("[{}] is valid is " + isValidBracket.isValid("[{}]"))
    println("[]{}() is valid is " + isValidBracket.isValid("[]{}()"))
    println("[]{{ is valid is " + isValidBracket.isValid("[]{{"))

}