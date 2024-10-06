class CourseSchedule207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) {
            return true
        }
        val map = mutableMapOf<Int, Int>()
        prerequisites.forEach {
            map[it[0]] = it[1]
        }
        val deleteKey = mutableSetOf<Int>()
        while (deleteKey.size < map.size) {
            val visitKey = mutableSetOf<Int>()
            map.forEach {
                if (deleteKey.contains(it.key)) {
                    return@forEach
                }
                visitKey.add(it.key)
                var preCourse = it.value
                while (map.containsKey(preCourse)) {
                    visitKey.add(preCourse)
                    preCourse = map[preCourse]!!
                    if (visitKey.contains(preCourse)) {
                        return false
                    }
                }
                visitKey.forEach {
                    deleteKey.add(it)
                }
                visitKey.clear()
            }
        }
        return true
    }
}

fun main() {
    val solution = CourseSchedule207()
    println("result is ${solution.canFinish(2, arrayOf(intArrayOf(1,0)))}")
    println("result is ${solution.canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1)))}")
    println("result is ${solution.canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(1,2), intArrayOf(0,1)))}")
}