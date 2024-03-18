
fun main() {
    println("aa and a isMatch is ${isMatch("aa","a")}")
    println("aa and a* isMatch is ${isMatch("aa","a*")}")
    println("ab isMatch is ${isMatch("ab",".*")}")
    println("abc remove a is ${"abc".removePrefix("a")}")
}

fun isMatch(s: String, p: String): Boolean {
    val pLength = p.length
//    for (i in 0 until pLength) {
//         if (s[i] == p[i] || p[i] == '*') {
//             s.removePrefix
//         }
//    }
    return true
}