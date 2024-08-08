class FlattenBinaryTree114 {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        val list = ArrayList<TreeNode>()
        firstRootVisit(root, list)
        list.forEach {
            it.left = null
        }
        if (list.size == 1) {
            return
        }
        for (i in 0 until list.size - 1) {
            list[i].right = list[i + 1]
        }
    }

    fun firstRootVisit(root: TreeNode?, list : ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        list.add(root)
        firstRootVisit(root.left, list)
        firstRootVisit(root.right, list)
    }
}