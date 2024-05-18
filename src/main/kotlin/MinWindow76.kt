//class MinWindow76 {
//    fun minWindow(s: String, t: String): String {
//        val tCharMap = HashMap<Char, Int>()
//        t.forEach {
//            tCharMap[it] = (tCharMap[it] ?: 0) + 1
//        }
//        val sCharMap = HashMap<Char, Int>()
//        var l = 0
//        var r = 0
//        while (l <= r && r < s.length) {
//            if (!tCharMap.contains(s[l])) {
//                l++
//                r++
//            } else {
//                sCharMap[s[l]] = 1
//            }
//
//        }
//        var state = 0 //0 init, 1 l is found,to find 2, 3:shrink left 4.
//
//        val stringBuilder = StringBuilder()
//        var minLength = 0
//        var minString = ""
//        for (i in 0 until s.length) {
//            if (stringBuilder.isEmpty() && !tCharMap.contains(s[i])) {
//                continue
//            } else if (stringBuilder.isEmpty() && tCharMap.contains(s[i])) {
//                stringBuilder.append(s[i])
//                sCharMap[s[i]] = 1
//                state = 1
//
//            }
//            if (containsStringMap(tCharMap, sCharMap)) {
//                state = 2
//                if (i -l + 1 < minLength) {
//                    minLength = i - l + 1
//
//                }
//
//                // shrink left
//                // when contains, update minString and minLength
//                // when not contains, extend r
//
//            }
//        }
//    }
//
//    fun containsStringMap(tMap: Map<Char, Int>, sMap: Map<Char, Int>) : Boolean {
//
//    }
//}
// not complete