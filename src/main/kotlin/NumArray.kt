// LeetCode 303
class NumArray(val nums: IntArray) {
    fun sumRange(left: Int, right: Int): Int {
        if (left < 0) {
            return -1
        }
        if (right > nums.size) {
            return -1
        }

        var count = 0
        for (i in left..right) {
            count += nums[i]
        }
        return count
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */

fun main() {
    val nums = intArrayOf(-2, 0, 3,-5,2,-1)
    val numArray = NumArray(nums)
    println("count is ${numArray.sumRange(0,5)}")
}