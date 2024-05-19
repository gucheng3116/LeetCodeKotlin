class MergeArray56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size < 2) {
            return intervals
        }
        intervals.sortWith(
            Comparator { o1, o2 ->
                o1[0] - o2[0]
            }
        )
        val arrayList = ArrayList<IntArray>()
        for (element in intervals) {
            addArray(arrayList, element)
        }
//        arrayList.forEach {
//            print("[${it[0]}, ${it[1]}], ")
//        }
//        println()
        return arrayList.toTypedArray()
    }

    private fun addArray(originArray: ArrayList<IntArray>, newArray: IntArray) {
        if (originArray.isEmpty()) {
            originArray.add(newArray)
            return
        }
        val lastArray = originArray.last()
        if (newArray[0] <= lastArray[1]) {
            val newLastArray = IntArray(2)
            newLastArray[0] = lastArray[0]
            newLastArray[1] = newArray[1].coerceAtLeast(lastArray[1])
            originArray.removeLast()
            originArray.add(newLastArray)
        } else {
            originArray.add(newArray)
        }
    }
}

fun main() {
    val solution = MergeArray56()
    solution.merge(arrayOf(intArrayOf(1,3), intArrayOf(2,5), intArrayOf(1,2)))
    solution.merge(arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18)))
}