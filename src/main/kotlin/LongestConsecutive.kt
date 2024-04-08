// Question 128
class LongestConsecutive {
    fun longestConsecutive(nums:IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        val sortedArray = nums.sorted()
        val map = HashMap<Int, Int>()
        var key = sortedArray[0]
        map[key] = 1
        for (i in 1 until sortedArray.size) {
            if (sortedArray[i] - sortedArray[i-1] == 1) {
                map[key] = map[key]!!.plus(1)
            } else if (sortedArray[i] - sortedArray[i-1] == 0) {
//                continue
            } else {
                key = sortedArray[i]
                map[key] = 1
            }
        }
        var num = 1
        map.forEach {
            num = num.coerceAtLeast(it.value)
        }
        println("num is $num")
        return num
    }
}

fun main() {
    val longestConsecutive = LongestConsecutive()
    longestConsecutive.longestConsecutive(intArrayOf(0,1,0,2))
//    longestConsecutive.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1))
    //sorted和sortedArray的区别是？
//    longestConsecutive.longestConsecutive(intArrayOf(9,1,4,7,3,-1,0,5,8,-1,6))
    //场景较多，要考虑数字重复的场景
}