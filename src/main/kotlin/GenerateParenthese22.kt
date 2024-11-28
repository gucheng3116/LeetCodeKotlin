import java.util.*

class GenerateParenthese22 {
    fun generateParenthesis(n: Int): List<String> {
        if (n <= 0) {
            return emptyList()
        }
        val resultList = ArrayList<String>()
        backTrack(2*n, "(", mapOf('(' to n - 1, ')' to n), resultList)
        resultList.forEach {
            println(it)
        }
        return resultList
    }

    fun backTrack(size: Int, currentString: String, remainCharMap: Map<Char, Int>, resultList: ArrayList<String>) {
        if (currentString.length == size) {
            if (isPairingSuccess(currentString)) {
                resultList.add(currentString)
                return
            }
        }
        val keys = remainCharMap.keys.filter {
            remainCharMap[it]!! > 0
        }
        for (key in keys) {
            val string = "$currentString$key"
            val mutableMap = remainCharMap.toMutableMap()
            mutableMap[key]?.let {
                mutableMap[key] = it - 1
            }
            backTrack(size, string, mutableMap, resultList)
        }
    }

    private fun isPairingSuccess(string: String): Boolean {
        val size = string.length
        if (size % 2 != 0) {
//            println("$string is false")
            return false
        }
        val stack = Stack<Char>()
        for (char in string) {
            if (char == '(') {
                stack.push(char)
            } else if (char == ')' && stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop()
            } else {
                return false
            }
        }
        val result =  if (stack.isEmpty()) {
            true
        } else {
            false
        }
        return result
    }
}

fun main() {
    val solution = GenerateParenthese22()
    solution.generateParenthesis(3)
}