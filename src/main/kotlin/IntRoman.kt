import java.util.LinkedList

// Question 12
class IntRoman {
    fun intToRoman(num: Int):String {
        val list = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val queue = LinkedList<Int>()
        queue.addAll(list)

        val map = mapOf(1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C", 90 to "XC", 50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")
        var count = num
        val resultStr = StringBuilder("")
        while (count > 0 && queue.isNotEmpty()) {
            val node = queue.peek()
            while (count >= node) {
                resultStr.append(map[node])
                count -= node
            }
            queue.poll()
        }
//        println("$resultStr") use for print result
        return resultStr.toString()
    }
}

fun main() {
    val solution = IntRoman()
    solution.intToRoman(3999)
    solution.intToRoman(10)
    solution.intToRoman(9)
    solution.intToRoman(4)
    solution.intToRoman(3)
    solution.intToRoman(1)
    solution.intToRoman(0)
}