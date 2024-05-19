class MinWindow76 {
    fun minWindow(s: String, t: String): String {
        val tCharMap = HashMap<Char, Int>()
        t.forEach {
            tCharMap[it] = (tCharMap[it] ?: 0) + 1
        }
        val sCharMap = HashMap<Char, Int>()
        var l = 0
        var r = 0
        while (l <= r && r < s.length) {
            if (!tCharMap.contains(s[l])) {
                l++
                r++
            } else {
                sCharMap[s[l]] = 1
            }

        }
        var state = 0 //0 init, 1 l is found,to find 2, 3:shrink left 4.

        val stringBuilder = StringBuilder()
        var minLength = Int.MAX_VALUE
        var minString = ""
        for (i in 0 until s.length) {
            if (stringBuilder.isEmpty() && !tCharMap.contains(s[i])) {
                continue
            } else if (stringBuilder.isEmpty() && tCharMap.contains(s[i])) {
                l = i
                stringBuilder.append(s[i])
                sCharMap[s[i]] = 1
                state = 1 // find first l
//                if (con)
                if (containsStringMap(tCharMap, sCharMap, t.length, 1)) {
                    state = 2
                    if (i - l + 1 < minLength) {
                        minLength = i - l + 1
                        minString = stringBuilder.toString()
                    }

                    // shrink left
                    // when contains, update minString and minLength
                    // when not contains, extend r

                }
            } else {
                if (containsStringMap(tCharMap, sCharMap, t.length, i-l+1)) {
                    state = 2
                    if (i - l + 1 < minLength) {
                        minLength = i - l + 1
                        minString = stringBuilder.toString()
                    }

                    // shrink left
                    // when contains, update minString and minLength
                    // when not contains, extend r

                }
            }

            when {
                stringBuilder.isEmpty() && !tCharMap.contains(s[i]) -> {
                    continue
                }
                stringBuilder.isEmpty() && tCharMap.contains(s[i]) -> {
                    l = i
                    r = l
                    stringBuilder.append(s[i])
                    sCharMap[s[i]] = 1
                    state = 1
                    if (s[i].toString() == t) {
                        return s[i].toString()
                    }
                }
                state == 1 -> {
                    
                }

            }

        }
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
// not complete