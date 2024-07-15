class LRUCache146(capacity: Int) {
    // LinkedHashMap for LRU
    val linkedHashMap = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
          return  size > capacity
        }
    }
    fun get(key: Int): Int {
        return linkedHashMap[key]?:-1
    }

    fun put(key: Int, value: Int) {

        linkedHashMap[key] = value
    }
}

fun main() {
    val cache = LRUCache146(3)
    cache.put(0, 0)
    cache.put(1, 1)
    cache.put(2, 2)
    for (entry in cache.linkedHashMap.entries) {
        print("${entry.value},")
    }
    cache.put(3, 3)
    for (entry in cache.linkedHashMap.entries) {
        print("${entry.value},")
    }
}