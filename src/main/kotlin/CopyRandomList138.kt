class CopyRandomList138 {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }
        var p1 = node
        val pNewHead = Node(p1.`val`)
        var p2:Node? = pNewHead
        val nodeMap = HashMap<Node,Node?>()
        nodeMap[p1] = p2
        while (p1!!.next != null) {
            p1 = p1.next
            val node = Node(p1!!.`val`)
            p2?.next = node
            p2 = node
            nodeMap[p1] = p2
        }
        p1 = node
        p2 = pNewHead
        while (p1 != null) {
            p2?.random = nodeMap[p1.random]
            p1 = p1.next
            p2 = p2?.next
        }
        return pNewHead
    }
}

class Node(var `val`: Int) {
        var next: Node? = null
         var random: Node? = null
}