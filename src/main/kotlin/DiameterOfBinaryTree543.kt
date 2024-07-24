class DiameterOfBinaryTree543 {
    private var ans = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        ans = 0
        if (root == null) {
            return 0
        }
        deepOfTree(root)
        return ans
    }

    fun deepOfTree(root:TreeNode?):Int {
        if (root == null) {
            return 0
        }
        val leftDeep = deepOfTree(root.left)
        val rightDeep = deepOfTree(root.right)
        ans = ans.coerceAtLeast(leftDeep + rightDeep)
        return 1 + leftDeep.coerceAtLeast(rightDeep)
    }
}

fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    val solution = DiameterOfBinaryTree543()
    println("deep is ${solution.deepOfTree(root)}")
    root.right!!.left = TreeNode(3)
    println("deep is ${solution.deepOfTree(root)}")
    println("diameterOfBinaryTree is ${solution.diameterOfBinaryTree(root)}")
    println("diameterOfBinaryTree is ${solution.diameterOfBinaryTree(null)}")
    println("diameterOfBinaryTree is ${solution.diameterOfBinaryTree(TreeNode(6))}")
    val root6 = TreeNode(6)
    root6.left = TreeNode(7)
    println("diameterOfBinaryTree is ${solution.diameterOfBinaryTree(root6)}")

}