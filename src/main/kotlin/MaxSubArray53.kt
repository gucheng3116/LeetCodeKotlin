class MaxSubArray53 {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (start in nums.indices) {
            var sum = 0
            for (end in start until nums.size) {
                sum += nums[end]
                max = max.coerceAtLeast(sum)
            }
        }
        return max
    }

    fun maxSubArray2(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var fi = 0
        var max = nums[0]
        for (i in nums.indices) {
            fi = nums[i].coerceAtLeast(fi + nums[i])
            max = max.coerceAtLeast(fi)
        }
        return max
    }
}

fun main() {
    val solution = MaxSubArray53()
    var result = solution.maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println("result is $result")
    result = solution.maxSubArray2(intArrayOf(1))
    println("result is $result")
    result = solution.maxSubArray2(intArrayOf(5,4,-1,7,8))
    println("result is $result")
}