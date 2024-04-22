class CycleList141 {
    fun hasCycle(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode>()
        var p1 = head
        while (p1 != null) {
            if (set.contains(p1)) {
                return true
            } else {
                set.add(p1)
            }
            p1 = p1.next
        }
        return false
    }
}

fun main() {
    val head = ListNode(3)
    var p1 = head
    p1.next = ListNode(2)
    val p2 = p1.next
    p1 = p1.next!!
    p1.next = ListNode(0)
    p1 = p1.next!!
    p1.next = ListNode(-4)
    p1 = p1.next!!
    p1.next = p2
    val solution = CycleList141()
    println("has cycle is ${solution.hasCycle(head)}")

}