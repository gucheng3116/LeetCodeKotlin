class SetZeroes73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty()) {
            return
        }
        val rows = ArrayList<Int>()
        val columns = ArrayList<Int>()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    rows.add(i)
                    columns.add(j)
                }
            }
        }
        for (row in rows) {
            for (j in matrix[row].indices) {
                matrix[row][j] = 0
            }
        }
        for (column in columns) {
            for (i in matrix.indices) {
                matrix[i][column] = 0
            }
        }
//        for (i in matrix.indices) {
//            for (j in matrix[i].indices) {
//                print("${matrix[i][j]},")
//            }
//            println()
//        }
    }
}

fun main() {
    val solution = SetZeroes73()
    solution.setZeroes(arrayOf(
        intArrayOf(1,1,1),
        intArrayOf(1,0,1),
        intArrayOf(1,1,1)
    ))
    solution.setZeroes(arrayOf(
        intArrayOf(0,1,2,0),
        intArrayOf(3,4,5,2),
        intArrayOf(1,3,1,5)
    ))
}