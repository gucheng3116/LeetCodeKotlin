class Permute46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val list = arrayListOf<List<Int>>()
        for (item in nums) {
            val prefix = mutableListOf(item)
            val set = nums.toMutableSet()
            set.remove(item)
            searchResult(list, prefix, set)
        }
//        print("origin array is ")
//        nums.forEach {
//            print("$it,")
//        }
//        println()
//        list.forEach {
//            print("[")
//            it.forEach { item ->
//                print("$item,")
//            }
//            print("]")
//            println()
//        }
        return list
    }

    fun searchResult(list:ArrayList<List<Int>>, prefix:List<Int>, keepSet:Set<Int>) {
        if (keepSet.isEmpty()) {
            list.add(prefix)
        }
        for (item in keepSet) {
            val newPrefix = prefix.toMutableList()
            newPrefix.add(item)
            val newSet = keepSet.toMutableSet()
            newSet.remove(item)
            searchResult(list, newPrefix, newSet)
        }
    }
}

fun main() {
    val solution = Permute46()
//    solution.permute(intArrayOf(0,1))
    solution.permute(intArrayOf(1,2,3))
}