class TwoSum1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val delta = target - nums[i]
            if (map[delta] != null) {
                return intArrayOf(map[delta]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf(0,1)
    }
}

fun main() {
    val solution = TwoSum1()
    var result = solution.twoSum(intArrayOf(2,7,11,15), 9)
    println()
    result.forEach {
        print("$it,")
    }
    result = solution.twoSum(intArrayOf(3,2,4), 6)
    println()
    result.forEach {
        print("$it,")
    }
}