class RotateArray189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.isEmpty()) {
            return
        }
        var k2 = k
        if (k > nums.size) {
            k2 %= nums.size
        }
        val newArray = IntArray(nums.size)
        for (i in nums.indices) {
            newArray[(i + k2) % nums.size] = nums[i]
        }
        for (i in nums.indices) {
            nums[i] = newArray[i]
//            print("${nums[i]},")
        }
//        println()
    }
}

fun main() {
    val solution = RotateArray189()
    solution.rotate(intArrayOf(1,2,3,4,5,6,7), 1)
    solution.rotate(intArrayOf(1,2,3,4,5,6,7), 2)
    solution.rotate(intArrayOf(-1, -100, 3, 99), 2)
}