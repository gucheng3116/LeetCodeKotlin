class SearchMatrix240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        val n = matrix.size.coerceAtMost(matrix[0].size)
        var currentN = 0
        var state = 0
        for (i in 0 until n) {
            when {
                matrix[i][i] < target -> {
                    currentN = i
                    state = 1
                    continue
                }

                matrix[i][i] == target -> {
                    return true
                }

                matrix[i][i] > target -> {
                    currentN = i
                    state = 2
                    break
                }
            }
        }
        if (state == 1) {
            val row = matrix.size
            val column = matrix[0].size
            if (row == column) {
                return false
            }
            if (row > column) {
                for (i in n until row) {
                    if (matrix[i][column-1] > target) {
                        currentN = i
                        state = 2
                        break
                    } else if (matrix[i][column-1] == target) {
                        return true
                    }
                }
                if (state == 1) {
                    return false
                } else {
                    for (i in currentN until row) {
                        for (j in column - 2 downTo 0) {
                            if (matrix[i][j] == target) {
                                return true
                            }
                            if (matrix[i][j] <  target) {
                                break
                            }
                        }
                    }
                    return false
                }
            } else {
                var currentColumn = n - 1
                for (j in n until column) {
                    if (matrix[row - 1][j] > target) {
                        currentColumn = j
                        state = 2
                        break
                    } else if (matrix[row - 1][j] == target) {
                        return true
                    }
                }
                if (state == 1) {
                    return false
                } else {
                    for (j in currentColumn until column) {
                        for (i in row - 2 downTo 0) {
                            if (matrix[i][j] == target) {
                                return true
                            }
                            if (matrix[i][j] < target) {
                                break
                            }
                        }
                    }
                    return false
                }
            }
        } else {
            if (currentN == 0) {
                return false
            }
            for (j in currentN until matrix[0].size) {
                for (i in currentN - 1 downTo 0) {
                    if (matrix[i][j] == target) {
                        return true
                    }
                    if (matrix[i][j] < target) {
                        break
                    }
                }
            }
            for (i in currentN until matrix.size) {
                for (j in currentN - 1 downTo 0) {
                    if (matrix[i][j] == target) {
                        return true
                    }
                    if (matrix[i][j] < target) {
                        break
                    }
                }
            }
            return false
        }
    }
}

fun main() {
    val solution = SearchMatrix240()
    var result:Boolean
//    result = solution.searchMatrix(
//        arrayOf(
//            intArrayOf(1,4,7,11,15),
//            intArrayOf(2,5,8,12,19),
//            intArrayOf(3,6,9,16,22),
//            intArrayOf(10,13,14,17,24),
//            intArrayOf(18,21,23,26,30)
//        ),
//        5
//    )
//    println("result is $result")
//    result = solution.searchMatrix(
//        arrayOf(
//            intArrayOf(1,4,7,11,15),
//            intArrayOf(2,5,8,12,19),
//            intArrayOf(3,6,9,16,22),
//            intArrayOf(10,13,14,17,24),
//            intArrayOf(18,21,23,26,30)
//        ),
//        20
//    )
//    println("result is $result")
//     result = solution.searchMatrix(
//        arrayOf(
//            intArrayOf(-1,3)
//        ),
//        3
//    )
//    println("result is $result")
//    result = solution.searchMatrix(
//        arrayOf(
//            intArrayOf(1,2,3,4,5),
//            intArrayOf(6,7,8,9,10),
//            intArrayOf(11,12,13,14,15),
//            intArrayOf(16,17,18,19,20),
//            intArrayOf(21,22,23,24,25)
//        ),
//        15
//    )
    result = solution.searchMatrix(
        arrayOf(
            intArrayOf(1,4,7,11,15),
            intArrayOf(2,5,8,12,19),
            intArrayOf(3,6,9,16,22)
        ),
        15
    )
    println("result is $result")
}