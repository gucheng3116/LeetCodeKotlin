class AddTwoNumbersLink2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        if (l1 == null && l2 == null) {
            return null
        }
        var sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        val head = ListNode(sum % 10)
        carry = if (sum > 9) {
            1
        } else {
            0
        }
        var p1 = l1?.next
        var p2 = l2?.next
        var p3 = head
        while (p1 != null  || p2 != null) {
            sum = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + carry
            val node = ListNode(sum % 10)
            carry = if (sum > 9) {
                1
            } else {
                0
            }
            p3.next = node
            p3 = node
            p1 = p1?.next
            p2 = p2?.next
        }
        if (carry == 1) {
            val tail = ListNode(1)
            p3.next = tail
        }
        return head
    }
}

fun main() {

}