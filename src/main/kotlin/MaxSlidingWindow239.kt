import java.util.SortedMap
import java.util.SortedSet

class MaxSlidingWindow239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = ArrayList<Int>()
        for (i in 0 .. nums.size - k) {
            var max = Int.MIN_VALUE
            for (j in i until i+k) {
                max = max.coerceAtLeast(nums[j])
            }
            result.add(max)
        }
        return result.toIntArray()
    }

    fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int,Int>()
        for (i in 0 until k) {
            val count = map[nums[i]] ?: 0
            map[nums[i]] = count + 1
        }
        val sortedMap = map.toSortedMap()

        val result = ArrayList<Int>()
        result.add(sortedMap.lastKey())
        var start = 0
        var end = k
        while (end < nums.size) {
            val endCount = sortedMap[nums[end]] ?: 0
            sortedMap[nums[end]] = endCount + 1
            val startCount = sortedMap[nums[start]] ?: 0
            if (startCount == 1) {
                sortedMap.remove(nums[start])
            } else {
                sortedMap[nums[start]] = startCount - 1
            }
            result.add(sortedMap.lastKey())
            end++
            start++
        }
        return result.toIntArray()
    }
}

fun main() {
    val solution = MaxSlidingWindow239()
    var result = solution.maxSlidingWindow2(intArrayOf(-7,-8,7,5,7,1,6,0), 4)
    result.forEach {
        print("$it,")
    }
}