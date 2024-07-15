class MergeKLists23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        if (lists.size == 1) {
            return lists[0]
        }
        var list = lists[0]
        for (i in 1 until lists.size) {
            list = mergeTwoList(list, lists[i])
        }
        return list
    }

    private fun mergeTwoList(list1:ListNode?, list2:ListNode?):ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        val pre = ListNode(0)
        var last = pre
        var p1 = list1
        var p2 = list2
        while(p1 != null && p2 != null) {
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
        return pre.next
    }
}