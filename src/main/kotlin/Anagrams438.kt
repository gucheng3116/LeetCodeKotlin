
class Anagrams438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.isEmpty() || p.isEmpty()) {
            return emptyList()
        }
        val result = ArrayList<Int>()
        val sortedSet = p.toSortedSet()
        val sortedP = p.toCharArray().sorted().joinToString("")
        val size = p.length
        for (i in 0 .. s.length - size) {
            val firstChar = s.elementAt(i)
            if (!sortedSet.contains(firstChar)) {
                continue
            }
            val subString = s.subSequence(i, i + size).toString()
            if (isAnagrams(subString, sortedP)) {
                result.add(i)
            }
        }
        return result
    }
    private fun isAnagrams(s: String, p: String): Boolean {
        if (s.isEmpty() || p.isEmpty()) {
            return false
        }
        val sortedS = s.toCharArray().sorted().joinToString("")
        return sortedS == p
    }
}

fun main() {
    val solution = Anagrams438()

    var result = solution.findAnagrams("cbaebabacd", "abc")
    result.forEach {
        print("$it,")
    }
    result = solution.findAnagrams("abab", "ab")
    println()
    result.forEach {
        print("$it,")
    }
}

// toSortedSet
// joinToString
// toCharArray