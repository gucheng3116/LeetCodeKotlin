//Question 509
class Fib509 {
    fun fib(n:Int): Int {
        var a = 0
        var b = 1
        if (n == 0) {
            return a
        }
        if (n == 1) {
            return b
        }
        var result = a + b
        for (i in 2 .. n) {
            result = a + b
            a = b
            b = result
        }
        return result
    }
}

fun main() {
    val solution = Fib509()
    println("fib(2) is ${solution.fib(2)}")
    println("fib(3) is ${solution.fib(3)}")
    println("fib(4) is ${solution.fib(4)}")
    println("fib(5) is ${solution.fib(5)}")
}