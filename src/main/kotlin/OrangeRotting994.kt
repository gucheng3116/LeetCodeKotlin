import java.util.*

class OrangeRotting994 {
    val queue = LinkedList<Int>()
    val depth = mutableMapOf<Int, Int>()
    var depthMax = 0
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        if (grid[0].isEmpty()) {
            return 0
        }
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) {
                    val number = i * n + j
                    queue.add(number)
                    depth[number] = 0
                }
            }
        }
        while (queue.isNotEmpty()) {
            val item = queue.remove()
            val row = item / n
            val col = item % n
            val currentDepth = depth[item] ?: 0
            if (row - 1 >= 0) {
                visitItem(row - 1, col, grid, currentDepth)
            }
            if (row + 1 < m) {
                visitItem(row + 1, col, grid, currentDepth)
            }
            if (col - 1 >= 0) {
                visitItem(row, col - 1, grid, currentDepth)
            }
            if (col + 1 < n) {
                visitItem(row, col + 1, grid, currentDepth)
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }
        return depthMax
    }

    fun visitItem(row: Int, col: Int, grid: Array<IntArray>, depthCurrent:Int) {
        if (grid[row][col] != 1) {
            return
        }
        val m = grid.size
        val n = grid[0].size
        grid[row][col] = 2
        val number = row * n + col
        depth[number] = depthCurrent + 1
        depthMax = depthMax.coerceAtLeast(depthCurrent + 1)
        queue.add(number)
    }
}

fun main() {
    val solution = OrangeRotting994()
    val result  = solution.orangesRotting(
        arrayOf(
            intArrayOf(1),
            intArrayOf(2)
        )
    )
    println("result is $result")
}
