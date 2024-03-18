fun main() {
//    val array = IntArray(3) { n -> n+1 }
    val array3= arrayOf(3,7,4,5)
    val array2 = IntArray(4) {i -> array3[i]}


//    println("array result is ${minScoreTriangulation(array)}")
    println("array2 result is ${minScoreTriangulation(array2)}")


}

//用dp的方法，把大的问题拆分成小的子问题来解决
lateinit var resArray:Array<Array<Int>>
fun minScoreTriangulation(values: IntArray): Int {
    for (i in 0 until values.size) {
        print("${values[i]},")
    }
    val length = values.size
    if (length < 3) {
        return 0
    }
    resArray = Array(length) { Array(length) { -1 } }
    return dfs(values, 0, length - 1)
}

fun dfs(values: IntArray, i: Int, j: Int): Int {
    if (i >= j - 1) {
        resArray[i][j] = 0
    }
    if (i == j - 2) {
        resArray[i][j] =  values[i] * values[i+1] * values[j]
    }
    if (resArray[i][j] != -1) {
        return resArray[i][j]
    }
    for ( k in i+1 until j) {
        println("k is $k, i is $i, j is $j")
        resArray[i][j] =
            if (resArray[i][j] == -1) {
                dfs(values, i, k) + dfs(values, k, j) + values[i] * values[k] * values[j]
            } else {
                resArray[i][j].coerceAtMost(dfs(values, i, k) + dfs(values, k, j) + values[i] * values[j] * values[k])
            }
    }
    return resArray[i][j]
}


