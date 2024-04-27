class MaxProfit121 {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        val size = prices.size
        for (i in size - 1 downTo 1) {
            val sell = prices[i]
            for (j in i -1 downTo 0) {
                val buy = prices[j]
                profit = profit.coerceAtLeast(sell - buy)
            }
        }
        // overtime
        return profit
    }

    fun maxProfit2(prices: IntArray):Int {
        var min = Int.MAX_VALUE
        val size = prices.size - 1
        var profit = 0
        for (i in 0..size) {
          if (prices[i] < min) {
              min = prices[i]
          } else if (prices[i] - min > profit) {
              profit = prices[i] - min
          }
        }
        return profit
    }
}

fun main() {
    val solution = MaxProfit121()
    val profit = solution.maxProfit2(intArrayOf(7,1,5,3,6,4))
    println("profit is $profit")
}