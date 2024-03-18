fun main() {
    print(letterCombinations("2"))
}

fun letterCombinations(digits: String): List<String> {
    var map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    val length = digits.length
    if (length == 0) {
        return emptyList()
    }
    val list = mutableListOf<String>()
    var size = 1
    for (i in 0 until length) {
        size *= map[digits[i]]!!.length
    }

    for (i in 0 until size) {
        list.add("")
    }
    println("size is $size, list size is ${list.size}")
    var countList = mutableListOf<Int>()
    for (i in 0 until length) {
        countList.add(0)
    }
    for (i in 0 until size) {
        for (j in 0 until length) {
            list[i] = list[i] + map[digits[j]]!![countList[j]]
            println("i is $i,j is $j, map[digits[j]] is ${map[digits[j]]}, countList[j] is ${countList[j]}")
            break
        }
        countList[length - 1] += 1
        for (i in length - 1 downTo 1) {
            if (countList[i] == map[digits[i]]!!.length) {
                countList[i] = 0
                countList[i - 1] += 1
            }
        }
    }

    return list
}



