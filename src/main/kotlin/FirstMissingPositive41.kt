import java.util.LinkedHashSet

class FirstMissingPositive41 {
    fun firstMissingPositive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 1
        }
        val set = LinkedHashSet<Int>(nums.size)
        for (i in nums.indices) {
            set.add(i+1)
        }
        for (item in nums) {
            set.remove(item)
        }
//        val result = if (set.isNotEmpty()) {
//            set.first()
//        } else {
//            nums.size + 1
//        }
//        println("result is $result")
        return if (set.isNotEmpty()) {
            set.first()
        } else {
            nums.size + 1
        }

    }
}

fun main() {
    val solution = FirstMissingPositive41()
    solution.firstMissingPositive(intArrayOf(1, 2, 0))
    solution.firstMissingPositive(intArrayOf(3,4,-1,1))
    solution.firstMissingPositive(intArrayOf(7,8,9,11,12))
}