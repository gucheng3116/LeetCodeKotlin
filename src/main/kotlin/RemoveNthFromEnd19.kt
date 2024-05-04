class RemoveNthFromEnd19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (n <= 0) {
            return head
        }
        var p = head
        var p1 = head
        var pre = p
        for (i in 1 until n) {
            if (p1?.next != null) {
                p1 = p1.next
            }
        }
        if (p1?.next != null) {
            p1 = p1.next
            p = p?.next
        }
        while (p1?.next != null) {
            p1 = p1.next
            p = p?.next
            pre = pre?.next

        }
        if (pre == p) {
            return p?.next
        } else {
            pre?.next = p?.next
        }
        return head
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    val solution = RemoveNthFromEnd19()
    val result = solution.removeNthFromEnd(head, 3)
    var p = result
    while (p != null) {
        print("${p.`val`},")
        p = p.next
    }
    val head2 = ListNode(5)
    val result2 = solution.removeNthFromEnd(head2, 1)
    p = result2
    while (p != null) {
        print("${p.`val`},")
        p = p.next
    }

}