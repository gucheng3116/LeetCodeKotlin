import sun.misc.Queue
import java.util.LinkedList
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class FindElements(val root: TreeNode?) {

    init {
        reset(root, null, true)
    }

    fun find(target: Int): Boolean {

        return visit(target, root)
    }

    fun reset(root: TreeNode?, parent: TreeNode?, isLeft: Boolean) {
        if (root == null) {
            return
        }
        if (parent == null) {
            root.`val` = 0
        } else {
            val count = if (isLeft) {
                1
            } else {
                2
            }
            root.`val` = 2 * parent.`val` + count
        }
        reset(root.left, root, true)
        reset(root.right, root, false)
    }

    fun visit(target: Int, root: TreeNode?) : Boolean {
        if (root == null) {
            return false
        }
//        println("root val is ${root.`val`}")
        if (root.`val` == target) {
            return true
        }
        val leftResult = visit(target, root.left)
        val rightResult = visit(target, root.right)
        return leftResult || rightResult
    }
}

fun main() {
//    val root = TreeNode(-1)
//    root.right = TreeNode(-1)
//    var pNode = root.right
//    pNode?.left = TreeNode(-1)
//    pNode?.left?.left = TreeNode(-1)

    val root = create(arrayOf(-1, null, -1, -1, null, -1))
     FindElements(root)
//    val result = obj.find(5)
    levelOrderVisit(root)
//    print("result is $result")
}

fun levelOrderVisit(root: TreeNode?) {
    if (root == null) {
        return
    }
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (!queue.isEmpty()) {
        val node = queue.poll()
        println("node is ${node.`val`}")
        if (node.left != null) {
            queue.add(node.left!!)
        }
        if (node.right != null) {
            queue.add(node.right!!)
        }
    }
}

fun create(array: Array<Int?>) : TreeNode? {
    if (array.size == 0 || array[0] == null) {
        return null
    }
    val iterator = array.iterator()
    val root = TreeNode(iterator.next()!!)
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while(iterator.hasNext()) {
        val node = queue.poll()
        val itemLeft = iterator.next()
        if (itemLeft != null) {
            node.left = TreeNode(itemLeft)
            queue.add(node.left!!)
        }
        if (iterator.hasNext()) {
            val itemRight = iterator.next()
            if (itemRight != null) {
                node.right = TreeNode(itemRight)
                queue.add(node.right!!)
            }
        }
    }
    return root
}
/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = FindElements(root)
 * var param_1 = obj.find(target)
 */