//Question 160
class GetIntersectionNode160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }
        val set = HashSet<ListNode>()
        var pNode = headA
        while (pNode != null) {
            set.add(pNode)
            pNode = pNode.next
        }
        var bNode = headB
        while (bNode != null) {
            if (set.contains(bNode)) {
                return bNode
            }
            bNode = bNode.next
        }
        return null
    }
}

//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

fun main() {
    val headA = ListNode(5)
    val node = ListNode(4)
    val node2 = ListNode(2)
    val headB = ListNode(3)
    headA.next = node
    node.next = node2
    val solution = GetIntersectionNode160()
    println("intersection node is ${solution.getIntersectionNode(headA, headB)?.`val`}")
    headB.next = node
    println("intersection node is ${solution.getIntersectionNode(headA, headB)?.`val`}")
}