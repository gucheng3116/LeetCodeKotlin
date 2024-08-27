class MaxPathSum124 {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var max = root.`val`
        val nodeList = mutableListOf<TreeNode>()
        lastOrderVisit(root, nodeList)
        nodeList.forEach {
            max = max.coerceAtLeast(it.`val` + nodeGain(it.left)+ nodeGain(it.right))
        }
        return max
    }

    fun lastOrderVisit(root:TreeNode?, list: MutableList<TreeNode>) {
        if (root == null) {
            return
        }
        if (root.left != null) {
            lastOrderVisit(root.left, list)
        }
        root.right?.let {
            lastOrderVisit(it, list)
        }
        list.add(root)
    }

    fun nodeGain(node:TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftGain = nodeGain(node.left).coerceAtLeast(0)
        val rightGain = nodeGain(node.right).coerceAtLeast(0)
        return (node.`val` + leftGain.coerceAtLeast(rightGain)).coerceAtLeast(0)
    }
}