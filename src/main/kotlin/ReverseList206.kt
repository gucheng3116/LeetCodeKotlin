/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ReverseList206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        var pre = head
        var current = head?.next
        var nextNode = current?.next


        while (current != null) {
               current.next = pre
               pre = current
               current = nextNode
               nextNode = nextNode?.next
        }
        head.next = null
        return pre
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    var pNode : ListNode? = head
    for (i in 0 until 4) {
        pNode?.next = ListNode(i + 2)
        pNode = pNode?.next
    }
    var p1:ListNode? = head
    while(p1 != null) {
        print("${p1.`val`},")
        p1 = p1.next
    }
    val solution = ReverseList206()
    val newHead = solution.reverseList(head)
    p1 = newHead
    while(p1 != null) {
        print("${p1.`val`},")
        p1 = p1.next
    }
}