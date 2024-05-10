class SubArraySum560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var subArraySum = 0
        if (nums.isEmpty()) {
            return 0
        }
        var left = 0
        var right = 0
        var sum = nums[0]
        while (left < nums.size && (right < nums.size)) {
            when {
                sum < k -> {
                    right++
                    if (right < nums.size){
                        sum += nums[right]
                    }
                }
                sum == k -> {
                    subArraySum++
                    sum -= nums[left++]
                }
                else -> {
                    sum -= nums[left++]
                }
            }
        }


        return subArraySum
    }

    fun subarraySum2(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in 0 until nums.size) {
            var sum = 0
            for (end in start until nums.size) {
                sum += nums[end]
                if (sum == k) {
                    count++
                }
            }
        }
        return count
    }
}

fun main() {
    val solution = SubArraySum560()
    var result = solution.subarraySum2(intArrayOf(1,1,1), 2)
    println("result is $result")
    result = solution.subarraySum2(intArrayOf(1,2,3), 3)
    println("result is $result")
}