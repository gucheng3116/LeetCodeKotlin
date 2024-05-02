class ThreeSum15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortArray = nums.sorted()
        val result = arrayListOf<List<Int>>()
        val size = sortArray.size
        for (i in 0..size-3) {
            if (i != 0 && sortArray[i] == sortArray[i-1]) {
                continue
            }
            val num0 = sortArray[i]
            if (num0 + sortArray[size - 2] + sortArray[size - 1] < 0) {
                continue
            }
            var k = size - 1
            for (j in i + 1..size - 2) {
                if (j != i + 1 && sortArray[j] == sortArray[j - 1]) {
                    continue
                }
                val num1 = sortArray[j]
                while (k >= j+1) {
                    if (k != size - 1 && sortArray[k + 1] == sortArray[k]) {
                        k--
                        continue
                    }
                    val num2 = sortArray[k]
                    if (num0 + num1 + num2 < 0) {
                        break
                    } else if (num0 + num1 + num2 == 0) {
                        result.add(listOf(num0, num1, num2))
                    }
                    k--
                }
            }
        }
        return result
    }

//    private fun check(a: Int, b: Int, c: Int, list: ArrayList<List<Int>>) {
//        if (a + b + c == 0) {
//            list.add(listOf(a, b, c))
//        }
//    }
}

fun main() {
    val solution = ThreeSum15()
    var result = solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    result.forEach { list ->
        println()
        list.forEach {
            print("$it,")
        }
    }
    result = solution.threeSum(intArrayOf(0, 1, 1))
    result.forEach { list ->
        println()
        list.forEach {
            print("$it,")
        }
    }
    result = solution.threeSum(intArrayOf(0, 0, 0))
    result.forEach { list ->
        println()
        list.forEach {
            print("$it,")
        }
    }
}