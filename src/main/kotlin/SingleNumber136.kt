class SingleNumber136 {
    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            if (set.contains(it)) {
                set.remove(it)
            } else {
                set.add(it)
            }
        }
        println("result is ${set.firstOrNull() ?: 0}")
        return set.firstOrNull() ?: 0
    }
}

fun main() {
    val solution = SingleNumber136()
    solution.singleNumber(intArrayOf(2,2,1))
    solution.singleNumber(intArrayOf(4,1,2,1,2))
    solution.singleNumber(intArrayOf(1))
}