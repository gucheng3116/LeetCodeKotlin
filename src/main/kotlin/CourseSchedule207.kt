class CourseSchedule207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (numCourses <= 0 || prerequisites.size <= 1) {
            return true
        }
        val degree = IntArray(numCourses) {
            0
        }
        val lastArray = Array(numCourses) {
            mutableListOf<Int>()
        }
        prerequisites.forEach {
            lastArray[it[1]].add(it[0])
            degree[it[0]]++
        }
        var count = 0
        while (count < numCourses) {
            var deleteItems = 0
            for (i in degree.indices) {
                if (degree[i] == 0) {
                    count++
                    degree[i]--
                    lastArray[i].forEach {
                        degree[it]--
                    }
                    deleteItems++
                }
            }
            if (deleteItems == 0) {
                break
            }
        }
        return count == numCourses
    }
}

fun main() {
//    [[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
    val solution = CourseSchedule207()
    val array = arrayOf(intArrayOf(0,10),  intArrayOf(3,18), intArrayOf(5,5), intArrayOf(6,11), intArrayOf(11,14),
        intArrayOf(13,1), intArrayOf(15,1), intArrayOf(17,4)
    )
    println("result is ${solution.canFinish(2, arrayOf(intArrayOf(1,0)))}")
    println("result is ${solution.canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1)))}")
    println("result is ${solution.canFinish(3, arrayOf(intArrayOf(1,0), intArrayOf(1,2), intArrayOf(0,1)))}")
    println("result is ${solution.canFinish(20, array)}")
}