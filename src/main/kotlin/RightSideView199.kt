import java.util.*
import kotlin.collections.ArrayList

class RightSideView199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val list = arrayListOf<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        orderVisit(queue, list)
        return list
    }

    private fun orderVisit(queue: Queue<TreeNode>, list: ArrayList<Int>) {
        if (queue.isEmpty()) {
            return
        }
        val levelList = ArrayList<TreeNode>()
        while (queue.isNotEmpty()) {
            levelList.add(queue.poll())
        }
        if (levelList.isNotEmpty()) {
            list.add(levelList[levelList.lastIndex].`val`)
        }
        levelList.forEach { node ->
            node.left?.let {
                queue.add(it)
            }
            node.right?.let {
                queue.add(it)
            }
        }
        orderVisit(queue, list)
    }
}