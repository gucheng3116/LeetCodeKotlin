class ProductExceptSelf238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return nums
        }
        val result = IntArray(nums.size)
        val left = IntArray(nums.size)
        val right = IntArray(nums.size)
        left[0] = 1
        right[nums.size - 1] = 1
        for (i in 1 until nums.size) {
            left[i] = nums[i - 1] * left[i - 1]
            right[nums.size - i - 1] = right[nums.size - i] * nums[nums.size - i]
        }
        for (i in result.indices) {
            result[i] = left[i] * right[i]
//            print("${result[i]},")
        }
//        println()
        return result
    }
}

fun main() {
    val solution = ProductExceptSelf238()
    solution.productExceptSelf(intArrayOf(1, 2, 3, 4))
    solution.productExceptSelf(intArrayOf(-1, 1, 0, -3,3))
}