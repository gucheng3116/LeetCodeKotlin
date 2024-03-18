
fun main() {
   println("12 and 6 factors is ${commonFactors(12,6)}")
}

fun commonFactors(a: Int, b: Int): Int {
    val minValue = a.coerceAtMost(b)
    var count = 0
    for (i in 1..minValue) {
        if (a % i == 0 && b % i == 0) {
            count++
        }
    }
    return count
}