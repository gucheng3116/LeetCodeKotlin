import java.util.*

class IsSymmetric101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val leftQueue = LinkedList<TreeNode?>()
        val rightQueue = LinkedList<TreeNode?>()
        leftQueue.add(root.left)
        rightQueue.add(root.right)
        val leftList = leftVisit(leftQueue)
        val rightList = rightVisit(rightQueue)
        if (leftList.size != rightList.size) {
            return false
        }
        for (i in leftList.indices) {
            if (leftList[i]?.`val` != rightList[i]?.`val`) {
                return false
            }
        }
        return true
    }

    fun leftVisit(leftQueue: LinkedList<TreeNode?>): ArrayList<TreeNode?> {
        val list = ArrayList<TreeNode?>()
        while (leftQueue.isNotEmpty()) {
            val node = leftQueue.poll()
            list.add(node)
            if (node != null) {
                leftQueue.add(node.left)
//                list.add(node.left)
                leftQueue.add(node.right)
//                list.add(node.right)
            }
        }
        println("left is ")
        for (item in list) {
            print("${item?.`val`},")
        }
        return list
    }

    fun rightVisit(rightQueue: LinkedList<TreeNode?>): ArrayList<TreeNode?> {
        val list = ArrayList<TreeNode?>()
        while (rightQueue.isNotEmpty()) {
            val node = rightQueue.poll()
            list.add(node)
            if (node != null) {
                rightQueue.add(node.right)
//                list.add(node.right)
                rightQueue.add(node.left)
//                list.add(node.left)
            }
        }
        println("right is ")
        for (item in list) {
            print("${item?.`val`},")
        }
        return list
    }
}

fun main() {
    val solution = IsSymmetric101()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = null
    root.left!!.right = TreeNode(3)
    root.right = TreeNode(2)
    root.right!!.left = null
    root.right!!.right = TreeNode(3)
    println("result is ${solution.isSymmetric(root)}")
}