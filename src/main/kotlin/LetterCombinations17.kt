class LetterCombinations17 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }
        val map = mutableMapOf<Char, String>()
        map['2'] = "abc"
        map['3'] = "def"
        map['4'] = "ghi"
        map['5'] = "jkl"
        map['6'] = "mno"
        map['7'] = "pqrs"
        map['8'] = "tuv"
        map['9'] = "wxyz"
        val combinations = ArrayList<String>()
        backTrack(combinations, 0, StringBuilder(""), map, digits)
        return combinations
    }

    private fun backTrack(
        combinations: ArrayList<String>,
        index: Int,
        combination: StringBuilder,
        map: Map<Char, String>,
        digits: String
    ) {
        if (index == digits.length) {
            combinations.add(combination.toString())
        } else {
            val char = digits[index]
            val mapString = map[char]
            if (mapString.isNullOrEmpty()) {
                return
            }
            val list = mapString.toList()
            for (item in list) {
                combination.append(item)
                backTrack(combinations, index + 1, combination, map, digits)
                combination.deleteCharAt(index)
            }
        }
    }
}

fun main() {
    val solution = LetterCombinations17()
    solution.letterCombinations("23")
    solution.letterCombinations("2")
    solution.letterCombinations("")
}