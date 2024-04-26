class SearchInsert35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.size == 0) {
            return 0
        }
        var i = 0
        var j = nums.size - 1
        var mid = (i + j) / 2
        while (i < j) {
            when {
                target == nums[mid] -> return mid
                target < nums[mid] -> {
                    j = mid - 1
                    mid = (i + j) / 2
                }

                else -> {
                    i = mid + 1
                    mid = (i + j) / 2
                }
            }
        }
        return when {
            target <= nums[i] -> i
            else -> i + 1
        }
    }
}

fun main() {
  val solution = SearchInsert35()
    println("position is ${solution.searchInsert(intArrayOf(1, 3, 5, 6), 5)}")
    println("position is ${solution.searchInsert(intArrayOf(1, 3, 5, 6), 2)}")
    println("position is ${solution.searchInsert(intArrayOf(1, 3, 5, 6), 7)}")
}