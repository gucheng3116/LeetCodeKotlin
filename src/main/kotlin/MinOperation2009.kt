//Question 2009
class MinOperation2009 {
    fun minOperations(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val sortedArray = nums.sorted()
        val countArray = IntArray(nums.size) {
            0
        }
        for (i in sortedArray.indices) {
            for (j in sortedArray.indices) {
                if (sortedArray[j] < sortedArray[i] - i || sortedArray[j] > sortedArray[i] + nums.size - 1 - i) {
                    countArray[i]++
                } else if (j > 0 && sortedArray[j] == sortedArray[j-1]) {
                    countArray[i]++
                }
            }
        }
        var result = countArray[0]
        for (i in countArray.indices) {
            result = result.coerceAtMost(countArray[i])
        }
        println("result is $result")
        return result
    }
}

fun main() {
    val solution = MinOperation2009()
//    solution.minOperations(intArrayOf(4,2,5,3))
//    solution.minOperations(intArrayOf(1, 2, 3, 5, 6))
//    solution.minOperations(intArrayOf(1, 10, 100, 1000))
//    solution.minOperations(intArrayOf(8,5,9,9,8,4))
    // not pass
    solution.minOperations(intArrayOf(10,49,16,22,28,34,35,7))
}