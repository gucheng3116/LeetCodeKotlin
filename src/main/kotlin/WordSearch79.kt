class WordSearch79 {

    private var m:Int = 0
    private var n:Int = 0
    private var lastIndex:Int = 0
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty()) {
            return false
        }
        if (word.isEmpty()) {
            return true
        }
        m = board.size
        n = board[0].size
        lastIndex = m * n - 1
        for (i in 0..lastIndex) {
            var result = backTrack(emptySet(), "", i, 0,board, word)
            if (result) {
                println("search word: $word ,result is true")
                return true
            }
        }
        println("search word: $word ,result is false")
        return false
    }

    private fun backTrack(
        usedIndexes: Set<Int>,
        currentString: String,
        candidateBoardIndex: Int,
        currentStringIndex:Int,
        board: Array<CharArray>,
        word: String
    ) : Boolean {
        if (currentStringIndex == word.length && currentString == word) {
            return true
        }
        if (usedIndexes.contains(candidateBoardIndex)) {
            return false
        }
//        if (candidateBoardIndex < 0 || candidateBoardIndex > lastIndex) {
//            return false
//        }

        val row = candidateBoardIndex / n
        val col = candidateBoardIndex % n
        var result = false
        if (board[row][col] == word[currentString.length]) {
            val string = "$currentString${board[row][col]}"
            val newSet = usedIndexes.toMutableSet().apply {
                add(candidateBoardIndex)
            }
            if (string.length == word.length) {
                return true
            }
            //find left
            if (col > 0) {
                result = result || backTrack(newSet, string, candidateBoardIndex - 1, currentStringIndex + 1,board, word)
                if (result) {
                    return true
                }
            }
            if (row > 0) {
                //find up
                result = result || backTrack(newSet, string, candidateBoardIndex - n, currentStringIndex + 1,board, word)
                if (result) {
                    return true
                }
            }
            //find right
            if (col < n-1) {
                result = result || backTrack(newSet, string, candidateBoardIndex + 1, currentStringIndex + 1,board, word)
                if (result) {
                    return true
                }
            }
            if (row + 1 < m) {
                //find down
                result = result || backTrack(newSet, string, candidateBoardIndex + n, currentStringIndex + 1,board, word)
            }
        }
        return result
    }
}

fun main() {
    val solution = WordSearch79()
    solution.exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        ), "ABCCED"
    )

    solution.exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        ), "ABCB"
    )

    solution.exist(
        arrayOf(
           charArrayOf('a')
        ), "a"
    )

    solution.exist(
        arrayOf(
            charArrayOf('a', 'b'),
            charArrayOf('c', 'd')
        ), "abcd"
    )
}