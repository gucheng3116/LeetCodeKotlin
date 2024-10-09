class Trie208 {
    val set = mutableSetOf<String>()
    fun insert(word: String) {
        set.add(word)
    }

    fun search(word: String): Boolean {
        return set.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        set.forEach {
            if (it.startsWith(prefix)) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val solution = Trie208()
    solution.insert("apple")

}