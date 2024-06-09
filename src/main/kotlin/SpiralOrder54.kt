import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler

class SpiralOrder54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) {
            return emptyList()
        }
        val result = ArrayList<Int>()
        val m = matrix.size
        val n = matrix[0].size
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = m - 1
        var state = Direction.RIGHT
        var i = 0
        var j = 0
        result.add(matrix[i][j])
        while (left <= right && top <= bottom) {
            when (state) {
                Direction.RIGHT -> {
                    while (j < right) {
                        result.add(matrix[i][j+1])
                        j++
                    }
                    top++
                    state = Direction.DOWN
                }
                Direction.DOWN -> {
                    while (i < bottom) {
                        result.add(matrix[i+1][j])
                        i++
                    }
                    right--
                    state = Direction.LEFT
                }
                Direction.LEFT -> {
                    while (j > left) {
                        result.add(matrix[i][j-1])
                        j--
                    }
                    bottom--
                    state = Direction.UP
                }
                Direction.UP -> {
                    while (i > top) {
                        result.add(matrix[i-1][j])
                        i--
                    }
                    left++
                    state = Direction.RIGHT
                }
            }
        }
        print("result is ")
        for (item in result) {
            print("$item,")
        }
        println()
        return result
    }
}

enum class Direction {
    RIGHT,
    DOWN,
    LEFT,
    UP
}

fun main () {
    val solution = SpiralOrder54()
    solution.spiralOrder(
        arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )
    )
    solution.spiralOrder(
        arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12)
        )
    )
}