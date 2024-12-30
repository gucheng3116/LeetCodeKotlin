class GenerateYang118 {
    fun generate(numRows: Int):List<List<Int>> {
        if (numRows == 0) {
            return emptyList()
        }
        val arrayList = arrayListOf(listOf(1))
        while (arrayList.size < numRows) {
            val row = arrayList.size
            val column = row + 1
            val list = mutableListOf(1)
            for (i in 1 until column - 1) {
                val left = arrayList[row - 1][i-1]
                val right = arrayList[row - 1][i]
                list.add(left + right)
            }
            list.add(1)
            arrayList.add(list)
        }
//        arrayList.forEach { list ->
//            println()
//            list.forEach { item ->
//                print("$item,")
//            }
//        }
        return arrayList
    }
}

fun main() {
    val solution = GenerateYang118()
//    solution.generate(5)
    solution.generate(1)
}