class SubSets78 {

    val indexMap = mutableMapOf<Int,Int>()
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())
        if (nums.isEmpty()) {
            return result
        }
        for (i in nums.indices) {
            indexMap[nums[i]] = i
        }
        var preResult = listOf(emptyList<Int>())
        for (count in 0 until nums.size-1) {
            preResult = subSetNumberN1(preResult, nums, result)
        }
        result.add(nums.toList())
        return result
    }

    fun subSetNumberN1(preResultN: List<List<Int>>, nums: IntArray, result : MutableList<List<Int>>): List<List<Int>> {
        val resultN1 = mutableListOf<List<Int>>()
        for (list in preResultN) {
            val lastIndex = if (list.isEmpty()) -1 else indexMap[list[list.lastIndex]]!!
            for (i in lastIndex + 1 until  nums.size ) {
                val newList = list.toMutableList().apply {
                    add(nums[i])
                }
                result.add(newList)
                resultN1.add(newList)
            }
        }
        return resultN1
    }
}

fun main() {
    val solution = SubSets78()
//    val result = mutableListOf<List<Int>>()
    val list = solution.subsets(intArrayOf(0))
//    val listN = solution.subSetNumberN1(listOf(listOf(1)), setOf(1,2,3), result)
    list.forEach {
        print("[")
        it.forEach { num ->
            print("$num,")
        }
        print("]")
        print(",")
    }

}