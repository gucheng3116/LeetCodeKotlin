class Rainwater42 {
    fun trap(height:IntArray):Int {
        if (height.size < 3) {
            return 0
        }
        val leftArray = IntArray(height.size) { 0 }
        val rightArray = IntArray(height.size) { 0 }
        for (i in 1 until height.size) {
            leftArray[i] = leftArray[i-1].coerceAtLeast(height[i-1])
        }
        for (j in height.size - 2 downTo 0) {
            rightArray[j] = rightArray[j+1].coerceAtLeast(height[j+1])
        }
        var result = 0
        for (i in 1..height.size-2) {
            result += (leftArray[i].coerceAtMost(rightArray[i]) - height[i]).coerceAtLeast(0)
        }
        return result
    }
}

fun main() {
    val solution = Rainwater42()
    println("result is ${solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))}")
    println("result is ${solution.trap(intArrayOf(4, 2, 0, 3, 2, 5))}")
}