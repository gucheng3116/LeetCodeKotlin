class NumIslands200 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var numberIslands = 0
        val rSize = grid.size
        val cSize = grid[0].size
        for (i in 0 until rSize) {
            for (j in 0 until cSize) {
                val item = grid[i][j]
                if (item == '1') {
                    numberIslands++
                    dfs(grid, i, j)
                }
            }
        }
        return numberIslands
    }

    fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
        if (grid.isEmpty()) {
            return
        }
        if (r < 0 || c < 0) {
            return
        }
        if (grid.size <= r) {
            return
        }
        if (grid[0].size <= c ) {
            return
        }

        if (grid[r][c] == '0') {
            return
        }
        if (grid[r][c] == '1') {
            grid[r][c] = '0'
        }
        dfs(grid, r - 1, c)
        dfs(grid, r + 1, c)
        dfs(grid, r, c - 1)
        dfs(grid, r, c + 1)
    }
}

fun main() {
    val solution = NumIslands200()
    val result = solution.numIslands(
        arrayOf(
            charArrayOf('1', '1','1', '1','1'),
            charArrayOf('1','1','0','1','0'),
            charArrayOf('1','1','0','0','0'),
            charArrayOf('0','0','0','0','0')
        )
    )
    println("result is $result")
}