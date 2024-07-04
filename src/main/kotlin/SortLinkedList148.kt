class SortLinkedList148 {
    //InsertSort, overtime
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val pre = ListNode(0)
        pre.next = head
        var pLast = head
        var pNode:ListNode? = head.next
        while (pNode != null) {
//            pNode = pNode.next
            // remove pNode
            pLast?.next = pNode.next
            var pInsert = pre
            while (pInsert.next != null && pInsert.next!!.`val` < pNode.`val`) {
                pInsert = pInsert.next!!
            }
            if (pInsert.next == null) {
                pInsert.next = pNode
                pNode.next = null
            } else {
                pNode.next = pInsert.next
                pInsert.next = pNode
            }
            if (pNode == pLast?.next) {
                pLast = pNode
                pLast.next = pNode.next
                pNode = pNode.next

            } else {
                pNode = pLast?.next
            }
        }
        pNode = pre.next
//        println()
//        while (pNode != null) {
//            print("${pNode.`val`},")
//            pNode = pNode.next
//        }
        return pre.next
    }

    fun swap(last: ListNode, p1: ListNode, p2: ListNode) {
        p1.next = p2.next
        last.next = p2
        p2.next = p1
    }

    //overtime
    fun bubbleSort(head:ListNode?):ListNode? {
        if (head?.next == null) {
            return head
        }
        val pre = ListNode(0)
        pre.next = head
        var p1: ListNode = head
        var size = 1
        while (p1.next != null) {
            p1 = p1.next!!
            size++
        }
        for (i in 0 until size  - 1) {
            var pStart = pre.next
            var last = pre
            for (j in 0 .. size -i -2) {
                if (pStart!!.`val` > pStart!!.next!!.`val`) {
                    swap(last, pStart, pStart.next!!)
                }
                last = last.next!!
                pStart = last.next
            }
        }
//        var pNode = pre.next
//        println()
//        while (pNode != null) {
//            print("${pNode.`val`},")
//            pNode = pNode.next
//        }
        return pre.next
    }

    // time is ok
    fun mergeSort(head:ListNode?):ListNode? {
        if (head?.next == null) {
            return head
        }
        var fast = head.next
        var snow = head
        while (fast?.next != null) {
            fast = fast.next
            snow = snow?.next
            if (fast?.next != null) {
                fast = fast!!.next!!
            }
        }
//        var mid = snow

        val right = mergeSort(snow?.next)
        snow?.next = null
        val left = mergeSort(head)
        return mergeList(left, right)
    }

    fun mergeList(left: ListNode?, right: ListNode?): ListNode? {
        if (left == null) {
            return right
        }
        if (right == null) {
            return left
        }
        val pre = ListNode(0)
        var p1 = left
        var p2 = right
        var last = pre
        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                last.next = p1
                last = p1
                p1 = p1.next
            } else {
                last.next = p2
                last = p2
                p2 = p2.next
            }
        }
        if (p1 == null) {
            last.next = p2
        } else {
            last.next = p1
        }
//        p1 = pre.next
//        println()
//        while (p1 != null) {
//            print("${p1.`val`},")
//            p1 = p1.next
//        }
        return pre.next
    }

}

fun main() {
    val solution = SortLinkedList148()

    val head = ListNode(-1)
    val p2 = ListNode(5)
    val p3 = ListNode(3)
    val p4 = ListNode(4)
    val p5 = ListNode(0)
    head.next = p2
    p2.next = p3
    p3.next = p4
    p4.next = p5
    var p1 = solution.mergeSort(head)
    println()
    while (p1 != null) {
        print("${p1.`val`},")
        p1 = p1.next
    }
}