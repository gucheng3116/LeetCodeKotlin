fun longestCommonPrefix(strs: Array<String>): String {
    var minLength = strs[0].length
    strs.forEach {
        if (it.length < minLength) {
            minLength = it.length
        }
    }
    if (strs.isEmpty()) {
        return ""
    }
    if (strs.size == 1) {
        return strs[0]
    }
    for (i in 0 until minLength) {
        var a = strs[0][i]
        for (j in 1 until strs.size) {
            if (a == strs[j][i]) {
            } else {
                return strs[0].substring(0, i)
            }
        }
    }
    return strs[0].substring(0,minLength)
}

fun main() {
    val strs1 = arrayOf("flower", "flow", "flight")

    println("strs1 common prefix is ${longestCommonPrefix(strs1)}")

    val strs2 = arrayOf("dog","racecar","car")

    println("strs2 common prefix is ${longestCommonPrefix(strs2)}")

}

