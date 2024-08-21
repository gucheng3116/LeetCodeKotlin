class BuildTree105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val pre = TreeNode(0)
        buildTreeNode(pre, preorder, inorder, true)
        return pre.left
    }

    fun buildTreeNode(parent: TreeNode, preorder: IntArray, inorder: IntArray, isLeft: Boolean) {
        if (preorder.isEmpty()) {
            return
        }
        val node = TreeNode(preorder[0])
        if (isLeft) {
            parent.left = node
        } else {
            parent.right = node
        }
        if (preorder.size == 1) {
            return
        }
        val index = inorder.indexOf(preorder[0])

        if (index == -1) {
            return
        }
        buildTreeNode(node, preorder.copyOfRange(1, index + 1), inorder.copyOfRange(0, index), true)
        buildTreeNode(node, preorder.copyOfRange(index+1, preorder.size), inorder.copyOfRange(index+ 1, inorder.size), false)
    }
}

fun main() {
    var root = TreeNode(1)
    val pre = root
    root = TreeNode(2)
    println("pre:${pre.`val`}, root:${root.`val`}")
}