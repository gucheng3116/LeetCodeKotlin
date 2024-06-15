class SwapPairs24 {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val pNewHead = head.next
        var p1 = head
        var p2 = head.next
        var pre = ListNode(0)
        while (p1!= null && p2 != null) {
            pre.next = p2
            pre = p1
            p1.next = p2.next
            p2.next = p1
            p1 = p1.next
            p2 = p1?.next
        }
        if (p1 != null) {
            pre.next = p1
        }
        return pNewHead
    }
}

fun main() {
    val solution = SwapPairs24()
    val head = ListNode(1)
    val p2 = ListNode(2)
    val p3 = ListNode(3)
    val p4 = ListNode(4)
    head.next = p2
    p2.next = p3
    p3.next = p4
    var p = solution.swapPairs(head)
    print("1234, result is ")
    while (p != null) {
        print("${p.`val`},")
        p = p.next
    }
    println()
    p = solution.swapPairs(null)
    print("null, result is ")
    while (p != null) {
        print("${p.`val`},")
        p = p.next
    }
    println()
    p = solution.swapPairs(ListNode(1))
    print("1, result is ")
    while (p != null) {
        print("${p.`val`},")
        p = p.next
    }

}