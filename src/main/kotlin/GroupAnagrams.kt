//Question 49
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
//        val list = mutableListOf()
//        var list = mutableListOf<mutable<String>>(10) {
//            listOf("")
//        }
        val list = mutableListOf<MutableList<String>>()
        if (strs.isEmpty()) {
            return list
        }
        val map = HashMap<String, MutableList<String>>()
        for (i in strs.indices) {
            val sorted = strs[i].toCharArray().sorted().joinToString("")
            if (map.contains(sorted)) {
                map[sorted]?.add(strs[i])
            } else {
                map[sorted] = mutableListOf(strs[i])
            }
        }
        map.forEach {
            list.add(it.value)
        }
//        println(list)
        return list
    }
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val groupAnagrams = GroupAnagrams()
    groupAnagrams.groupAnagrams(strs)
    val array2 = arrayOf("")
    groupAnagrams.groupAnagrams(array2)
    val array3 = arrayOf("a")
    groupAnagrams.groupAnagrams(array3)
}
//
//本道题学习了字符串的toCharArray，sorted和joinToString方法的使用。
//学习了新建二维字符串对象val list = mutableListOf<MutableList<String>>()。
//This question learned about the use of the toCharArray, sorted, and joinToString methods for strings.
//The previous question learned about creating a two-dimensional string object with val list = mutableListOf<MutableList<String>>().