class LenthOfLongestSubString3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashSet<Char>()
        var result = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                if (!set.contains(s[j])) {
                    set.add(s[j])
                } else {
                    result = result.coerceAtLeast(set.size)
                    set.clear()
                    break
                }
            }
        }
        result = result.coerceAtLeast(set.size)
        return result
    }
}

fun main() {
    val solution = LenthOfLongestSubString3()
    println("result is ${solution.lengthOfLongestSubstring("abcabcbb")}")
    println("result is ${solution.lengthOfLongestSubstring("bbbbb")}")
    println("result is ${solution.lengthOfLongestSubstring("pwwkew")}")
    println("result is ${solution.lengthOfLongestSubstring(" ")}")
}