//Question11
class MaxArea {
    fun maxArea(height: IntArray): Int {
        val size = height.size
        var maxArea = 0
        for (i in 0 until size - 1) {
            val h1 = height[i]
            val h2farthest = height[size - 1]
            var area = h1.coerceAtMost(h2farthest) * (size - 1 - i)
            maxArea = maxArea.coerceAtLeast(area)
            for (j in size - 2 downTo i + 1) {
                val h2= height[j]
                if (h2  > h2farthest) {
                    area = h1.coerceAtMost(h2) * (j - i)
                    maxArea = maxArea.coerceAtLeast(area)
                }
            }
        }
        return maxArea
    }

    fun maxArea2(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var maxArea = 0
        var area = 0
        while(i < j) {
            area = height[i].coerceAtMost(height[j])*(j - i)
            if ( area > maxArea) {
                maxArea = area
            }
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return maxArea
    }
}

fun main() {
    val solution = MaxArea()
    println("maxArea is ${solution.maxArea2(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}")
    println("maxArea is ${solution.maxArea2(intArrayOf(1, 1))}")

}