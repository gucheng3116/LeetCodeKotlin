import java.util.*

class Palindrome234 {
    fun isPalindrome(head: ListNode?): Boolean {
       val stack = Stack<ListNode>()
        var p1 = head
        while (p1 != null) {
            stack.push(p1)
            p1 = p1.next
        }
        p1 = head
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (top.`val` != p1?.`val`) {
                return false
            }
            p1 = p1.next
        }
        return true
    }
}

fun main() {
   val head = ListNode(1)
    head.next = ListNode(2)
    var p1 = head.next
    p1?.next = ListNode(2)
    p1 = p1?.next
    p1?.next = ListNode(1)
//    p1?.next = ListNode(2)
    val solution = Palindrome234()
    println("isPalindrome is ${solution.isPalindrome(head)}")
    println("isPalindrome is ${solution.isPalindrome(null)}")
    println("isPalindrome is ${solution.isPalindrome(ListNode(5))}")

}