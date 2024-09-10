class ClimbStairs70 {
    val map = mutableMapOf(1 to 1, 2 to 2)
    fun climbStairs(n: Int): Int {
        if (map.contains(n)) {
            return map[n]!!
        }
        if (n < 1) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        val result = climbStairs(n - 1) + climbStairs(n - 2)
        map[n] = result
        return result
    }
}

fun main() {
    val solution = ClimbStairs70()
    solution.climbStairs(2)
    solution.climbStairs(3)
    solution.climbStairs(4)
}