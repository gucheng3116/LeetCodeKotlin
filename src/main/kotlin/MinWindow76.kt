class MinWindow76 {
    fun minWindow(s: String, t: String): String {
        val tCharMap = HashMap<Char, Int>()
        t.forEach {
            tCharMap[it] = (tCharMap[it] ?: 0) + 1
        }
        val sCharMap = HashMap<Char, Int>()
        var l = 0
        var r: Int
//        while (r < s.length) {
//            if (!tCharMap.contains(s[l])) {
//                l++
//                r++
//            } else {
//                sCharMap[s[l]] = 1
//            }
//
//        }
        var state = 0 //0 init, 1 l is found,to find 2, 3:shrink left 4.

        var minLength = Int.MAX_VALUE
        var minString = ""
        for (i in s.indices) {
            if (state == 0 && !tCharMap.contains(s[i])) {
                continue
            } else if (state == 0 && tCharMap.contains(s[i])) {
                l = i
                sCharMap[s[i]] = 1
                state = 1 // find first l
                if (containsStringMap(tCharMap, sCharMap, t.length, 1)) {
                    minString = s.substring(i, i + 1)
                }
            } else if (state == 1) {
                sCharMap[s[i]] = (sCharMap[s[i]] ?: 0) + 1
                if (containsStringMap(tCharMap, sCharMap, t.length, i - l + 1)) {
                    r = i
                    state = 2 //found
                    if (i - l + 1 < minLength) {
                        minLength = i - l + 1
                        minString = s.substring(l, r + 1)
                    }

                    // shrink left
                    // when contains, update minString and minLength
                    // when not contains, extend r
                    while (l < r) {
                        sCharMap[s[l]] = (sCharMap[s[l]]?:0) - 1
                        l++
                        if (containsStringMap(tCharMap, sCharMap, t.length, r-l+1)) {
                            if (r-l+1 < minLength) {
                                minLength = r-l+1
                                minString = s.substring(l, r + 1)
                            }
                        } else {
                            state = 1
                            break
                        }
                    }
                }
            } else {
                println("state is $state")
            }
//            when {
//                state == 0 && !tCharMap.contains(s[i]) -> continue
//                state == 0 && tCharMap.contains(s[i])
//            }

        }
        println("minString is $minString")
        return minString
    }

    private fun containsStringMap(
        tMap: Map<Char, Int>,
        sMap: Map<Char, Int>,
        tLength: Int,
        subStringLength: Int
    ): Boolean {
        if (subStringLength < tLength) {
            return false
        }
        tMap.forEach {
            if (!sMap.contains(it.key)) {
                return false
            }
            if (sMap[it.key]!! < it.value) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solution = MinWindow76()
    solution.minWindow("AD0BEC0DEBANC", "ABC")
    solution.minWindow("a", "a")
    solution.minWindow("a", "aa")
}