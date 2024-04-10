//Question 283
class MoveZero283 {
    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty()) {
            return
        }
        var lastNonZeroIndex = nums.size - 1
        for (i in lastNonZeroIndex downTo 0) {
            if (nums[lastNonZeroIndex] == 0) {
                lastNonZeroIndex--
            } else {
                break
            }
        }
        var i = 0
        while (i <= lastNonZeroIndex) {
            if (nums[i] == 0) {
                for (j in i until lastNonZeroIndex) {
                    nums[j] = nums[j+1]
                    nums[j+1] = 0
                }
                lastNonZeroIndex--
            }
            if (nums[i] != 0) {
                i++
            }
        }
//        for (i in 0..lastNonZeroIndex) {
//            if (nums[i] == 0) {
//                for (j in i until lastNonZeroIndex) {
//                    nums[j] = nums[j+1]
//                    nums[j+1] = 0
//                }
//                lastNonZeroIndex--
//            }
//        }
        nums.forEach {
            print("$it,")
        }
        println("")
    }
}

fun main() {
    val solution = MoveZero283()
//    solution.moveZeroes(intArrayOf(0,1,0,3,12))
//    solution.moveZeroes(intArrayOf(0))
    solution.moveZeroes(intArrayOf(0,0,1))
}