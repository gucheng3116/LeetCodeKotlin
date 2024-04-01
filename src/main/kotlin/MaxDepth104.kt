// Question 104
class MaxDepth104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return visit(root, 1)
    }

    private fun visit(root: TreeNode?, level: Int): Int {
        if (root == null) {
            return level
        }
        return if (root.left != null || root.right != null) {
            visit(root.left, level + 1).coerceAtLeast(visit(root.right, level + 1))
        } else {
            level
        }
    }
}

fun main() {
    val root = create(arrayOf(3, 9, 20, null, null, 15, 7))
    val maxDepth104 = MaxDepth104()
    var length = maxDepth104.maxDepth(root)
    println("length is $length")
    length = maxDepth104.maxDepth(null)
    println("length is $length")
    length = maxDepth104.maxDepth(TreeNode(2))
    println("length is $length")
    val root2 = create(arrayOf(1, null, 2))
    println("length is ${maxDepth104.maxDepth(root2)}")

}