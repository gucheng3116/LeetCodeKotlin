class MergeTwoLists21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        var p1:ListNode? = null
        var p2:ListNode? = null
        var result:ListNode? = null
        if (list1.`val` >= list2.`val`) {
            p1 = list1
            p2 = list2
            result = list2
        } else {
            p1 = list2
            p2 = list1
            result = list1
        }
//        var p2Pre = p2
        while (p1 != null && p2 != null) {
            when {
                p2.next == null -> {
                    p2.next = p1
                    break
                }
                p1.`val` >= p2.`val` && p1.`val` < (p2.next?.`val` ?: Int.MAX_VALUE) -> {
                    val temp = p1
                    p1 = p1.next
                    temp.next = p2.next
                    p2.next = temp
                    p2 = temp
                }
                else -> {
                    p2 = p2.next
                }
            }
        }
        return result
    }
}

fun main() {
    val list1 = ListNode(5)
    list1.next = ListNode(6)
    val list2 = ListNode(1)
    list2.next = ListNode(3)
    val solution = MergeTwoLists21()
    val listMerge = solution.mergeTwoLists(list1, list2)
    var p = listMerge
    while (p!= null) {
        print("${p.`val`},")
        p = p.next
    }
    println("")
}