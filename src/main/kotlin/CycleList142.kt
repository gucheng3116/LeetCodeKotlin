class CycleList142 {
    fun detectCycle(head: ListNode?): ListNode? {
        val set = HashSet<ListNode>()
        var p = head
        while ( p != null) {
            if (set.contains(p)) {
                return p
            }
            set.add(p)
            p = p.next
        }
        return null
    }
}