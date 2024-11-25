class CombinationSum39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val resultList = ArrayList<List<Int>>()
        backTrack(emptyList(), candidates, resultList, 0 ,0, target)
//        resultList.forEach {
//            println()
//            it.forEach { item->
//                print("$item,")
//            }
//        }
        return resultList
    }

    fun backTrack(combination: List<Int>, candidates: IntArray, resultList: ArrayList<List<Int>>, index: Int, sum:Int, target:Int) {
        if (sum == target) {
            resultList.add(combination)
        }
        if (sum > target) {
            return
        }
        for (i in index until candidates.size) {
            val currentItem = candidates[i]
            val newList = combination.toMutableList().apply {
               add(currentItem)
            }
//            if (index == 3) {
//                println("currentItem is $currentItem, combination size is ${combination.size}, combination:$combination")
//            }
            backTrack(newList, candidates, resultList, i, sum + currentItem, target)
        }
    }
}

fun main() {
    val solution = CombinationSum39()
    solution.combinationSum(intArrayOf(2,3,6,7), 7)
}