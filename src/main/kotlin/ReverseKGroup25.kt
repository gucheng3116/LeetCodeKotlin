class ReverseKGroup25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return head
        }
        var pre = ListNode(0)
        var pPartHead = head
        var pTail = head
        for (i in 1 until k) {
            pTail = pTail?.next
        }
        if (pTail == null) {
            return head
        }
        val pNewHead = pTail
        while (pPartHead != null && pTail != null) {
            val pFirst = reverseLinkList(pPartHead, pTail)
            pre.next = pFirst
            pre = pPartHead
            pPartHead = pPartHead.next
            pTail = pPartHead
            for (i in 1 until k) {
                pTail = pTail?.next
            }
        }
//        var p1 = pNewHead
//        while (p1 != null) {
//            print("${p1.`val`},")
//            p1 = p1.next
//        }
//        println()
        return pNewHead
    }

    fun reverseLinkList(head: ListNode?, tail:ListNode?): ListNode? {
        if (head == null || tail == null) {
            return null
        }
        var pNewHead: ListNode? = head
        val pre = ListNode(0)
        val p1 = head
        while (p1.next != null && pNewHead != tail) {
            pre.next = p1.next
            p1.next = p1.next!!.next
            pre.next!!.next = pNewHead
            pNewHead = pre.next

        }
        return pNewHead
    }
}

fun main() {
    val solution = ReverseKGroup25()
    val head = ListNode(1)
    val p2 = ListNode(2)
    val p3 = ListNode(3)
    val p4 = ListNode(4)
    val p5 = ListNode(5)
    head.next = p2
    p2.next = p3
    p3.next = p4
    p4.next = p5
//    solution.reverseLinkList(head, p3)
    solution.reverseKGroup(head, 3)
}