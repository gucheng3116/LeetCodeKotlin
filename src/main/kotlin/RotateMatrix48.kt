class RotateMatrix48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty()) {
            return
        }
        val n = matrix.size
        for (i in 0 until n/2) {
            for (j in i until n - 1 -i) {
                var temp = matrix[i][j]
                matrix[i][j] = matrix[n-1-j][i]
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]
                matrix[j][n-1-i] = temp
            }
        }
//        for (row in matrix) {
//            for (item in row) {
//                print("$item,")
//            }
//            println()
//        }

    }
}

fun main() {
    val solution = RotateMatrix48()
    solution.rotate(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    ))
    solution.rotate(arrayOf(
        intArrayOf(5,1,9,11),
        intArrayOf(2,4,8,10),
        intArrayOf(13,3,6,7),
        intArrayOf(15,14,12,16)
    ))
}