class InOrderTravesal94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        visit(root, list)
        return list
    }

    fun visit(root: TreeNode?, list: ArrayList<Int>) {
        if (root != null) {
            visit(root.left, list)
        }
        if (root != null) {
            list.add(root.`val`)
        }
        if (root != null) {
            visit(root.right, list)
        }
    }
}

