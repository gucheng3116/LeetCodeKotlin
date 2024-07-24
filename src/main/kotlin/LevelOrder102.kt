import java.util.LinkedList

class LevelOrder102 {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        val list = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val levelNodeList = mutableListOf<TreeNode>()
            val levelValueList = mutableListOf<Int>()
            queue.forEach {
                levelNodeList.add(it)
                levelValueList.add(it.`val`)
            }
            list.add(levelValueList)
            queue.clear()
            levelNodeList.forEach {
                if (it.left != null) {
                    queue.add(it.left!!)
                }
                if (it.right != null) {
                    queue.add(it.right!!)
                }
            }
        }
        return list
    }
}

fun main() {
    val treeNode3 = TreeNode(3)
    treeNode3.left = TreeNode(9)
    val treeNode20 = TreeNode(20)
    treeNode3.right = treeNode20
    treeNode20.left = TreeNode(15)
    treeNode20.right = TreeNode(7)
    val solution = LevelOrder102()
    solution.levelOrder(treeNode3)
}